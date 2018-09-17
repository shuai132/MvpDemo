package com.xiaoyezi.mvpdemo.api.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("X-PLATFORM", "Android");
        // TODO: Add more

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
