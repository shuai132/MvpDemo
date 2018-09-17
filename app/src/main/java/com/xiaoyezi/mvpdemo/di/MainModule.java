package com.xiaoyezi.mvpdemo.di;

import com.xiaoyezi.mvpdemo.mvp.main.MainPresenter;
import com.xiaoyezi.mvpdemo.repository.WebServiceRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    public static MainPresenter provideMainPresenter(WebServiceRepository webServiceRepository) {
        return new MainPresenter(webServiceRepository);
    }
}
