package com.hqf.activitylifecycletest;

import android.app.Activity;
import android.app.ActivityManager;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for(Activity activity : activities) {
            if(!activity.isFinishing()) {
                activity.finish();
            }
        }
        //销毁当前进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
