package com.xiaoyezi.mvpdemo.mvpdemo;

/**
 * Created by liushuai on 2018/2/11.
 */

public interface BaseMvp {

    interface View {
        void bindMVP();
    }

    interface Presenter<V extends View> {
        void attachView(V view);
        void detachView();
        V getView();
        boolean isViewBind();
    }
}
