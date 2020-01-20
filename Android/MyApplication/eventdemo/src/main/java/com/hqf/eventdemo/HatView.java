package com.hqf.eventdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class HatView extends View {
    private float hatMipX;
    private float hatMipY;
    public HatView(Context context) {
        super(context);
        hatMipX = 65;
        hatMipY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.hat);
        canvas.drawBitmap(bitmap, hatMipX, hatMipY, paint);
        if(bitmap.isRecycled()) {//如果图片没有回收
            bitmap.recycle();//回收图片
        }
    }

    public float getHatMipX() {
        return hatMipX;
    }

    public float getHatMipY() {
        return hatMipY;
    }

    public void setHatMipX(float hatMipX) {
        this.hatMipX = hatMipX;
    }

    public void setHatMipY(float hatMipY) {
        this.hatMipY = hatMipY;
    }
}
