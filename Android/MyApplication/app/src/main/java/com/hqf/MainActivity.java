package com.hqf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 = (Button)findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*MainActivity活动的基础是打开Main2Activity活动*/
                String data = "Hello SecondActivity";
                Intent inter = new Intent(MainActivity.this, Main2Activity.class);
                inter.putExtra("extra_data", data);
                startActivityForResult(inter, 1);//使用该方法转移活动时，需要返回值
                //startActivity(inter);
                /*隐式调用*/
                //Intent intent = new Intent("com.hqf.ACTION_START");
                //intent.addCategory("com.hqf.MY_CATEGORY");
                //startActivity(intent);
            }
        });
        Button button2 = (Button)findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * 网页调转
                 * 应用程序共享
                */
                Intent inter = new Intent(Intent.ACTION_VIEW);
                inter.setData(Uri.parse("http://www.bilibili.com"));
                startActivity(inter);
            }
        });
    }

    //跳转活动返回时会回调该方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("data_return");
                    Log.d(TAG, returnData);
                    Toast.makeText(MainActivity.this, returnData, Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
    /*菜单显示*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*菜单点击功能*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MainActivity.this, "add item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this, "remove item", Toast.LENGTH_SHORT).show();
                break;
            case R.id.phone:/*拨打电话*/
                Intent inter = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:10086"));
                startActivity(inter);
            default:
        }
        return true;
    }
}
