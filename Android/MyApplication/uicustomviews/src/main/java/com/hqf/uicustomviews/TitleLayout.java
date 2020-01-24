package com.hqf.uicustomviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout implements View.OnClickListener{
    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        ImageView titleBack = (ImageView) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);
        titleBack.setOnClickListener(this);
        titleEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                Toast.makeText(getContext(), "You click Back button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(), "You click Edit button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
