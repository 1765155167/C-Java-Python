package com.hqf.servicedemo.download;

public interface DownloadListener {

    void onProgress(int progress);//用于通知当前下载进度

    void onSuccess();//用于通知下载成功

    void onFailed();//用于通知下载失败

    void onPaused();//用于通知下载暂停

    void onCanceled();//用于通知下载取消

}
