package com.hqf.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.xmlpull.v1.XmlPullParser.END_TAG;

public class PullXMLActivity extends AppCompatActivity {
    private static final String TAG = "PullXMLActivity";
    private TextView responseText;
    private EditText urlEdit;
    private String xmlText = "<apps>\n" +
            "<app>\n" +
            "<id>1</id>\n" +
            "<name>Google Maps</name>\n" +
            "<version>1.0</version>\n" +
            "</app>\n" +
            "<app>\n" +
            "<id>2</id>\n" +
            "<name>Chrome</name>\n" +
            "<version>2.1</version>\n" +
            "</app>\n" +
            "<app>\n" +
            "<id>3</id>\n" +
            "<name>Google Play</name>\n" +
            "<version>2.3</version>\n" +
            "</app>\n" +
            "</apps>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_xml);
        responseText = (TextView) findViewById(R.id.pull_response_text);
        urlEdit = (EditText) findViewById(R.id.pull_url_edit);
        urlEdit.setText("http://192.168.0.107/get_data.xml");
        Button send = (Button) findViewById(R.id.pull_send_request);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.pull_send_request) {
                    sendRequestWithOkHttp();
                    Toast.makeText(PullXMLActivity.this, "click", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                parseXMLWithPull(xmlText);
                try {
                    OkHttpClient client = new OkHttpClient();//创建实例
                    //创建一个请求
                    Request request = new Request.Builder()
                            .url(urlEdit.getText().toString())
                            .build();
                    //发送请求并且获取服务器返回道数据
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();
                    //parseXMLWithPull(responseData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //解析xml文件
    private void parseXMLWithPull(String xmlData) {
        StringBuilder sb = new StringBuilder();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    //开始解析某个节点
                    case XmlPullParser.START_TAG: {
                        if ("id".equals(nodeName)) {
                            id = xmlPullParser.nextText();
                        } else if ("name".equals(nodeName)) {
                            name = xmlPullParser.nextText();
                        } else if ("version".equals(nodeName)) {
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }
                    //完成解析某个节点
                    case XmlPullParser.END_TAG: {
                        if ("app".equals(nodeName)) {
                            Log.d(TAG, "id is " + id);
                            Log.d(TAG, "name is " + name);
                            Log.d(TAG, "version is " + version);
                            sb.append("id:" + id + " name:" + name + " version:" + version+"\n");
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showResponse(sb.toString());
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, PullXMLActivity.class);
        context.startActivity(intent);
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
