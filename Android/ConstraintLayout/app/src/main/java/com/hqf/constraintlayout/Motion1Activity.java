package com.hqf.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hqf.constraintlayout.activityControl.BaseActivity;

public class Motion1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion1);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, Motion1Activity.class);
        context.startActivity(intent);
    }
}
