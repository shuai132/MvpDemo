package com.xiaoyezi.mvpdemo.mvpdemo;

/**
 * Created by liushuai on 2018/2/22.
 */
public abstract class BaseActivity<P extends BaseMvp.Presenter> extends BaseActivityView {
    protected P presenter;

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public final void bindMVP() {
        presenter = getPresenterImpl();
        presenter.attachView(this);
    }

    protected void initViews() {}

    protected abstract P getPresenterImpl();
}
