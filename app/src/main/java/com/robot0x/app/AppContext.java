package com.robot0x.app;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.PersistentCookieStore;
import com.robot0x.app.api.ApiHttpClient;
import com.robot0x.app.base.BaseApplication;
import com.robot0x.app.util.StringUtil;

import org.kymjs.kjframe.http.HttpConfig;

import java.net.HttpCookie;
import java.util.UUID;

/**
 * Created by Jackie on 2016/3/4.
 */
public class AppContext extends BaseApplication {

    private static AppContext instance;


    public static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();

    }

    /**
     * 获取App安装包信息
     * @return
     */
    public PackageInfo getPackageInfo() {
        PackageInfo info = null;
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (info == null) {
            info = new PackageInfo();
        }

        return info;
    }

    public String getAppId() {
        String uniqueID = getProperty(AppConfig.CONF_APP_UNIQUEID);
        if (StringUtil.isEmpty(uniqueID)) {
            uniqueID = UUID.randomUUID().toString();
            setProperty(AppConfig.CONF_APP_UNIQUEID, uniqueID);
        }
        return uniqueID;
    }

    public void setProperty(String key, String value) {
        AppConfig.getAppConfig(this).set(key, value);
    }

    public String getProperty(String key) {
        String res = AppConfig.getAppConfig(this).get(key);
        return res;
    }

    private void init() {
        // 初始化网络请求
        AsyncHttpClient client = new AsyncHttpClient();
        PersistentCookieStore cookieStore = new PersistentCookieStore(this);
        client.setCookieStore(cookieStore);
        ApiHttpClient.setHttpClient(client);

        HttpConfig.CACHEPATH = "robot0x/imagecache";
    }
}
