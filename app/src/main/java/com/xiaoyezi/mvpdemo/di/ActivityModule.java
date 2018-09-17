package com.xiaoyezi.mvpdemo.di;

import com.xiaoyezi.mvpdemo.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity provideMainActivity();
}
