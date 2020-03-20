package com.hqf.iot.debug;

import android.widget.Toast;

import com.hqf.iot.base.MyApplication;

public class ToastNew {

    private static boolean flag = true;

    public static void setOn() {
        flag = true;
    }

    public static void setOff() {
        flag = false;
    }

    public static void makeText(String msg) {
        if (flag == true) {
            Toast.makeText(MyApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }
}
