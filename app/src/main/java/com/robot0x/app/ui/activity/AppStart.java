package com.robot0x.app.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.robot0x.app.AppManager;
import com.robot0x.app.R;
import com.robot0x.app.service.LogUploadService;
import com.robot0x.app.util.TDevice;

import org.kymjs.kjframe.http.KJAsyncTask;
import org.kymjs.kjframe.utils.FileUtils;
import org.kymjs.kjframe.utils.PreferenceHelper;

import java.io.File;

/**
 * Created by Jackie on 2016/3/3.
 */
public class AppStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 防止第三方跳转时出现双实例
        Activity activity = AppManager.getActivity(MainActivity.class);
        if (activity != null && !activity.isFinishing()) {
            finish();
            return;
        }

        final View view = View.inflate(this, R.layout.app_start, null);
        setContentView(view);

        AlphaAnimation aa = new AlphaAnimation(0.5f, 1.0f);
        aa.setDuration(800);
        aa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                redirectTo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(aa);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int cacheVersion = PreferenceHelper.readInt(this, "first_install", "first_install", -1);
        int currentVersion = TDevice.getVersionCode();
        if (cacheVersion < currentVersion) {
            PreferenceHelper.write(this, "first_install", "first_install", currentVersion);
            cleanImageCache();
        }
    }

    private void cleanImageCache() {
        final File folder = FileUtils.getSaveFolder("robot0x/imagecache");
        KJAsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                for (File file : folder.listFiles()) {
                    file.delete();
                }
            }
        });
    }

    /**
     * 跳转到主页
     */
    private void redirectTo() {
        Intent uploadLog = new Intent(this, LogUploadService.class);
        startService(uploadLog);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
