package com.xiaoyezi.mvpdemo.api.repository;

import com.xiaoyezi.mvpdemo.api.model.UpdateInfoModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebService {
    @GET("config/info")
    Single<UpdateInfoModel> getUpdateInfo(@Query("platform") int platform, @Query("apptype") String appType, @Query("appver") String appVer);
}
