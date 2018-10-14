package com.xiaoyezi.mvpdemo.mvpdemo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

/**
 * Created by liushuai on 2018/9/25.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseMvp.View {
    private Unbinder unbinder;

    @Override
    public void onAttach(Activity activity) {
        AndroidInjection.inject(this);
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        bindMVP();

        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.detachView();
        }
    }

    @Override
    public final void bindMVP() {
        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        presenter.attachView(this);
    }

    /**
     * @return -1 if no need layout
     */
    @LayoutRes
    protected abstract int getLayoutId();

    @Nullable
    protected abstract P getPresenter();
}
