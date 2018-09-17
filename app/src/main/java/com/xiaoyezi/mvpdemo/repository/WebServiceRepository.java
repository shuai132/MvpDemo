package com.xiaoyezi.mvpdemo.repository;

import com.xiaoyezi.mvpdemo.api.WebService;
import com.xiaoyezi.mvpdemo.model.UpdateInfoModel;

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
