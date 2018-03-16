package com.uyenpham.diploma.antitheft.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.uyenpham.diploma.antitheft.R;

import java.util.List;

public class PattenActivity extends AppCompatActivity implements PatternLockViewListener {
    private PatternLockView mPatternLockView;
    private String paternPass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pattern_lockview);

        mPatternLockView = (PatternLockView) findViewById(R.id.pattern);
        mPatternLockView.addPatternLockListener(this);

        initData();
    }

    @Override
    public void onStarted() {

    }

    @Override
    public void onProgress(List<PatternLockView.Dot> progressPattern) {

    }

    @Override
    public void onComplete(List<PatternLockView.Dot> pattern) {
        String patternStr = PatternLockUtils.patternToString(mPatternLockView, pattern);
        if(patternStr.equals(paternPass)){
            finish();
        }
    }

    @Override
    public void onCleared() {

    }

    private void initData(){
        Intent intent = getIntent();
        paternPass = intent.getStringExtra("pass");
    }
}
