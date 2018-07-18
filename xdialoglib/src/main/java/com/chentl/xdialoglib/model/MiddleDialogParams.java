package com.chentl.xdialoglib.model;

import android.content.Context;
import android.graphics.Color;
import android.text.Spanned;
import android.view.Gravity;

public class MiddleDialogParams {
    public String mTitle = "";
    public String mContent = "";
    public Spanned mSpanned;
    public int mGravity = Gravity.CENTER;
    public int mContentSize = 16;
    public int mTitleSize = 18;
    public int mLeftButtonSize = 14;
    public int mRightButtonSize = 14;
    public int mOneButtonSize = 14;
    public int mContentColor = Color.parseColor("#4a4a4a");
    public int mTitleColor = Color.parseColor("#4a4a4a");
    public int mLeftButtonColor = Color.parseColor("#4a4a4a");
    public int mRightButtonColor = Color.parseColor("#4a4a4a");
    public int mOneButtonColor = Color.parseColor("#4a4a4a");
    public String mLeftButtonMsg = "";
    public String mRightButtonMsg = "";
    public String mOneButtonMsg = "";
    public ViewDialogListener mLeftButtonInterface = null;
    public ViewDialogListener mRightButtonInterface = null;
    public ViewDialogListener mOneButtonInterface = null;
    public Context mContext = null;
    public boolean mTouchAble = false;

    public MiddleDialogParams(Context context) {
        mContext = context;
    }

    public void apply(MiddleDialogController controller) {
        controller.mTitle = mTitle;
        controller.mContent = mContent;
        controller.mSpanned = mSpanned;
        controller.mGravity = mGravity;
        controller.mContentSize = mContentSize;
        controller.mTitleSize = mTitleSize;
        controller.mLeftButtonSize = mLeftButtonSize;
        controller.mRightButtonSize = mRightButtonSize;
        controller.mOneButtonSize = mOneButtonSize;

        controller.mContentColor = mContentColor;
        controller.mTitleColor = mTitleColor;
        controller.mLeftButtonColor = mLeftButtonColor;
        controller.mRightButtonColor = mRightButtonColor;
        controller.mOneButtonColor = mOneButtonColor;

        controller.mOneButtonMsg = mOneButtonMsg;
        controller.mLeftButtonMsg = mLeftButtonMsg;
        controller.mRightButtonMsg = mRightButtonMsg;
        controller.mLeftButtonInterface = mLeftButtonInterface;
        controller.mRightButtonInterface = mRightButtonInterface;
        controller.mOneButtonInterface = mOneButtonInterface;
        controller.mTouchable = mTouchAble;
    }
}
