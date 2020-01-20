package com.hqf.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.accessibilityservice.GestureDescription;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

//1.实现GestureDetector.OnGestureListener接口，并实现其所有方法
public class CatPhoto extends AppCompatActivity implements GestureDetector.OnGestureListener {
    Animation[] animation = new Animation[4];
    final int distance = 50;
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
                            R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8 };//图片资源
    ViewFlipper flipper;
    //2.定义手势检测器
    GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_photo);
        detector = new GestureDetector(CatPhoto.this, this);//创建手势检测器
        //3.将图片加载到ViewFlipper中
        flipper = (ViewFlipper)findViewById(R.id.flipper);
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        //动画
        animation[0] = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        animation[1] = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        animation[2] = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        animation[3] = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
    }

    //当触摸事件按下时触发该方法
    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    //当用户在触摸屏上按下、而且还未移动和松开时触发该方法
    @Override
    public void onShowPress(MotionEvent e) {

    }

    //用户在触摸屏上的轻击事件将会触发该方法
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    //当用户在屏幕上滚动时触发该方法
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    //用户在屏幕上长按触发该事件
    @Override
    public void onLongPress(MotionEvent e) {

    }

    //用户在屏幕上拖动时触发该方法，float velocityX, float velocityY,代表拖过动作在横向、纵向的速度
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //4.通过触摸事件的x坐标判断是向左滑动还是向右滑动并设置滑动动画
        //向左划
        if (e1.getX() - e2.getX() > distance) {
            flipper.setInAnimation(animation[2]);//淡入动画
            flipper.setOutAnimation(animation[1]);//淡出动画
            flipper.showPrevious();//显示前一张图片
            return true;
        } else if (e2.getX() - e1.getX() > distance) {
            flipper.setInAnimation(animation[0]);
            flipper.setOutAnimation(animation[3]);
            flipper.showNext();//显示下一张
            return true;
        }
        return false;
    }

    //5.将触摸事件交给实现GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }
}
