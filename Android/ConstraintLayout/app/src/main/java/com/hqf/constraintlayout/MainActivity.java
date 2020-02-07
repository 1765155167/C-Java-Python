package com.hqf.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hqf.constraintlayout.activityControl.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void click(View view) {
//        switch (view.getId()) {
//            case R.id.button1:
//                Motion1Activity.startActivity(this);
//                break;
//            case R.id.button2:
//                Motion2Activity.startActivity(this);
//                break;
//            case R.id.button3:
//                Motion3Activity.startActivity(this);
//                break;
//            case R.id.button4:
//                Motion4Activity.startActivity(this);
//                break;
//        }
//    }
}
