package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BinderService extends Service {
    public BinderService() {
    }
    //binder内部类
    public class MyBinder extends Binder {
        public BinderService getService() {//获取创建service方法
            return BinderService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();//用于与Activity实时通信
    }
    //自定义生成随机数方法
    public List getRandomNumber() {
        List resArr = new ArrayList();
        String strNumber;//保存生成的随机数
        for (int i = 0; i < 7; i++) {
            int num = new Random().nextInt(33) + 1;
            if(num < 10) {
                strNumber = "0"+String.valueOf(num);
            }else{
                strNumber = String.valueOf(num);
            }
            resArr.add(strNumber);
        }
        return resArr;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
