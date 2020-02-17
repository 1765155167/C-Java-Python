package com.hqf.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button webView = (Button) findViewById(R.id.web_view_test);
        Button http = (Button) findViewById(R.id.http_test);
        webView.setOnClickListener(this);
        http.setOnClickListener(this);
        Button okHttp = (Button) findViewById(R.id.ok_http);
        okHttp.setOnClickListener(this);
        Button pullXML = (Button) findViewById(R.id.xml);
        pullXML.setOnClickListener(this);
        Button saxXML = (Button) findViewById(R.id.sax);
        saxXML.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.web_view_test:
                WebViewActivity.actionStart(this);
                break;
            case R.id.http_test:
                HttpActivity.actionStart(this);
                break;
            case R.id.ok_http:
                OkHttpActivity.actionStart(this);
                break;
            case R.id.xml:
                PullXMLActivity.actionStart(this);
            case R.id.sax:
                SAXXMLActivity.actionStart(this);
            default:
                break;
        }
    }
}
