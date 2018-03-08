package com.uyenpham.diploma.antitheft.view.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.andexert.library.RippleView;
import com.uyenpham.diploma.antitheft.IKeybroadClick;
import com.uyenpham.diploma.antitheft.R;

public class KeyBoardView extends LinearLayout implements View.OnClickListener {

    private IKeybroadClick iKeyboardClick;
    private RippleView btnSubmit;
    private RippleView btnNumber0, btnNumber1, btnNumber2, btnNumber3, btnNumber4, btnNumber5, btnNumber6, btnNumber7, btnNumber8, btnNumber9;
    private RippleView btnDelete;

    public KeyBoardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initial();
    }

    public KeyBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initial();
    }

    public KeyBoardView(Context context) {
        super(context);
        initial();
    }

    private void initial() {
        View view = View
                .inflate(getContext(), R.layout.custom_keyboard, null);
        if (view != null) {
            addView(view, new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT));
            btnNumber0 = (RippleView) view.findViewById(R.id.button0);
            btnNumber0.setOnClickListener(this);
            btnNumber1 = (RippleView) view.findViewById(R.id.button1);
            btnNumber1.setOnClickListener(this);
            btnNumber2 = (RippleView) view.findViewById(R.id.button2);
            btnNumber2.setOnClickListener(this);
            btnNumber3 = (RippleView) view.findViewById(R.id.button3);
            btnNumber3.setOnClickListener(this);
            btnNumber4 = (RippleView) view.findViewById(R.id.button4);
            btnNumber4.setOnClickListener(this);
            btnNumber5 = (RippleView) view.findViewById(R.id.button5);
            btnNumber5.setOnClickListener(this);
            btnNumber6 = (RippleView) view.findViewById(R.id.button6);
            btnNumber6.setOnClickListener(this);
            btnNumber7 = (RippleView) view.findViewById(R.id.button7);
            btnNumber7.setOnClickListener(this);
            btnNumber8 = (RippleView) view.findViewById(R.id.button8);
            btnNumber8.setOnClickListener(this);
            btnNumber9 = (RippleView) view.findViewById(R.id.button9);
            btnNumber9.setOnClickListener(this);
            btnDelete = (RippleView) view.findViewById(R.id.buttonx);
            btnDelete.setOnClickListener(this);
            btnSubmit = (RippleView) view.findViewById(R.id.ok);
            btnSubmit.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        String input = "";
        boolean isnormal = false;
        switch (v.getId()) {
            case R.id.button1:
                input = "1";
                isnormal = true;
                break;
            case R.id.button2:
                input = "2";
                isnormal = true;
                break;
            case R.id.button3:
                input = "3";
                isnormal = true;
                break;
            case R.id.button4:
                input = "4";
                isnormal = true;
                break;
            case R.id.button5:
                input = "5";
                isnormal = true;
                break;
            case R.id.button6:
                input = "6";
                isnormal = true;
                break;
            case R.id.button7:
                input = "7";
                isnormal = true;
                break;
            case R.id.button8:
                input = "8";
                isnormal = true;
                break;
            case R.id.button9:
                input = "9";
                isnormal = true;
                break;
            case R.id.button0:
                input = "0";
                isnormal = true;
                break;
            case R.id.buttonx:
                if (iKeyboardClick != null) {
                    iKeyboardClick.removeClick();
                }
                break;
            case R.id.ok:
                if (iKeyboardClick != null) {
                    iKeyboardClick.submitClick();
                }
                break;
            default:
                break;
        }
        if (isnormal) {
            if (iKeyboardClick != null) {
                iKeyboardClick.numberClick(Integer.valueOf(input));
            }
        }
    }

    public void setEnableSubmit(Boolean isEnableSubmit) {
        btnSubmit.setEnabled(isEnableSubmit);

    }

    public void setEnableKeyBoard(Boolean isEnable) {
        btnNumber0.setEnabled(isEnable);
        btnNumber1.setEnabled(isEnable);
        btnNumber2.setEnabled(isEnable);
        btnNumber3.setEnabled(isEnable);
        btnNumber4.setEnabled(isEnable);
        btnNumber5.setEnabled(isEnable);
        btnNumber6.setEnabled(isEnable);
        btnNumber7.setEnabled(isEnable);
        btnNumber8.setEnabled(isEnable);
        btnNumber9.setEnabled(isEnable);
        btnDelete.setEnabled(isEnable);
        btnSubmit.setEnabled(isEnable);
    }

    public void setIKeyboardClick(IKeybroadClick iKeyboardClick) {
        this.iKeyboardClick = iKeyboardClick;
    }
}

