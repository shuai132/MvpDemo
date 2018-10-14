package com.xiaoyezi.mvpdemo.mvpdemo.main;

import com.xiaoyezi.mvpdemo.api.repository.WebServiceRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    public static MainPresenter provideMainPresenter(WebServiceRepository webServiceRepository) {
        return new MainPresenter(webServiceRepository);
    }
}
