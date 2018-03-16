package com.uyenpham.diploma.antitheft.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SimChangedReceiver extends BroadcastReceiver {

        @Override
        public void onReceive (final Context context, final Intent intent){

        Log.d("SimChangedReceiver", "--> SIM state changed <--");
    }
}
