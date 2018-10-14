package com.xiaoyezi.mvpdemo.mvpdemo;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.AndroidInjection;

/**
 * Created by liushuai on 2018/2/22.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseMvp.View {
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        bindMVP();

        if (getLayoutId() != -1) {
            setContentView(getLayoutId());
        }

        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        BasePresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.detachView();
        }

        unbinder.unbind();
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
