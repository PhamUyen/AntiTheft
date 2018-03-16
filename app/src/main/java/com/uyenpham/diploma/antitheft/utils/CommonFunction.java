package com.uyenpham.diploma.antitheft.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
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
    public static void showOverlayActivity(Context context, Class serviceClass, String pass){
        Intent intent = new Intent(context, serviceClass);
        intent.putExtra("pass", pass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void enableReciver(Class serviceName, Context context){
        ComponentName component = new ComponentName(context, serviceName);
        context.getPackageManager().setComponentEnabledSetting(component, PackageManager. COMPONENT_ENABLED_STATE_ENABLED , PackageManager.DONT_KILL_APP);
    }
    public static void disAbleReciver(Class serviceName, Context context){
        ComponentName component = new ComponentName(context, serviceName);
        context.getPackageManager().setComponentEnabledSetting(component, PackageManager. COMPONENT_ENABLED_STATE_DISABLED , PackageManager.DONT_KILL_APP);
    }

    public static boolean validateMail(String mail){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return mail.matches(emailPattern) && !stringIsNull(mail);
    }
    public static boolean validateNumberphone(String phone){
        String emailPattern = "^[+]?[0-9]{10,13}$";
        return phone.matches(emailPattern);
    }
}
