package com.hqf.servicedemo.download;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.hqf.servicedemo.R;
import com.hqf.servicedemo.logControl.MyToast;

import java.io.File;

public class DownloadService extends Service {

    private static final String CHANNEL_ID = "123";
    private DownloadTask downloadTask;

    private String downloadUrl;

    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(NOTIFICATION_ID, getNotification("Download...", progress));
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            //下载成功时将前台服务通知关闭，并创建一个下载成功的通知
            //stopForeground(true);
            getNotificationManager().notify(NOTIFICATION_ID, getNotification("Download Success", -1));
            MyToast.makeText(DownloadService.this, "Download Success");
        }

        @Override
        public void onFailed() {
            downloadTask = null;
            //下载失败时将前台服务通知关闭，并创建一个下载失败的通知
            //stopForeground(true);
            getNotificationManager().notify(NOTIFICATION_ID, getNotification("Download Failed", -1));
            MyToast.makeText(DownloadService.this, "Download Failed");
        }

        @Override
        public void onPaused() {
            downloadTask = null;
            MyToast.makeText(DownloadService.this, "Paused");
        }

        @Override
        public void onCanceled() {
            downloadTask = null;
            MyToast.makeText(DownloadService.this, "Canceled");
        }
    };

    private NotificationManagerCompat getNotificationManager() {
        //NotificationManager的兼容性库，具有较旧平台的后备功能。
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        return notificationManager;
    }

    private Notification getNotification(String title, int progress) {
        Intent intent;
        if (progress == -1) {//成功或者失败的通知
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("*/*");
            intent.addCategory(Intent.CATEGORY_OPENABLE); // 如果少了这句，有些机型上面不能正常打开文件管理器，比如金立
        } else {
            intent = new Intent(this ,DownloadActivity.class);
        }

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 , intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                        R.mipmap.ic_launcher))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setContentTitle(title);
        if (progress > 0) {
            //当进度大于0时才显示进度条
            builder.setContentText(progress + "%");
            builder.setProgress(100, progress, false);
        }
        return builder.build();
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

    private static final int NOTIFICATION_ID = 1001;
    class DownloadBinder extends Binder {

        public void startDownload(String url) {
            if (downloadTask == null) {
                downloadUrl = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadUrl);
                //startForeground(NOTIFICATION_ID, getNotification("Downloading...", 0));
                MyToast.makeText(DownloadService.this, "Downloading...");
            }
        }

        public void pauseDownload() {
            if (downloadTask != null) {
                downloadTask.pauseDownload();
            }
        }

        public void cancelDownload() {
            if (downloadTask != null) {
                downloadTask.cancelDownload();
            } else {
                if (downloadUrl != null) {
                    //取消下载时需要将文件删除，并将通知关闭
                    String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                    String directory = Environment.getExternalStoragePublicDirectory
                            (Environment.DIRECTORY_DOWNLOADS).getPath();
                    File file = new File(directory + fileName);
                    if (file.exists()) {//文件存在则删除
                        file.delete();
                    }
                    getNotificationManager().cancel(NOTIFICATION_ID);//关闭通知
                    //stopForeground(true);
                    MyToast.makeText(DownloadService.this, "Canceled");
                }
            }
        }
    }
    private DownloadBinder binder = new DownloadBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
}
