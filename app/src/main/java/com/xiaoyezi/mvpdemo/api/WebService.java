package com.xiaoyezi.mvpdemo.api;

import com.xiaoyezi.mvpdemo.model.UpdateInfoModel;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tianbaideng on 2018/1/10.
 */

public interface WebService {
    @GET("config/info")
    Single<UpdateInfoModel> getUpdateInfo(@Query("platform") int platform, @Query("apptype") String appType, @Query("appver") String appVer);
}
