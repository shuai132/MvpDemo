package com.xiaoyezi.mvpdemo.mvpdemo;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by liushuai on 2018/2/11.
 */

public abstract class BasePresenter<V extends BaseMvp.View> implements BaseMvp.Presenter<V> {

    private Reference<V> view;

    @Override
    public void attachView(V view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (view != null) {
            view.clear();
            view = null;
        }
    }

    @Override
    public final V getView() {
        if (view == null)
            return null;

        return view.get();
    }

    @Override
    public boolean isViewBind() {
        return view != null;
    }
}
