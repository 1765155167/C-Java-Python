package com.hqf.iot;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {
    private Led[] led = new Led[6];

    private void ledInit() {
        led[0] = new Led(R.id.ledView1);
        led[1] = new Led(R.id.ledView2);
        led[2] = new Led(R.id.ledView3);
        led[3] = new Led(R.id.ledView4);
        led[4] = new Led(R.id.ledView5);
        led[5] = new Led(R.id.ledView6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ledInit();
        for (int i = 0; i < led.length; i++) {
            final ImageButton ledView1 = (ImageButton) findViewById(led[i].getId());
            ledView1.setOnClickListener(clickListener);
        }
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MenuActivity.class);
        context.startActivity(intent);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = ((ImageView)v).getId();
            for (int i = 0; i < led.length; i++) {
                if(id == led[i].getId()) {
                    if(!led[i].isOn()) {
                        ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.play, null));
                        led[i].setLed();
                    } else {
                        ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.stop, null));
                        led[i].closeLed();
                    }
                }
            }
        }
    };
}
