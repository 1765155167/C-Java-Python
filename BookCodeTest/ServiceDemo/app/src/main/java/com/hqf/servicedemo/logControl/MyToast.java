package com.hqf.servicedemo.logControl;

import android.content.Context;
import android.widget.Toast;

public class MyToast {

    private static boolean flag = true;

    public static void showLog() {
        flag = true;
    }

    public static void closeLog() {
        flag = false;
    }

    public static void makeText(Context context, String log) {
        if (flag) {
            Toast.makeText(context, log, Toast.LENGTH_SHORT).show();
        }
    }
}
