package com.xiaoyezi.mvpdemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.view.Display;
import android.view.WindowManager;

import com.xiaoyezi.mvpdemo.app.MyApplication;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DeviceUtil {

    public static final String DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00";

    public static String getSysLang() {
        return Locale.getDefault().getLanguage();
    }

    public static String getMacAddress() {
        String macAddress = getMacAddressByWifiInfo();
        if (!DEFAULT_MAC_ADDRESS.equals(macAddress)) {
            return macAddress;
        }
        macAddress = getMacAddressByNetworkInterface();
        if (!DEFAULT_MAC_ADDRESS.equals(macAddress)) {
            return macAddress;
        }
        return DEFAULT_MAC_ADDRESS;
    }

    private static String getMacAddressByWifiInfo() {
        try {
            @SuppressLint("WifiManagerLeak")
            WifiManager wifi = (WifiManager) MyApplication.getContext().getSystemService(Context.WIFI_SERVICE);
            if (wifi != null) {
                WifiInfo info = wifi.getConnectionInfo();
                if (info != null) return info.getMacAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DEFAULT_MAC_ADDRESS;
    }

    private static String getMacAddressByNetworkInterface() {
        try {
            List<NetworkInterface> nis = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface ni : nis) {
                if (!ni.getName().equalsIgnoreCase("wlan0")) continue;
                byte[] macBytes = ni.getHardwareAddress();
                if (macBytes != null && macBytes.length > 0) {
                    StringBuilder res1 = new StringBuilder();
                    for (byte b : macBytes) {
                        res1.append(String.format("%02x:", b));
                    }
                    return res1.deleteCharAt(res1.length() - 1).toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DEFAULT_MAC_ADDRESS;
    }

    public static boolean isNetworkConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    public static boolean isMobileNetConnected() {
        ConnectivityManager cm = (ConnectivityManager)
                MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return networkInfo != null && isNetworkConnected() && networkInfo.isConnected();
    }

    public static boolean isWifiConnected() {
        ConnectivityManager cm = (ConnectivityManager)
                MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return networkInfo != null && isNetworkConnected() && networkInfo.isConnected();
    }

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }
}
