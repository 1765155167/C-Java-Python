package com.hqf.webview;

public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
