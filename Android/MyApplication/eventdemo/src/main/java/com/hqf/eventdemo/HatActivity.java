package com.hqf.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.EventListener;

public class HatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hat);
        //创建帽子并设置触摸监听器在触摸时移动帽子的位置
        final float[] xdX = {0};
        final float[] xdY = {0};
        final HatView hatView = new HatView(HatActivity.this);
        hatView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    xdX[0] = event.getX() - hatView.getHatMipX();
                    xdY[0] = event.getY() - hatView.getHatMipY();
                }
                hatView.setHatMipX(event.getX() - xdX[0]);
                hatView.setHatMipY(event.getY() - xdY[0]);
                hatView.invalidate();//重绘帽子
                return true;//返回true代表消耗该事件时间，其他监听器检测不到该事件
            }
        });
        //把帽子添加到布局管理器当中
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        relativeLayout.addView(hatView);
    }
}
