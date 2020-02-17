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

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

import javax.xml.parsers.SAXParserFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class SAXXMLActivity extends AppCompatActivity {

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
        responseText = (TextView) findViewById(R.id.sax_response_text);
        urlEdit = (EditText) findViewById(R.id.sax_url_edit);
        urlEdit.setText("http://192.168.0.107/get_data.xml");
        Button send = (Button) findViewById(R.id.sax_send_request);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.sax_send_request) {
                    HttpUtil.sendHttpRequest(urlEdit.getText().toString(), new HttpCallBackListener() {
                        @Override
                        public void onFinish(String response) {
                            parseXMLWithSAX(response);
                        }

                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                        }
                    });
                    Toast.makeText(SAXXMLActivity.this, "click", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //解析xml文件
    private void parseXMLWithSAX(String xmlData) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler(new SAXCallBack() {
                @Override
                public void execute(String data) {
                    showResponse(data);
                }
            });
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
