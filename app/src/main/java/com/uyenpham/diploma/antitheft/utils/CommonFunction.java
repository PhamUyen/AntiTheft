package com.uyenpham.diploma.antitheft.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;

import com.uyenpham.diploma.antitheft.view.activity.PasswordActivity;

public class CommonFunction {
    public static boolean isPlugged(Context context) {
        Intent intent = context.registerReceiver(null, new IntentFilter(Intent
                .ACTION_BATTERY_CHANGED));
        int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        return plugged == BatteryManager.BATTERY_PLUGGED_AC ||
                plugged == BatteryManager.BATTERY_PLUGGED_USB ||
                (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 &&
                        plugged == BatteryManager.BATTERY_PLUGGED_WIRELESS);
    }
    public static boolean compareString(String str1, String str2){
        return str1.equalsIgnoreCase(str2);
    }
    public static boolean stringIsNull(String str){
        return str == null || str.equals("");
    }
    public static void showOverlayActivity(Context context){
        Intent intent = new Intent(context, PasswordActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}