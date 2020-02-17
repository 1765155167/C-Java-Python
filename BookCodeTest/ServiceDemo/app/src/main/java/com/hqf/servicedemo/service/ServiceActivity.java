package com.hqf.servicedemo.service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hqf.servicedemo.R;
import com.hqf.servicedemo.activityControl.BaseActivity;
import com.hqf.servicedemo.logControl.MyToast;

public class ServiceActivity extends BaseActivity {

    private static final String TAG = "ServiceActivity";
    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder)service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
            downloadBinder.stopDownload();
            Log.d(TAG, "onServiceConnected: " + name);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: " + name);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, ServiceActivity.class);
        context.startActivity(intent);
    }

    public void onClick(View v) {
        Intent intent = new Intent(ServiceActivity.this, MyService.class);
        switch (v.getId()) {
            case R.id.start_service:
                startService(intent);
                break;
            case R.id.stop_service:
                stopService(intent);
                break;
            case R.id.bind_service:
                bindService(intent, connection, BIND_AUTO_CREATE);//绑定后自动创建服务
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}
