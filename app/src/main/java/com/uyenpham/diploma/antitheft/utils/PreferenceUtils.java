package com.uyenpham.diploma.antitheft.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.uyenpham.diploma.antitheft.model.ServiceLock;

public class PreferenceUtils {
    private static final String PREF_NAME = "antitheft";
    private static final String KEY_LIST_SONG = "listSong";

    public static void saveBoolean(Context context, String key, boolean value) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putBoolean(key, value).apply();
    }

    public static void saveInt(Context context, String key, int value) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putInt(key, value).apply();
    }

    public static void saveString(Context context, String key, String value) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putString(key, value).apply();
    }

    public static boolean getBoolean(Context context, String key) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getBoolean(key, false);
    }
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getBoolean(key, defaultValue);
    }
    public static int getInt(Context context, String key, int defValue) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getInt(key, defValue);
    }

    public static String getString(Context context, String key) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(key, "");
    }
    public static String getString(Context context, String key, String defValue) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString(key, defValue);
    }

    public static void remove(Context context, String key) {
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().remove(key).apply();
    }

    public static void saveServiceActive(ServiceLock serviceLock,Context context){
        Gson gson = new Gson();
        String json = gson.toJson(serviceLock);
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).edit().putString("lock", json).apply();
    }

    public static ServiceLock getServiceActive(Context context){
        String json =context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE).getString("lock", "");
        return  new Gson().fromJson(json, ServiceLock.class);
    }
}
