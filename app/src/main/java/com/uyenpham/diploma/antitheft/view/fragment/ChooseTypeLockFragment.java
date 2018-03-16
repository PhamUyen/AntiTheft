package com.uyenpham.diploma.antitheft.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.uyenpham.diploma.antitheft.R;
import com.uyenpham.diploma.antitheft.view.activity.MainActivity;
import com.uyenpham.diploma.antitheft.view.customview.CustomDialogLockPass;
import com.uyenpham.diploma.antitheft.view.customview.CustomDialogLockPattern;

public class ChooseTypeLockFragment extends Fragment implements View.OnClickListener{
    private MainActivity main;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        main = (MainActivity)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(
                R.layout.fragment_choose_pin_or_shape, null);

        initView(view);
        return view;
    }

    private void initView(View view){
        setHasOptionsMenu(true);
        main.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        view.findViewById(R.id.shape).setOnClickListener(this);
        view.findViewById(R.id.pin).setOnClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.popBackStack();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shape:
                CustomDialogLockPattern dialogShape = new CustomDialogLockPattern();
                FragmentTransaction fts = main.getSupportFragmentManager().beginTransaction();
                fts.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                dialogShape.show(fts, CustomDialogLockPattern.TAG);
                break;
            case R.id.pin:
                CustomDialogLockPass dialog = new CustomDialogLockPass();
                FragmentTransaction ft = main.getSupportFragmentManager().beginTransaction();
                ft.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                dialog.show(ft, CustomDialogLockPass.TAG);
                break;
        }
    }
}
