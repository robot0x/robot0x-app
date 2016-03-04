package com.robot0x.app.ui.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TabHost.OnTabChangeListener;
import com.robot0x.app.interf.BaseViewInterface;

/**
 * Created by Jackie on 2016/3/4.
 */

@SuppressLint("InflateParams")
public class MainActivity extends ActionBarActivity implements
        BaseViewInterface, View.OnClickListener,
        OnTouchListener, OnTabChangeListener {

    @Override
    public void onTabChanged(String tabId) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
