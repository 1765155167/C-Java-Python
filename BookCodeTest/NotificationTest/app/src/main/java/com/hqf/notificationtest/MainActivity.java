package com.hqf.notificationtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private static final String CHANNEL_ID = "123";
    public static final int notificationId = 0x123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                PendingIntent pd = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setAutoCancel(true)//设置通知自动取消
                        .setContentTitle("通知标题")
                        .setContentText("通知内容")
//                        .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn 111" +
//                                "111111111111111111111111111111111111111111111111111111111" +
//                                "1111111111111111111111111111111111111111111111111111111111"))
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(
                                getResources(), R.mipmap.bi
                        )))
                        //通知声音
                        //.setSound(Uri.fromFile(new File("system/media/audio/ringtones/Luna.ogg")))
                        //.setVibrate(new long[]{0, 1000, 1000, 1000})//震动 需要权限
                        //.setLights(Color.GREEN, 1000, 1000)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setContentIntent(pd)
                        .setPriority(NotificationCompat.PRIORITY_MAX);//通知权限
                //显示通知
                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
                // notificationId is a unique int for each notification that you must define
                notificationManager.notify(notificationId, builder.build());
                break;
            default:
                break;
        }
    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
