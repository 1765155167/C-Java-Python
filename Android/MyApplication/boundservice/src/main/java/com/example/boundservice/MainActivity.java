package com.example.boundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    BinderService binderService;//声明对象
    //文本框组件id
    int tvid[] = {R.id.textView1, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5,
                  R.id.textView6, R.id.textView7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List number = binderService.getRandomNumber();
                for (int i = 0; i < number.size(); i++) {
                    TextView tv = (TextView)findViewById(tvid[i]);
                    tv.setText(number.get(i).toString());
                }
            }
        });
    }
    //创建serviceConnect对象
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        //链接成功回调
        public void onServiceConnected(ComponentName name, IBinder service) {
            binderService = ((BinderService.MyBinder)service).getService();
        }

        @Override
        //断开回调
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(MainActivity.this, "断案开链接", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(MainActivity.this, BinderService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);//自动创建
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
    }
}
