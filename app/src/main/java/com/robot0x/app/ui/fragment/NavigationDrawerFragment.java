package com.robot0x.app.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robot0x.app.base.BaseFragment;

/**
 * Created by Jackie on 2016/3/4.
 */
public class NavigationDrawerFragment extends BaseFragment implements View.OnClickListener {

    private int mCurrentSelectedPosition = 0;
    private boolean mFromSavedInstanceState;
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            mCurrentSelectedPosition = savedInstanceState.getInt(STATE_SELECTED_POSITION);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initView(View view) {
        super.initView(view);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}
