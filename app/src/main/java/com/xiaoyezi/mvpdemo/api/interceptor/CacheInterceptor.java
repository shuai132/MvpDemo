package com.xiaoyezi.mvpdemo.api.interceptor;

import com.xiaoyezi.mvpdemo.api.ApiException;
import com.xiaoyezi.mvpdemo.util.DeviceUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!DeviceUtil.isNetworkConnected()) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
        }
        Response response = chain.proceed(request);
        if (DeviceUtil.isNetworkConnected()) {
            int maxAge = 0;
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public,max-age=" + maxAge)
                    .build();
        } else {
            if (!response.isSuccessful()) {
                throw new ApiException(ApiException.NETWORK_NOT_CONNECTED, "network not connected");
            }
            long maxStale = 60 * 60 * 24 * 28;
            response = response.newBuilder()
                    .removeHeader("Pragma")
                    .header("Cache-Control", "public,only-if-cached,max-stale=" + maxStale)
                    .build();
        }
        return response;
    }
}
