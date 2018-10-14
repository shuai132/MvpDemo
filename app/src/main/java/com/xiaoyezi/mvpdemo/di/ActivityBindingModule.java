package com.xiaoyezi.mvpdemo.di;

import com.xiaoyezi.mvpdemo.mvpdemo.main.MainModule;
import com.xiaoyezi.mvpdemo.mvpdemo.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity provideMainActivity();
}
