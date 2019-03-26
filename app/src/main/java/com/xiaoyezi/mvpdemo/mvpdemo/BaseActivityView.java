package com.xiaoyezi.mvpdemo.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

/**
 * Created by liushuai on 2019/2/20.
 */
public abstract class BaseActivityView extends AppCompatActivity implements BaseMvp.View {
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidInjection.inject(this);

        if (getLayoutResId() != -1) {
            setContentView(getLayoutResId());
        }
        unbinder = ButterKnife.bind(this);
        bindMVP();
        initViews();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void bindMVP() {}

    protected void initViews() {}

    protected int getLayoutResId() {
        return -1;
    }
}
