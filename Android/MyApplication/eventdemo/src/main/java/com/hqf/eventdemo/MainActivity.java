package com.hqf.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //基于监听的事件处理
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        //注册单击时间监听器
        button1.setOnClickListener(clickL);
        button2.setOnClickListener(clickL);
        //注册长按事件监听器
        button1.setOnLongClickListener(longClickListener);
        button2.setOnLongClickListener(longClickListener);
    }
    View.OnClickListener clickL = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            switch (((Button)v).getId()) {
                case R.id.button1:
                    intent = new Intent(MainActivity.this, HatActivity.class);
                    break;
                case R.id.button2:
                    intent = new Intent(MainActivity.this, CatPhoto.class);
                    break;
                 default:
            }
            startActivity(intent);
        }
    };
    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            switch (((Button)v).getId()) {
                case R.id.button1:
                    registerForContextMenu(v);
                    openContextMenu(v);
                    break;
                case R.id.button2:
                    Intent intent = new Intent(MainActivity.this, HandleWrite.class);
                    startActivity(intent);
                    break;
                default:
            }
            return true;//返回true代表单击时间检测不到
        }
    };
    /*基于回调的事件处理*/
    //物理按键 （音量键、back键、home键、电源键）（单击长安）
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        Toast.makeText(this, "按下", Toast.LENGTH_SHORT).show();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Toast.makeText(this, "松开", Toast.LENGTH_SHORT).show();
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Toast.makeText(this, "长按", Toast.LENGTH_SHORT).show();
        return super.onKeyLongPress(keyCode, event);
    }

    public void exit() {
        if((System.currentTimeMillis()-exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {//连续单击了两次back键
            finish();//退出当前活动
            System.exit(0);//退出应用程序
        }
    }

    //触摸屏
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "触摸", Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }

    //为菜单添加选项值
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(((Button)v).getId() == R.id.button1) {
            menu.add("收藏");
            menu.add("举报");
        }
    }
}
