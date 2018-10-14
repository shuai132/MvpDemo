package com.xiaoyezi.mvpdemo.api;

import com.xiaoyezi.mvpdemo.BuildConfig;
import com.xiaoyezi.mvpdemo.api.interceptor.CacheInterceptor;
import com.xiaoyezi.mvpdemo.api.interceptor.ReadCookiesInterceptor;
import com.xiaoyezi.mvpdemo.api.interceptor.RequestInterceptor;
import com.xiaoyezi.mvpdemo.api.interceptor.SaveCookiesInterceptor;
import com.xiaoyezi.mvpdemo.api.repository.WebService;
import com.xiaoyezi.mvpdemo.utils.FileManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    @Singleton
    @Provides
    public static RequestInterceptor provideRequestInterceptor() {
        return new RequestInterceptor();
    }

    @Singleton
    @Provides
    public static ReadCookiesInterceptor provideReadCookiesInterceptor() {
        return new ReadCookiesInterceptor();
    }

    @Singleton
    @Provides
    public static SaveCookiesInterceptor provideSaveCookiesInterceptor() {
        return new SaveCookiesInterceptor();
    }

    @Singleton
    @Provides
    public static CacheInterceptor provideCacheInterceptor() {
        return new CacheInterceptor();
    }

    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient(CacheInterceptor cacheInterceptor,
                                                   RequestInterceptor requestInterceptor,
                                                   ReadCookiesInterceptor readCookiesInterceptor,
                                                   SaveCookiesInterceptor saveCookiesInterceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        Cache cache = new Cache(FileManager.getCacheFile(), 1024 * 1024 * 50);
        builder.addInterceptor(cacheInterceptor);
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(requestInterceptor);
        builder.addInterceptor(readCookiesInterceptor);
        builder.addInterceptor(saveCookiesInterceptor);
        builder.cache(cache);
        builder.retryOnConnectionFailure(true);

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        return builder.build();
    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }

    @Singleton
    @Provides
    public static WebService provideWebService(Retrofit retrofit) {
        return retrofit.create(WebService.class);
    }
}
