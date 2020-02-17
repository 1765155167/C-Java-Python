package com.hqf.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String BUNDLE_EDIT_TEXT_ONE = "com.hqf.myapplication.EDIT_TEXT_ONE";
    public static final String BUNDLE_EDIT_TEXT_TWO = "com.hqf.myapplication.EDIT_TEXT_TWO";
    public static final String EXTRA_MESSAGE = "com.hqf.myapplication.MESSAGE";
    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        super.onCreate(savedInstanceState);
    }

    public void sendMessage(View view) {
        String message = editText1.getText().toString();
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void sendMessageTwo(View view) {
        String message = editText2.getText().toString();
        Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Toast.makeText(this, "onConfigurationChange", Toast.LENGTH_SHORT).show();
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }

    // 恢复
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(this, "onRestoreInstanceState", Toast.LENGTH_SHORT).show();
        String edit_text_one = savedInstanceState.getString(BUNDLE_EDIT_TEXT_ONE);
        String edit_text_two = savedInstanceState.getString(BUNDLE_EDIT_TEXT_TWO);
        //Toast.makeText(this, "Create:"+edit_text_one+":"+edit_text_two, Toast.LENGTH_SHORT).show();
        editText1.setText(edit_text_one);
        editText2.setText(edit_text_two);
    }

    //活动在回收之前会被调用 保存
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Toast.makeText(this, "onSaveInstanceState", Toast.LENGTH_SHORT).show();
        String edit_text_one = editText1.getText().toString();
        String edit_text_two = editText2.getText().toString();
        //Toast.makeText(this, "Save:"+edit_text_one+":"+edit_text_two, Toast.LENGTH_SHORT).show();
        outState.putString(BUNDLE_EDIT_TEXT_ONE, edit_text_one);
        outState.putString(BUNDLE_EDIT_TEXT_TWO, edit_text_two);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }
}
