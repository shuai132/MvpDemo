package com.xiaoyezi.mvpdemo.api.repository;

import com.xiaoyezi.mvpdemo.api.model.UpdateInfoModel;

import io.reactivex.Single;

public class WebServiceRepository {
    private WebService webService;

    public WebServiceRepository(WebService webService) {
        this.webService = webService;
    }

    public Single<UpdateInfoModel> getUpdateInfo(int platform, String appType, String appVer) {
        return webService.getUpdateInfo(platform, appType, appVer);
    }
}
