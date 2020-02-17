package com.hqf.webview;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpUtil {
    public static void sendHttpRequest(final String address, final HttpCallBackListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();//创建实例
                    //创建一个请求
                    Request request = new Request.Builder()
                            .url(address)
                            .build();
                    //发送请求并且获取服务器返回道数据
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    listener.onFinish(responseData);
                    //parseXMLWithPull(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                    listener.onError(e);
                }
            }
        }).start();
    }
}
