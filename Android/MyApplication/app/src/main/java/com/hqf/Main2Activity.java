package com.hqf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d(TAG, data);
        Toast.makeText(Main2Activity.this, data, Toast.LENGTH_SHORT).show();
        Button button3 = (Button)findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.hqf.yqq");
                startActivity(intent);
            }
        });
        Button button4 = (Button)findViewById(R.id.button_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*打开百度*/
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
    /*重载返回键*/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello MainActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
