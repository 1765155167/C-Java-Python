package com.hqf.servicedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hqf.servicedemo.activityControl.BaseActivity;
import com.hqf.servicedemo.download.DownloadActivity;
import com.hqf.servicedemo.logControl.MyToast;
import com.hqf.servicedemo.service.ServiceActivity;
import com.hqf.servicedemo.threadTest.ThreadActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MyToast.closeLog();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.thread_button:
                ThreadActivity.actionStart(MainActivity.this);
                break;
            case R.id.service_button:
                ServiceActivity.actionStart(MainActivity.this);
                break;
            case R.id.download_button:
                //完整的下载实例，包含内容提供器、多媒体、网络和服务
                DownloadActivity.actionStart(MainActivity.this);
            default:
                break;
        }
    }
}
