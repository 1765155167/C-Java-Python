package com.hqf.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    final int NOTIFYID = 0x123;//通知id
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotification();
        //获取通知管理器，用于发送通知
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder notification = new Notification.Builder(this); // 创建一个Notification对象
        // 设置打开该通知，该通知自动消失
        notification.setAutoCancel(true);
        // 设置通知的图标
        notification.setSmallIcon(R.drawable.packet);
        // 设置通知内容的标题
        notification.setContentTitle("奖励百万红包！！！");
        // 设置通知内容
        notification.setContentText("点击查看详情！");
//        //设置使用系统默认的声音、默认震动
//        notification.setDefaults(Notification.DEFAULT_SOUND
//                | Notification.DEFAULT_VIBRATE);
//        //设置发送时间
//        notification.setWhen(System.currentTimeMillis());
        // 创建一个启动其他Activity的Intent
//        Intent intent = new Intent(MainActivity.this
//                , DetailActivity.class);
//        PendingIntent pi = PendingIntent.getActivity(
//                MainActivity.this, 0, intent, 0);
//        //设置通知栏点击跳转
//        notification.setContentIntent(pi);
        //发送通知
        notificationManager.notify(NOTIFYID, notification.build());
    }
    private void sendNotification() {
        //获取NotificationManager实例
        NotificationManager notifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //实例化NotificationCompat.Builde并设置相关属性
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                //设置小图标
                .setSmallIcon(R.drawable.packet)
                //设置通知标题
                .setContentTitle("最简单的Notification")
                //设置通知内容
                .setContentText("只有小图标、标题、内容");
        //设置通知时间，默认为系统发出通知的时间，通常不用设置
        //.setWhen(System.currentTimeMillis());
        //通过builder.build()方法生成Notification对象,并发送通知,id=1
        notifyManager.notify(1, builder.build());
    }
}
