package com.hqf.iot.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.hqf.iot.R;
import com.hqf.iot.debug.ToastNew;
import com.hqf.iot.device.Device;
import com.hqf.iot.device.Led;
import com.hqf.iot.infoManager.InfoCheck;
import com.hqf.iot.service.MyMQTTService;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MenuActivity extends AppCompatActivity {
    private static final String TAG = "MenuActivity";
    MyMQTTService myMQTTService;
    String serverUri;
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
        Toolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ledInit();
        for (int i = 0; i < led.length; i++) {
            final ImageButton ledView = findViewById(led[i].getId());
            ledView.setOnClickListener(clickListener);
        }
        //获取IP地址
        Intent intent = getIntent();
        serverUri = intent.getStringExtra("TCP");
        ToastNew.makeText(serverUri);
    }

    //启动本活动方法
    public static void actionStart(Context context, String serverUri) {
        Intent intent = new Intent(context, MenuActivity.class);
        intent.putExtra("TCP", serverUri);
        context.startActivity(intent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
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
            myMQTTService.init(mqttCallbackExtended, serverUri);
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
            byte[] readMessage = message.getPayload();
            ToastNew.makeText(new String(readMessage));
//            InfoCheck.Format format = InfoCheck.infoDecrypt(readMessage);
//            if (format != null) {
//                if (format.ack_byte == InfoCheck.ACK_NEED) {
//                    InfoCheck.sendAck(myMQTTService);
//                }
//                if (format.tye == InfoCheck.INFO_STR) {
//                    infoProcess(new String(format.data));
//                }
//            } else {
//                ToastNew.makeText("接受数据，校验失败！");
//            }
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

    //接收到的信息处理函数
    private void infoProcess(String message) {
        ToastNew.makeText(message);
        Gson json = new Gson();
        Device dev = json.fromJson(message, Device.class);
        if (dev.getDevType().equals(Device.DeviceType.LED)) {
            for (int i = 0; i < led.length; i++) {
                if (dev.getId() == led[i].getId()) {
                    ToastNew.makeText(led[i].getDevType());
                    ImageView imageView = findViewById(led[i].getId());
                    if (dev.isOpen()) {
                        led[i].setOpen(myMQTTService);
                        Glide.with(this).load(R.drawable.play).into(imageView);
                        ToastNew.makeText("开灯");
                    } else {
                        led[i].setClose(myMQTTService);
                        Glide.with(this).load(R.drawable.stop).into(imageView);
                        ToastNew.makeText("关灯");
                    }
                }
            }
        } else if (dev.getDevType() == Device.DeviceType.DOOR) {

        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
