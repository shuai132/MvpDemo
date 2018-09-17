package com.xiaoyezi.mvpdemo.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.xiaoyezi.mvpdemo.app.MyApplication;

public final class PreferenceStore {
    private static final String NAME = PreferenceStore.class.getName();
    private static PreferenceStore instance;
    private static SharedPreferences preferences;

    public static PreferenceStore getInstance() {
        if (instance == null) {
            synchronized (PreferenceStore.class) {
                if (instance == null) {
                    instance = new PreferenceStore();
                    preferences = MyApplication.getContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
                }
            }
        }

        return instance;
    }

    public void saveString(String key, String data) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, data);
        editor.commit();
    }

    public String getString(String key, String def) {
        String ret = preferences.getString(key, def);

        return ret;
    }

    public void removeString(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.commit();
    }
}
