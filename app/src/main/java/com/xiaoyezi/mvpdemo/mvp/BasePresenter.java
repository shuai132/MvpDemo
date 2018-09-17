package com.xiaoyezi.mvpdemo.mvp;

import com.xiaoyezi.mvpdemo.repository.WebServiceRepository;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by liushuai on 2018/2/11.
 */

public abstract class BasePresenter<V extends BaseMvp.View> implements BaseMvp.Presenter<V> {

    private Reference<V> view;

    private WebServiceRepository webServiceRepository;

    public BasePresenter(WebServiceRepository webServiceRepository) {
        this.webServiceRepository = webServiceRepository;
    }

    @Override
    public final void attachView(V view) {
        this.view = new WeakReference<>(view);
    }

    @Override
    public final void detachView() {
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
