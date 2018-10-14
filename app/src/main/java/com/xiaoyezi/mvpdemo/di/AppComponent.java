package com.xiaoyezi.mvpdemo.di;

import com.xiaoyezi.mvpdemo.api.ApiModule;
import com.xiaoyezi.mvpdemo.app.MyApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        ApiModule.class,
        AndroidInjectionModule.class,
        RepositoryModule.class,
        ActivityBindingModule.class
})
public interface AppComponent {
    void inject(MyApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(MyApplication application);

        AppComponent build();
    }
}
