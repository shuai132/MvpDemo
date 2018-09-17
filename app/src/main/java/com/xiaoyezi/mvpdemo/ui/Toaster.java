package com.xiaoyezi.mvpdemo.ui;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.xiaoyezi.mvpdemo.app.MyApplication;

public class Toaster {

    public static void show(@StringRes int resId) {
        Toast.makeText(MyApplication.getContext(), resId, Toast.LENGTH_SHORT).show();
    }

    public static void show(CharSequence text) {
        Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(CharSequence text) {
        Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_LONG).show();
    }
}
