package com.xiaoyezi.mvpdemo.mvpdemo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;


import com.xiaoyezi.mvpdemo.R;

import butterknife.ButterKnife;

/**
 * Created by liushuai on 2019/2/25.
 */
public abstract class BaseDialog extends Dialog {
    public BaseDialog(Context context) {
        super(context, R.style.FullscreenDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(getLayoutResId(), null);
        setContentView(view);

        ButterKnife.bind(this, view);

        setCanceledOnTouchOutside(false);
    }

    @LayoutRes
    protected abstract int getLayoutResId();
}
