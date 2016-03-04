package com.robot0x.app.api;

import android.os.Build;

import com.robot0x.app.AppContext;

/**
 * Created by Jackie on 2016/3/4.
 */
public class ApiClientHelper {

    public static String getUserAgent(AppContext appContext) {
        StringBuilder ua = new StringBuilder("robot0x.com");
        ua.append("/" + appContext.getPackageInfo().versionName + '_'
            + appContext.getPackageInfo().versionCode); // app版本信息
        ua.append("/android");// 手机系统平台
        ua.append("/" + Build.VERSION.RELEASE);// 手机系统版本
        ua.append("/" + Build.MODEL);// 手机型号
        ua.append("/" + appContext.getAppId());// 客户端唯一标识
        return ua.toString();
    }
}
