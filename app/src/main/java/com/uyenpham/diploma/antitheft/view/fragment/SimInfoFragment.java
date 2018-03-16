package com.uyenpham.diploma.antitheft.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.uyenpham.diploma.antitheft.R;

public class SimInfoFragment extends Fragment {
    private EditText edName, edNumber, edMail;
    private TextView tvSerial, tvCountry, tvEmei, tvOperation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(
                R.layout.fragment_sim_infomation, null);

        initView(view);
        return view;
    }

    private void initView(View view) {
        edMail = view.findViewById(R.id.edMail);
        edName = view.findViewById(R.id.edName);
        edNumber = view.findViewById(R.id.edNumber);
        tvSerial = view.findViewById(R.id.tvSerial);
        tvCountry = view.findViewById(R.id.tvCountry);
        tvOperation = view.findViewById(R.id.tvOperation);
        tvEmei = view.findViewById(R.id.tvImei);
    }

    private void initData(){

    }
}
