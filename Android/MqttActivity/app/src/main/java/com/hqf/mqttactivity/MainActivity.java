package com.hqf.mqttactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MainActivity extends AppCompatActivity {
    MyMQTTService myMQTTService;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //按键发布消息
        Button button1 = (findViewById(R.id.button1));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMQTTService.publishMessage();
            }
        });
    }

    private void makeToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
        TextView textView = (TextView)findViewById(R.id.textView1);
        textView.setText(str);
    }

    //MyMQTTService连接回调
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myMQTTService = ((MyMQTTService.MyBinder)service).getService();
            Log.i(TAG, "onServiceConnected: ok");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: fail");
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(MainActivity.this, MyMQTTService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);//自动创建
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);
    }
}
