package com.hqf.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AliasActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //显示带取消、确定按钮的对话框
    public void alertDialogOne(View view) {
//        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//        alertDialog.setIcon(R.drawable.advise);
//        alertDialog.setTitle("乔布斯：");
//        alertDialog.setMessage("活着就是为了改变世界，难道还有其他原因吗？");
//        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "否", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "你单击了否按钮", Toast.LENGTH_SHORT).show();
//            }
//        });
//        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "是", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "你单击了是按钮", Toast.LENGTH_SHORT).show();
//            }
//        });
//        alertDialog.show();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.advise);
        builder.setTitle("乔布斯：");
        builder.setMessage("活着就是为了改变世界，难道还有其他原因吗？");
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "否", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "否", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
    //显示带列表的对话框
    public void alertDialogTwo(View view) {
        final String[] items = new String[] {"当你有使命，它会让你更专注","要么出众，要么出局",
                "活着就是为了改变世界","求知若饥， 虚心若愚"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.advise1);
        builder.setTitle("请选择你喜欢的名言：");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你选择了{"+items[which]+"}", Toast.LENGTH_SHORT).show();
            }
        });
        builder.create().show();
    }
    //显示带单选列表项的对话框
    public void alertDialogThree(View view) {
        final String[] items = new String[] {"扎克伯格", "乔布斯", "拉里·艾莉森", "安迪·鲁宾", "马云"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.advise2);
        builder.setTitle("如果让你选择，你想做哪一个");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你选择了【"+items[which]+"】", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确定",null);
        builder.create().show();
    }
    //显示带多选列表项的对话框
    public void alertDialogFour(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final boolean[] checkItems = new boolean[] {false, false, true, false, true};
        final String[] items = new String[] {"开心消消乐", "球球大作战", "欢乐斗地主", "梦幻西游", "超级玛丽"};
        builder.setIcon(R.drawable.advise1);
        builder.setTitle("请选择你喜爱的游戏");
        builder.setMultiChoiceItems(items, checkItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkItems[which] = isChecked;
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String result  = new String();
                for (int i = 0; i < checkItems.length; i++) {
                    if (checkItems[i]) {
                        result += items[i]+"、";
                    }
                }
                if (!"".equals(result)) {
                    Toast.makeText(MainActivity.this, "你选择了" + result, Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.create().show();
    }
}
