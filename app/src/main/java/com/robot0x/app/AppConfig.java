package com.robot0x.app;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by Jackie on 2016/3/4.
 */
public class AppConfig {

    public static final String CONF_APP_UNIQUEID = "APP_UNIQUEID";
    public static final String COOKIE = "cookie";

    // Directory name and File name
    public static final String APP_CONFIG = "config";

    private static AppConfig appConfig;
    private Context mContext;


    public static AppConfig getAppConfig(Context context) {
        if (appConfig == null) {
            appConfig = new AppConfig();
            appConfig.mContext = context;
        }
        return appConfig;
    }

    public String get(String key) {
        Properties props = get();
        return (props != null) ? props.getProperty(key) : null;
    }

    public void set(String key, String value) {
        Properties props = get();
        props.setProperty(key, value);
        saveProps(props);
    }

    private void saveProps(Properties p) {
        FileOutputStream fos = null;
        try {
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            File conf = new File(dirConf, APP_CONFIG);
            fos = new FileOutputStream(conf);
            p.store(fos, null);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (Exception e) {

            }
        }
    }

    public Properties get() {
        FileInputStream fis = null;
        Properties props = new Properties();
        try {
            File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
            fis = new FileInputStream(dirConf.getPath() + File.separator + APP_CONFIG);
            props.load(fis);
        } catch (Exception e){
            try {
                fis.close();
            } catch (Exception ex) {

            }
        }
        return props;
    }
}
