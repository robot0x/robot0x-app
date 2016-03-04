package com.robot0x.app.ui.dialog;

import android.app.ProgressDialog;

/**
 * Created by Jackie on 2016/3/4.
 */
public interface DialogControl {
    public abstract void hideWaitDialog();

    public abstract ProgressDialog showWaitDialog();

    public abstract ProgressDialog showWaitDialog(int resid);

    public abstract ProgressDialog showWaitDialog(String text);
}
