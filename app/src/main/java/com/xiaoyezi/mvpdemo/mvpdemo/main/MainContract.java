package com.xiaoyezi.mvpdemo.mvpdemo.main;

import com.xiaoyezi.mvpdemo.dao.url.UrlItem;
import com.xiaoyezi.mvpdemo.mvpdemo.BaseMvp;

import java.util.List;

/**
 * Created by liushuai on 2018/2/11.
 */
public interface MainContract {
    interface View extends BaseMvp.View {

        void showUrlItems(List<UrlItem> urls);
    }

    interface Presenter extends BaseMvp.Presenter<View> {

        void saveUrl(String url);

        void deleteUrl(UrlItem urlItem);

        List<UrlItem> getAllUrlItems();

        void launchUrl(UrlItem urlItem);
    }
}
