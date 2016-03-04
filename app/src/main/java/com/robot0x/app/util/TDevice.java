package com.robot0x.app.util;

import android.content.pm.PackageManager;

import com.robot0x.app.base.BaseApplication;

/**
 * Created by Jackie on 2016/3/4.
 */
public class TDevice {

    public static int getVersionCode() {
        int versionCode = 0;
        try {
            versionCode = BaseApplication
                    .context()
                    .getPackageManager()
                    .getPackageInfo(BaseApplication.context().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException ex) {
            versionCode = 0;
        }
        return versionCode;
    }
}
