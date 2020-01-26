package com.hqf.iot.debug;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class ToastNew extends Toast {
    private static boolean flag = true;
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public ToastNew(Context context) {
        super(context);
    }

    public void setOn() {
        flag = true;
    }

    public void setOff() {
        flag = false;
    }

    @Override
    public void show() {
        if (flag == true) {
            super.show();
        }
    }
}
