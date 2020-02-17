package com.hqf.bookcode_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String PERSON_DATA = "person_data";

    public static void actionStart(Context context, Person person) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(PERSON_DATA, person);
        context.startActivity(intent);
    }

    public static void actionStart(Context context, Student student) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(PERSON_DATA, student);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        Student student = intent.getParcelableExtra(PERSON_DATA);
        if (student != null) {
            TextView textView = findViewById(R.id.textView);
            textView.setText(student.getAge()+student.getName());
        } else {
            Toast.makeText(this, "student = null", Toast.LENGTH_SHORT).show();
        }
    }
}
