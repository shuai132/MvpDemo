package com.xiaoyezi.mvpdemo.mvpdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by liushuai on 2019/2/20.
 */
public abstract class BaseFragmentView extends Fragment implements BaseMvp.View {
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        bindMVP();
        initViews();
        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void bindMVP() {}

    protected void initViews() {}

    protected abstract int getLayoutResId();
}
