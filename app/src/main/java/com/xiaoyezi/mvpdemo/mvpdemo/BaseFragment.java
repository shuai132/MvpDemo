package com.xiaoyezi.mvpdemo.mvpdemo;

/**
 * Created by liushuai on 2018/2/22.
 */
public abstract class BaseFragment<P extends BaseMvp.Presenter> extends BaseFragmentView {
    protected P presenter;

    @Override
    public void onDestroyView() {
        presenter.detachView();
        super.onDestroyView();
    }

    @Override
    public final void bindMVP() {
        presenter = getPresenterImpl();
        presenter.attachView(this);
    }

    protected abstract P getPresenterImpl();
}
