package com.xiaoyezi.mvpdemo.app;

import android.content.Context;
import android.os.Handler;

import com.raizlabs.android.dbflow.config.FlowManager;

public class Application extends android.app.Application {
    private static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        FlowManager.init(this);
    }

    public static Context context() {
        return application.getApplicationContext();
    }

    public static void runOnUiThread(Runnable runnable) {
        Handler handler = new Handler(Application.context().getMainLooper());
        handler.post(runnable);
    }
}
