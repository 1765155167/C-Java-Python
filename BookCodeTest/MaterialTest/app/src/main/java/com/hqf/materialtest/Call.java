package com.hqf.materialtest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Call {
    public static void call(Context context, String number) {
        Uri uri = Uri.parse("tel:"+number);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(uri);
        context.startActivity(intent);
    }
}
