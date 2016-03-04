package com.robot0x.app.base;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robot0x.app.AppContext;
import com.robot0x.app.R;
import com.robot0x.app.interf.BaseFragmentInterface;
import com.robot0x.app.ui.dialog.DialogControl;

/**
 * Created by Jackie on 2016/3/4.
 */
public class BaseFragment extends Fragment implements
        View.OnClickListener, BaseFragmentInterface {

    protected LayoutInflater mInflater;

    public AppContext getApplication() {
        return (AppContext)getActivity().getApplication();
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mInflater = inflater;
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        return false;
    }

    protected View getLayoutId(int resId) {
        return this.mInflater.inflate(resId, null);
    }

    protected void hideWaitDialog() {
        FragmentActivity activity = (FragmentActivity) getActivity();
        if (activity instanceof DialogControl) {
            ((DialogControl)activity).hideWaitDialog();
        }
    }

    protected ProgressDialog showWaitDialog() {
        return showWaitDialog(R.string.loading);
    }

    protected ProgressDialog showWaitDialog(int resid) {
        FragmentActivity activity = (FragmentActivity) getActivity();
        if (activity instanceof DialogControl) {
            return ((DialogControl)activity).showWaitDialog(resid);
        }
        return null;
    }

    protected ProgressDialog showWaitDialog(String str) {
        FragmentActivity activity = (FragmentActivity) getActivity();
        if (activity instanceof DialogControl) {
            return ((DialogControl)activity).showWaitDialog(str);
        }
        return null;
    }
}
