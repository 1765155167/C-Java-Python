package com.hqf.eventdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
/*
    static GestureLibrary fromfile(String path)
    //从path代表的文件中加载手势库。
    static GestureLibrary fromfile(File path)
    //从path代表的文件中加载手势库。
    static Gesturelibrary fromprivatefile(Context context，String name)
    //从指定应用程序的数据文件夹中name文件中加载手势库。
    static Gesturelibrary fromrawresource(Context context, int resourced)
    //从resourced所代表的资源中加载手势库。
    void addgesture(String entryname,Gesture gesture)
    //添加一个名为 entrynama的手势
            Set<String> getGestureEntries()
    //获取该手势库中的所有手势的名称。
            ArrayList<Gesture>getGesture(String entryName)
    //获取entryName名称的对应的全部手势。
            ArrayList<Prediction> recognize(Gesture gesture)
    //从当前手势库中识别与gesture匹配的全部手势。
            void removeEntry(String entryname)
    //删除手势库中 entryname对应的手势。
            void removeGesture(String entryname,Gesture gesture)
    //删除手势库中entryName、 gesture对应的手势
            boolean save()
    //当向手势库中添加手势或从中删除手势后调用该方法保存手势库。
*/
//2.实现GestureOverlayView.OnGesturePerformedListener并重新所有方法
//implements GestureOverlayView.OnGesturePerformedListener
public class HandleWrite extends AppCompatActivity {
    //private GestureLibrary library;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_write);
        //3.加载手势文件
        //library = GestureLibraries.fromRawResource(HandleWrite.this, R.raw.gestures); //加载手势文件
        editText = (EditText) findViewById(R.id.editText); //获取编辑框
        //if (!library.load()) {// 如果加载失败则退出
            //finish();
        //}
//        GestureOverlayView gestureOverlayView = (GestureOverlayView) findViewById(R.id.gesture);
//        gestureOverlayView.setGestureColor(Color.BLACK);
//        gestureOverlayView.setFadeOffset(1000);
//        gestureOverlayView.addOnGesturePerformedListener(this);// 增加事件监听器
    }

//    @Override
//    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
//        ArrayList<Prediction> gestures = library.recognize(gesture);// 获得全部预测结果
//        int index = 0;// 保存当前预测的索引号
//        double score = 0.0;// 保存当前预测的得分
//        for (int i = 0; i < gestures.size(); i++) {// 获得最佳匹配结果
//            Prediction result = gestures.get(i);// 获得一个预测结果
//            if (result.score > score) {
//                index = i;
//                score = result.score;
//            }
//        }
//        String text = editText.getText().toString();// 获得编辑框中已经包含的文本
//        text += gestures.get(index).name;// 获得最佳匹配
//        editText.setText(text);// 更新编辑框
//    }
}
