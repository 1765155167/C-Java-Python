package com.hqf.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class HttpActivity extends AppCompatActivity {

    private TextView responseText;
    private EditText urlEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        responseText = (TextView) findViewById(R.id.response_text);
        urlEdit = (EditText) findViewById(R.id.url_edit);
        urlEdit.setText("https://www.baidu.com/");
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, HttpActivity.class);
        context.startActivity(intent);
    }

    public void sendRequest(View view) {
        if (view.getId() == R.id.send_request) {
            sendRequestWithHttpURLConnection();
            Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL(urlEdit.getText().toString());
                    connection = (HttpURLConnection) url.openConnection();
                    //推送信息
                    connection.setRequestMethod("POST");
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    out.writeBytes("username=18595801890&password=18595801890hu");
                    //获取信息
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();

                    //下面对获取输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line+"\n");
                    }
                    showResponse(response.toString());//显示
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
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
