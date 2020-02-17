package com.hqf.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import static android.provider.ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE;

public class NetworkChangeReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            Toast.makeText(context, "正在使用2G/3G/4G网络", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "网络断开", Toast.LENGTH_SHORT).show();
        }
    }
}
