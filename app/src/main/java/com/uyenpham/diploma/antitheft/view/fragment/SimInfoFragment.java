package com.uyenpham.diploma.antitheft.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.uyenpham.diploma.antitheft.R;
import com.uyenpham.diploma.antitheft.utils.CommonFunction;
import com.uyenpham.diploma.antitheft.utils.SimUtils;
import com.uyenpham.diploma.antitheft.view.activity.MainActivity;

public class SimInfoFragment extends Fragment implements View.OnClickListener{
    private EditText edName, edNumber, edMail;
    private TextView tvSerial, tvCountry, tvEmei, tvOperation;
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
        view.findViewById( R.id.tvCheck).setOnClickListener(this);
    }

    private void initData(){
        if(CommonFunction.stringIsNull(edName.getText().toString().trim())){
            edName.setError("Invalid name!");
            return;
        }
        if(!CommonFunction.validateNumberphone(edNumber.getText().toString().trim())){
            edNumber.setError("Invalid phone number");
            return;
        }
        if(!CommonFunction.validateMail(edMail.getText().toString().trim())){
            edMail.setError("Invalid email!");
            return;
        }
        tvEmei.setText(SimUtils.getIMEI(main));
        tvSerial.setText(SimUtils.getSeriSim(main));
        tvCountry.setText(SimUtils.getCountry(main));
        tvOperation.setText(SimUtils.getCarrierName(main));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvCheck:
                initData();
                break;
        }
    }
}
