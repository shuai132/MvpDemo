package com.xiaoyezi.mvpdemo.mvpdemo.main;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    static MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
