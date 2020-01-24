package com.hqf.uidemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/*
* 控件Visibility属性
* 1.visible:表示控件是可见的（可见占空间）默认
* 2.invisible:控件是透明的（不可见占空间）
* 3.gone:控件消失（不可见且不占据空间）
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;

    private ImageView imageView;

    private ProgressBar progressBar;
    AlertDialog.Builder dialog;

    ProgressDialog progressDialog;

    private Button[] buttons;
    private int[] btnId = { R.id.button1, R.id.button2 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        buttons = new Button[btnId.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = (Button) findViewById(btnId[i]);
            buttons[i].setOnClickListener(this);
        }
        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        //带进度条的弹出框
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("This is Progress Dialog");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);//不能通过back键取消
        //弹出对话框AlertDialog
        dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("This a dialog");//标题
        dialog.setMessage("Something important.");//内容
        dialog.setCancelable(false);//不能取消
        //设置确定按钮点击事件
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setNeutralButton("exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //设置取消按钮点击事件
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                //改变图片显示
                dialog.show();
                imageView.setImageResource(R.drawable.feng);
                //显示editText输入信息
//                String inputText = editText.getText().toString();
//                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show();
                //更改进度条进度
//                int progress = progressBar.getProgress();
//                progress += 10;
//                progressBar.setProgress(progress);
                //更改进度条显示状态
//                if (progressBar.getVisibility() == View.GONE) {
//                    progressBar.setVisibility(View.VISIBLE);
//                } else if (progressBar.getVisibility() == View.VISIBLE) {
//                    progressBar.setVisibility(View.INVISIBLE);
//                } else {
//                    progressBar.setVisibility(View.GONE);
//                }
                break;
            case R.id.button2:
                progressDialog.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();
                Toast.makeText(this, "click button2.", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
