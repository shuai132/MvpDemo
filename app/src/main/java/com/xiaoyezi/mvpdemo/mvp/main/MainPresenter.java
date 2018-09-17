package com.xiaoyezi.mvpdemo.mvp.main;

import com.xiaoyezi.mvpdemo.data.url.UrlManager;
import com.xiaoyezi.mvpdemo.data.url.UrlItem;
import com.xiaoyezi.mvpdemo.mvp.BasePresenter;
import com.xiaoyezi.mvpdemo.repository.WebServiceRepository;
import com.xiaoyezi.mvpdemo.ui.Toaster;
import com.xiaoyezi.mvpdemo.util.HttpUtil;

import java.util.List;

/**
 * Created by liushuai on 2018/2/11.
 */

public final class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private UrlManager urlManager = UrlManager.getInstance();

    public MainPresenter(WebServiceRepository webServiceRepository) {
        super(webServiceRepository);
    }

    @Override
    public void saveUrl(String url) {
        urlManager.saveUrl(url);
        getView().showUrlItems(urlManager.getAllUrlItems());
    }

    @Override
    public void deleteUrl(UrlItem urlItem) {
        urlManager.deleteUrl(urlItem);
        getView().showUrlItems(urlManager.getAllUrlItems());
    }

    @Override
    public List<UrlItem> getAllUrlItems() {
        return urlManager.getAllUrlItems();
    }

    @Override
    public void launchUrl(UrlItem urlItem) {
        String url = urlItem.url;
        if (!HttpUtil.isValidateUrl(url)) {
            Toaster.show("Url is unavailable!");
            return;
        }
        HttpUtil.launchUrl(urlItem.url);
    }
}
