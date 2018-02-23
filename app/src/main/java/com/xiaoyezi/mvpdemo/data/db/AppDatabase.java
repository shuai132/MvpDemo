package com.xiaoyezi.mvpdemo.data.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by liushuai on 2018/2/11.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public final class AppDatabase {

    public static final String NAME = "AppDatabase";

    public static final int VERSION = 1;
}
