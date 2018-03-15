package com.uyenpham.diploma.antitheft.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.uyenpham.diploma.antitheft.IKeybroadClick;
import com.uyenpham.diploma.antitheft.R;

@SuppressLint("Registered")
public class PattenActivity extends AppCompatActivity implements IKeybroadClick {
    private EditText edPass;
    private String passEnter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        edPass = findViewById(R.id.edPass);
    }

    @Override
    public void numberClick(int number) {
        passEnter = passEnter + number;
        edPass.setText(passEnter);
    }

    @Override
    public void removeClick() {
        if (passEnter != null && passEnter.length() > 0) {
            passEnter = passEnter.substring(0, passEnter.length() - 1);
            edPass.setText(passEnter);
        }
    }

    @Override
    public void submitClick() {
        String pass = edPass.getText().toString();
    }
}
