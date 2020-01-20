package com.hqf.intentdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//取消标题栏
        setContentView(R.layout.activity_main);
        int butId[] = {R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6};
        for(int i = 0; i < butId.length; i++) {
            Button button = (Button)findViewById(butId[i]);
            button.setOnClickListener(l);
        }
    }
    View.OnClickListener l = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            Button button = (Button)v;
            switch (button.getId()) {
                case R.id.button1:
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+8618595801890"));
                    break;
                case R.id.button2:
                    intent.setAction(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:+8618595801890"));
                    intent.putExtra("sms_body", "Hello Mr.Hu");
                    break;
                case R.id.button3:
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.baidu.com"));
                    break;
                case R.id.button4:
                    intent.setAction(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    break;
                case R.id.button5:
                    ComponentName componentName = new ComponentName("com.hqf.intentdemo",
                            "com.hqf.intentdemo.SecondActivity");
                    intent.setComponent(componentName);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);//不占用历史
                    break;
                case R.id.button6:
                    intent.setAction(Intent.ACTION_VIEW);
                default:
                        break;
            }
            startActivity(intent);
        }
    };
}
