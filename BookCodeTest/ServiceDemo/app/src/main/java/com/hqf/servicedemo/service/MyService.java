package com.hqf.servicedemo.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.hqf.servicedemo.MainActivity;
import com.hqf.servicedemo.R;

import java.io.File;

public class MyService extends Service {

    private static final String CHANNEL_ID = "123";
    private static final String TAG = "MyService";
    private DownloadBinder binder;

    public MyService() {
        binder = new DownloadBinder();
    }

    class DownloadBinder extends Binder {

        public void startDownload() {
            Log.d(TAG, "startDownload: executed");
        }

        public int getProgress() {
            Log.d(TAG, "getProgress: executed");
            return 0;
        }

        public void stopDownload() {
            Log.d(TAG, "stopDownload: executed");
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        Log.d(TAG, "onStartCommand: executed");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //处理的逻辑
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stopSelf();//关闭服务
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: executed");
    }
}
