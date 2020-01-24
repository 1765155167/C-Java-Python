package com.hqf.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowFruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_fruit);
        Intent intent = getIntent();
        Fruit fruit = (Fruit) intent.getSerializableExtra(MainActivity.EXTRA_FRUIT);
        ImageView imageView = findViewById(R.id.imageView);
        TextView textView = findViewById(R.id.textView);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getImageName());
    }

    public static void startActivity(Context context, Fruit fruit) {
        Intent intent = new Intent(context, ShowFruitActivity.class);
        intent.putExtra(MainActivity.EXTRA_FRUIT, fruit);
        context.startActivity(intent);
    }
}
