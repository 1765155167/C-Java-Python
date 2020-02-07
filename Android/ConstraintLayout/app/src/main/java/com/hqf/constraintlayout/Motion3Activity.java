package com.hqf.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hqf.constraintlayout.activityControl.BaseActivity;

public class Motion3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion3);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, Motion3Activity.class);
        context.startActivity(intent);
    }
}
