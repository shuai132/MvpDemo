package com.xiaoyezi.mvpdemo.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by liushuai on 2018/2/22.
 */

public abstract class BaseActivityView<P extends BaseMvpInterface.Presenter> extends AppCompatActivity implements BaseMvpInterface.View {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindMVP();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public final void bindMVP() {
        presenter = getPresenterImpl();
        presenter.attachView(this);
    }

    protected abstract P getPresenterImpl();
}
