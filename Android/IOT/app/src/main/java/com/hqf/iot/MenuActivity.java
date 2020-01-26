package com.hqf.iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hqf.iot.debug.ToastNew;
import com.hqf.iot.device.Device;
import com.hqf.iot.device.Led;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MenuActivity";
    MyMQTTService myMQTTService;
    public Led[] led = new Led[6];

    private void ledInit() {
        led[0] = new Led(R.id.ledView1);
        led[1] = new Led(R.id.ledView2);
        led[2] = new Led(R.id.ledView3);
        led[3] = new Led(R.id.ledView4);
        led[4] = new Led(R.id.ledView5);
        led[5] = new Led(R.id.ledView6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ledInit();
        for (int i = 0; i < led.length; i++) {
            final ImageButton ledView = (ImageButton) findViewById(led[i].getId());
            ledView.setOnClickListener(clickListener);
        }
    }

    //启动本活动方法
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = ((ImageView) v).getId();
            for (int i = 0; i < led.length; i++) {
                if (id == led[i].getId()) {
                    if (!led[i].isOpen()) {
                        led[i].setOpen(myMQTTService);
                        ((ImageView) v).setImageResource(R.drawable.play);
                    } else {
                        led[i].setClose(myMQTTService);
                        ((ImageView) v).setImageResource(R.drawable.stop);
                    }
                }
            }
        }
    };

    //MyMQTTService连接回调
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myMQTTService = ((MyMQTTService.MyBinder) service).getService();
            myMQTTService.init(mqttCallbackExtended);
            Log.i(TAG, "onServiceConnected: ok");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: fail");
        }
    };

    //MQTT回调
    MqttCallbackExtended mqttCallbackExtended = new MqttCallbackExtended() {
        @Override
        public void connectComplete(boolean reconnect, String serverURI) {
        }

        @Override
        public void connectionLost(Throwable cause) {
        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            //收到消息
            String info = new String(message.getPayload());
            infoProcess(info);
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(MenuActivity.this, MyMQTTService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);//自动创建
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);
    }

    private void infoProcess(String message) {
        makeToast(message);
        Gson json = new Gson();
        Device dev = json.fromJson(message, Device.class);
        if (dev.getDevType() == Device.DeviceType.LED) {
            for (int i = 0; i < led.length; i++) {
                if (dev.getId() == led[i].getId()) {
                    ImageView imageView = (ImageView) findViewById(led[i].getId());
                    if (dev.isOpen()) {
                        led[i].setOpen(myMQTTService);
                        imageView.setImageResource(R.drawable.play);
                        makeToast("开灯");
                    } else {
                        led[i].setClose(myMQTTService);
                        imageView.setImageResource(R.drawable.stop);
                        makeToast("关灯");
                    }
                }
            }
        } else if (dev.getDevType() == Device.DeviceType.DOOR) {

        }
    }

    private void makeToast(String info) {
        ToastNew.makeText(MenuActivity.this, info, Toast.LENGTH_SHORT).show();
    }
}
