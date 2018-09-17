package com.xiaoyezi.mvpdemo.app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDexApplication;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.xiaoyezi.mvpdemo.di.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;

public class MyApplication extends MultiDexApplication implements HasFragmentInjector, HasActivityInjector {
    private static MyApplication application;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        DaggerAppComponent.builder().application(this).build().inject(this);

        FlowManager.init(this);
    }

    public static Context getContext() {
        return application.getApplicationContext();
    }

    public static void runOnUiThread(Runnable runnable) {
        Handler handler = new Handler(MyApplication.getContext().getMainLooper());
        handler.post(runnable);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
