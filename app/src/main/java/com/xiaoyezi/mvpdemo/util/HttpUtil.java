package com.xiaoyezi.mvpdemo.util;

import android.content.Intent;
import android.net.Uri;

import com.xiaoyezi.mvpdemo.app.MyApplication;

import java.util.regex.Pattern;

/**
 * Created by liushuai on 2018/2/9.
 */

public final class HttpUtil {

    private static final String REGEX_URL = "(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]";

    public static boolean isValidateUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    public static void launchUrl(String url) {
        Intent intent = new Intent()
                .setAction("android.intent.action.VIEW")
                .setData(Uri.parse(url));
        MyApplication.getContext().startActivity(intent);
    }
}
