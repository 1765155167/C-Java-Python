package com.hqf.servicedemo.threadTest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hqf.servicedemo.logControl.MyToast;

public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

    private ProgressDialog progressDialog;
    private Context context;

    public DownloadTask(Context context) {
        this.context = context;
    }

    //后台任务开始执行之前调用 用于界面上的初始化操作
    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("download");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.show();
    }
    //后台任务执行完毕并且通过return返回时调用
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        progressDialog.dismiss();
        if (aBoolean) {
            MyToast.makeText(context, "Download succeeded");
        } else {
            MyToast.makeText(context, "Download failed");
        }
    }
    //更新界面信息
    @Override
    protected void onProgressUpdate(Integer... values) {
        progressDialog.setMessage("DownLoad"+values[0]+"%");
    }
    //处理任务 通过publishProgress()方法来个更新ui
    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            while (true) {
                int downloadPercent = doDownload();
                publishProgress(downloadPercent);
                if (downloadPercent >= 100) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private int progress = 0;
    private int doDownload() throws InterruptedException {
        progress += 10;
        Thread.sleep(1000);
        return progress;
    }
}
