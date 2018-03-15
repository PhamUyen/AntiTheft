package com.uyenpham.diploma.antitheft.view.customview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uyenpham.diploma.antitheft.IKeybroadClick;
import com.uyenpham.diploma.antitheft.R;

public class CustomDialogLockPass extends DialogFragment implements IKeybroadClick{
    public static final String TAG = "FullScreenDialog";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        super.onCreateView(inflater, parent, state);

        View view = getActivity().getLayoutInflater().inflate(R.layout.activity_password, parent, false);
        return view;
    }

    @Override
    public void numberClick(int number) {
        
    }

    @Override
    public void removeClick() {

    }

    @Override
    public void submitClick() {

    }
}
