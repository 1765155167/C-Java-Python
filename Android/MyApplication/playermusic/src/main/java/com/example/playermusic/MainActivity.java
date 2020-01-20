package com.example.playermusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //        WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final Intent intent = new Intent(MainActivity.this, MusicService.class);

        ImageButton imageButton = (ImageButton)findViewById(R.id.btn_play);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MusicService.isPlay == false) {
                    startService(intent);
                    //更换图标
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play, null));
                } else {
                    stopService(intent);
                    //更换图标
                    ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.stop, null));
                }
            }
        });
    }

    @Override
    protected void onStart() {
        startService(new Intent(MainActivity.this, MusicService.class));
        super.onStart();
    }
}
