package com.uyenpham.diploma.antitheft.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.uyenpham.diploma.antitheft.utils.CommonFunction;
import com.uyenpham.diploma.antitheft.utils.PreferenceUtils;
import com.uyenpham.diploma.antitheft.view.activity.PasswordActivity;

public class BroadcastChanger extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        String data = intent.getAction();
        if (CommonFunction.compareString("android.intent.action.ACTION_POWER_DISCONNECTED",data)) {
            if(PreferenceUtils.getBoolean(context,"Charge")){

                CommonFunction.showOverlayActivity(context, PasswordActivity.class);
            }
        }
    }
}