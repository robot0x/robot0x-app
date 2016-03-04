package com.robot0x.app.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.robot0x.app.api.Robot0xApi;
import com.robot0x.app.util.StringUtil;

import org.kymjs.kjframe.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Jackie on 2016/3/4.
 */
public class LogUploadService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final File log = FileUtils.getSaveFile("robot0x", "robot0xLog.log");
        String data = null;
        try {
            FileInputStream inputStream = new FileInputStream(log);
            data = StringUtil.toConvertString(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!StringUtil.isEmpty(data)) {
            Robot0xApi.uploadLog(data, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    log.delete();
                    LogUploadService.this.stopSelf();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    LogUploadService.this.stopSelf();
                }
            });
        } else {
            LogUploadService.this.stopSelf();
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
