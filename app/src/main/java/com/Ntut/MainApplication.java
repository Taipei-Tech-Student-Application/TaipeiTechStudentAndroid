package com.Ntut;

import android.app.Application;
import android.content.SharedPreferences;

import com.Ntut.model.Model;

import java.net.*;

/**
 * Created by blackmaple on 2017/5/8.
 */

public class MainApplication extends Application {
    private static MainApplication singleton;
    public static String SETTING_NAME = "TaipeiTech";
    public static MainApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CookieHandler.setDefault(new java.net.CookieManager(null, CookiePolicy.ACCEPT_ALL));
        singleton = this;
        Model.getInstance();
    }

    public static String readSetting(String settingName) {
        SharedPreferences settings = singleton.getSharedPreferences(
                SETTING_NAME, MODE_PRIVATE);
        return settings.getString(settingName, "");
    }

    public static void writeSetting(String settingName, String value) {
        SharedPreferences settings = singleton.getSharedPreferences(
                SETTING_NAME, MODE_PRIVATE);
        settings.edit().putString(settingName, value).apply();
    }

    public static void clearSettings(String settingName) {
        SharedPreferences settings = singleton.getSharedPreferences(
                SETTING_NAME, MODE_PRIVATE);
        settings.edit().remove(settingName).apply();
    }
}
