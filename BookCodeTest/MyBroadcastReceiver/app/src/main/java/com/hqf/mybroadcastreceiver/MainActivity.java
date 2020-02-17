package com.hqf.mybroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private IntentFilter intentFilter;
    private NetWorkChangeReceiver netWorkChangeReceiver;
    private MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册广播接收器
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netWorkChangeReceiver = new NetWorkChangeReceiver();
        registerReceiver(netWorkChangeReceiver, intentFilter);
        //注册广播接收器
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.hqf.MY_BROADCAST");
        receiver = new MyReceiver();
        registerReceiver(receiver, intentFilter2);
        //发送一条广播
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.hqf.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });
        //发送一条广播
        Button button1 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.hqf.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }

    class NetWorkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "网络状态该改变", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netWorkChangeReceiver);
        unregisterReceiver(receiver);
    }
}
