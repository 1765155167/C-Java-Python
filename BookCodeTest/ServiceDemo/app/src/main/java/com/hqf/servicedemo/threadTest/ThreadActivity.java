package com.hqf.servicedemo.threadTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hqf.servicedemo.R;
import com.hqf.servicedemo.activityControl.BaseActivity;
import com.hqf.servicedemo.logControl.MyToast;

import java.io.InputStream;


/**
 * 1.Message是在线程之间传递的消息，what、arg1、arg2携带整形数据，obj携带Object对象
 * 2.Handler主要用于发送和处理消息
 * 3.MessageQueue消息队列，用于存放所有通过Handler发送的消息
 * 4.Looper是每个线程中MessageQueue的管家，
 */
public class ThreadActivity extends BaseActivity {

    private TextView textView;
    public static final int UPDATE_TEXT = 1;
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == UPDATE_TEXT) {
                textView.setText("Nice to meet you");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.change_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
                new DownloadTask(ThreadActivity.this).execute();
            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, ThreadActivity.class);
        context.startActivity(intent);
    }
}
