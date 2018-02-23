package com.xiaoyezi.mvpdemo.mvp.main;

import com.xiaoyezi.mvpdemo.data.url.UrlItem;
import com.xiaoyezi.mvpdemo.mvp.BaseMvpInterface;

import java.util.List;

/**
 * Created by liushuai on 2018/2/11.
 */

public interface MainContract {

    interface View extends BaseMvpInterface.View {

        void showUrlItems(List<UrlItem> urls);
    }

    interface Presenter extends BaseMvpInterface.Presenter<View> {

        void saveUrl(String url);

        void deleteUrl(UrlItem urlItem);

        List<UrlItem> getAllUrlItems();

        void launchUrl(UrlItem urlItem);
    }
}
