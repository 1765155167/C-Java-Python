package com.hqf.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.spec.ECField;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpActivity extends AppCompatActivity {

    private TextView responseText;
    private EditText urlEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        responseText = (TextView) findViewById(R.id.ok_http_response_text);
        urlEdit = (EditText) findViewById(R.id.ok_http_url_edit);
        urlEdit.setText("https://www.baidu.com/");
        Button send = (Button) findViewById(R.id.ok_http_send_request);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.ok_http_send_request) {
                    sendRequestWithOkHttp();
                    Toast.makeText(OkHttpActivity.this, "click", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, OkHttpActivity.class);
        context.startActivity(intent);
    }

    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();//创建实例
                    //创建一个请求
                    Request request = new Request.Builder()
                            .url(urlEdit.getText().toString())
                            .build();
                    //发送请求并且获取服务器返回道数据
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    showResponse(responseData);
//                    //POST
//                    RequestBody requestBody = new FormBody.Builder()
//                            .add("username", "admin")
//                            .add("password", "123456")
//                            .build();
//                    Request request1 =new Request.Builder()
//                            .url(urlEdit.getText().toString())
//                            .post(requestBody)
//                            .build();
//                    //发送请求并且获取服务器返回道数据
//                    Response response1 = client.newCall(request).execute();
//                    String responseData1 = response.body().string();
//                    showResponse(responseData1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {//将线程切换到主线程
            @Override
            public void run() {
                responseText.setText("");
                responseText.setText(response);
            }
        });
    }
}
