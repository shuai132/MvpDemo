package com.xiaoyezi.mvpdemo.api.interceptor;


import com.xiaoyezi.mvpdemo.utils.PreferenceStore;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

import static com.xiaoyezi.mvpdemo.utils.Constants.PREF_KEY_COOKIE;

public class SaveCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        String requestUrl = originalResponse.request().url().toString();

        if (requestUrl.contains("/auth/signin") && !originalResponse.headers("Set-Cookie").isEmpty()) {
            StringBuilder cookies = new StringBuilder();

            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.append(header).append(";");
            }

            PreferenceStore.getInstance().saveString(PREF_KEY_COOKIE, cookies.toString());
        }

        return originalResponse;
    }
}
