package com.hqf.activitylifecycletest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: Task id is " + getTaskId());
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            String tempData = savedInstanceState.getString("key_data");
            Toast.makeText(this, tempData, Toast.LENGTH_SHORT).show();
        }
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(l);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(l);
    }

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (((Button)v).getId())
            {
                case R.id.button1:
                    SecondActivity.actionStart(MainActivity.this, "data1", "data2");
                    break;
                case R.id.button2:
                    MainActivity.actionStart(MainActivity.this);
                    break;
            }
        }
    };

    //启动本项目的方法
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: 开启");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: 重启");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: 停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 销毁");
    }
    //活动在回收之前会被调用
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "Something you just typed";
        outState.putString("data_key", tempData);
    }
}
