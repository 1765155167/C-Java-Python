package com.hqf.bookcode_13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtil.d(TAG, "OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(SecondActivity.PERSON_DATA, new Student("胡秋峰",22));
        PendingIntent pd = PendingIntent.getActivity(this, 0, intent, 0);
        //创建一个定时任务
        //ELAPSED_REALTIME:从系统开机开始算起 SystemClock.elapsedRealtime()获取系统开机至今的时间(ms)
        //WAKEUP:唤醒CPU
        //RTC:从1970年1月1日0点开始算起 System.currentTimeMillis() 获取1970至今时间(ms)
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerAtTime = SystemClock.elapsedRealtime() + 10*1000;//
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pd);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                Person person = new Person(123456, "胡秋峰", "河南省永城市芒山镇");
                Student student = new Student("胡秋峰",22);
                SecondActivity.actionStart(this, student);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
