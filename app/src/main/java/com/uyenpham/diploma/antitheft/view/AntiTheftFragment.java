package com.uyenpham.diploma.antitheft.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.uyenpham.diploma.antitheft.R;

public class AntiTheftFragment extends Fragment implements View.OnClickListener {
    private LinearLayout lnOnCharge, lnOnMove, lnOnNear, lnOnSim;
    private LinearLayout lnOffCharge, lnOffMove, lnOffNear, lnOffSim;
    private ShimmerTextView shimerOffCharge, shimerOffMove, shimerOffNear, shimerOffSim;
    private boolean isOnCharge, isOnMove, isOnNear, isOnSim;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(
                R.layout.fragment_anti_theft, null);

        initView(view);
        return view;
    }

    private void initView(View view) {
        lnOffCharge = view.findViewById(R.id.lnOffCharge);
        lnOnCharge = view.findViewById(R.id.lnOnCharge);
        shimerOffCharge = view.findViewById(R.id.shimerOffCharge);
        lnOffMove = view.findViewById(R.id.lnOffMove);
        lnOnMove = view.findViewById(R.id.lnOnMove);
        shimerOffMove = view.findViewById(R.id.shimerOffMove);
        lnOffNear = view.findViewById(R.id.lnOffNear);
        lnOnNear = view.findViewById(R.id.lnOnNear);
        shimerOffNear = view.findViewById(R.id.shimerOffNear);
        lnOffSim = view.findViewById(R.id.lnOffSim);
        lnOnSim = view.findViewById(R.id.lnOnSim);
        shimerOffSim = view.findViewById(R.id.shimerOffSim);
        lnOffCharge.setOnClickListener(this);
        lnOnCharge.setOnClickListener(this);
        lnOffMove.setOnClickListener(this);
        lnOnMove.setOnClickListener(this);
        lnOffNear.setOnClickListener(this);
        lnOnNear.setOnClickListener(this);
        lnOffSim.setOnClickListener(this);
        lnOnSim.setOnClickListener(this);
        view.findViewById(R.id.lnCharge).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lnCharge:
                if (isOnCharge) {
                    lnOnCharge.setVisibility(View.VISIBLE);
                    lnOffCharge.setVisibility(View.GONE);
                    isOnCharge = false;
                } else {
                    isOnCharge = true;
                    lnOnCharge.setVisibility(View.GONE);
                    lnOffCharge.setVisibility(View.VISIBLE);
                    new Shimmer().start(shimerOffCharge);
                }
                break;
            case R.id.lnOnMove:
                if (isOnMove) {
                    lnOnMove.setVisibility(View.VISIBLE);
                    lnOffMove.setVisibility(View.GONE);
                    isOnMove = false;
                } else {
                    lnOnMove.setVisibility(View.GONE);
                    lnOffMove.setVisibility(View.VISIBLE);
                    new Shimmer().start(shimerOffMove);
                    isOnMove = true;
                }
                break;
            case R.id.lnOnNear:
                if (isOnNear) {
                    lnOnNear.setVisibility(View.VISIBLE);
                    lnOffNear.setVisibility(View.GONE);
                    isOnNear = false;
                } else {
                    lnOnNear.setVisibility(View.GONE);
                    lnOffNear.setVisibility(View.VISIBLE);
                    new Shimmer().start(shimerOffNear);
                    isOnNear = true;
                }
                break;
            case R.id.lnOnSim:
                if (isOnSim) {
                    lnOnSim.setVisibility(View.VISIBLE);
                    lnOffSim.setVisibility(View.GONE);
                    isOnSim = false;
                } else {
                    lnOnSim.setVisibility(View.GONE);
                    lnOffSim.setVisibility(View.VISIBLE);
                    new Shimmer().start(shimerOffSim);
                    isOnSim = true;
                }
                break;
        }
    }
}
