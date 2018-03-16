package com.uyenpham.diploma.antitheft.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.uyenpham.diploma.antitheft.R;

public class FragmentUtils {
    private static final String TAG = FragmentUtils.class.getSimpleName();

    /**
     * Replaces the current {@link Fragment} in the container with the given id. Allows to specify
     * the {@link String} with which to tag the replaced {@link Fragment}.
     *
     * @param context       needed as a context object
     * @param fragment           Class of the {@link Fragment} to instantiate
     *                       Fragment will be replaced
     * @param tag            a {@link String} id to tag the replaced {@link Fragment} with
     */
    public static void replace(AppCompatActivity context, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.content_main, fragment, tag);
        fragmentTransaction.commitAllowingStateLoss();
    }
    public static void replaceAndAddToBackStack(AppCompatActivity context, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.content_main, fragment, tag);
        fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commitAllowingStateLoss();
    }
    /**
     * Add the given {@link Fragment} to the container with the given id.
     *
     * */
    public static void add(AppCompatActivity context, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = context.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                android.R.anim.fade_out);
        fragmentTransaction.add(R.id.content_main, fragment, tag);
        fragmentTransaction.commitAllowingStateLoss();
    }

}
