package com.chentl.xdialoglib.model;

import android.app.Dialog;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MiddleDialogController {
    private  Dialog mDialog;
    public String mTitle = "";
    public String mContent = "";
    public Spanned mSpanned;
    public int mGravity;
    public int mContentSize;
    public int mTitleSize;
    public int mLeftButtonSize;
    public int mRightButtonSize;
    public int mOneButtonSize;

    public int mContentColor;
    public int mTitleColor;
    public int mLeftButtonColor;
    public int mRightButtonColor;
    public int mOneButtonColor;

    public String mLeftButtonMsg = "";
    public String mRightButtonMsg = "";
    public String mOneButtonMsg = "";
    public boolean mNeedComment = false;
    public ViewDialogListener mLeftButtonInterface = null;
    public ViewDialogListener mRightButtonInterface = null;
    public ViewDialogListener mOneButtonInterface = null;
    public TextView mTitleView = null;
    public TextView mContentView = null;
    public TextView mOneButton = null;
    public TextView mLeftButton = null;
    public TextView mRightButton = null;
    public EditText mComment = null;

    public RelativeLayout mLayoutOneButtons = null;
    public RelativeLayout mLayoutTwoButtons = null;

    public boolean mTouchable = true;

    public MiddleDialogController(Dialog dialog) {
       this.mDialog = dialog;
    }

    public String getComment() {
        if (mComment != null && mComment.getText() != null) {
            return mComment.getText().toString();
        }
        return "";
    }

    public void installView() {
        if (mTitleView != null) { //标题栏
            if (mTitle == null || "".equalsIgnoreCase(mTitle)) {
                mTitleView.setVisibility(View.GONE);
            } else {
                mTitleView.setVisibility(View.VISIBLE);
                mTitleView.setText(mTitle);
                if (mTitleSize > 0) {
                    mTitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mTitleSize);
                }
                mTitleView.setTextColor(mTitleColor);
            }
        }
        if (mContentView != null) {  //对话框内容
            if (TextUtils.isEmpty(mContent) && mSpanned == null) {
                mContentView.setVisibility(View.GONE);
            } else {
                mContentView.setVisibility(View.VISIBLE);
                if (mSpanned == null) {
                    mContentView.setText(mContent);
                } else {
                    mContentView.setText(mSpanned);
                }

                if (mGravity > 0) {
                    mContentView.setGravity(mGravity);
                }
                if (mContentSize > 0) {
                    mContentView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mContentSize);
                }
                mContentView.setTextColor(mContentColor);
            }
        }

        if (mOneButton != null && !TextUtils.isEmpty(mOneButtonMsg)) {
            mLayoutOneButtons.setVisibility(View.VISIBLE);
            mLayoutTwoButtons.setVisibility(View.GONE);
            mOneButton.setText(mOneButtonMsg);
            if (mOneButtonSize > 0) {
                mOneButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, mOneButtonSize);
            }
            mOneButton.setTextColor(mOneButtonColor);
            mOneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOneButtonInterface != null) {
                        mOneButtonInterface.onItemClick(view);
                    }
                    mDialog.dismiss();
                }
            });
        } else if (!TextUtils.isEmpty(mRightButtonMsg) && !TextUtils.isEmpty(mLeftButtonMsg)) {
            mLayoutTwoButtons.setVisibility(View.VISIBLE);
            mLayoutOneButtons.setVisibility(View.GONE);
            if (mLeftButton != null) { //左侧按钮
                if (mLeftButtonMsg == null || "".equalsIgnoreCase(mLeftButtonMsg)
                        || mLeftButtonInterface == null) {
                    mLeftButton.setVisibility(View.GONE);
                } else {
                    mLeftButton.setText(mLeftButtonMsg);
                    if (mLeftButtonSize > 0) {
                        mLeftButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, mLeftButtonSize);
                    }
                    mLeftButton.setTextColor(mLeftButtonColor);
                    mLeftButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mLeftButtonInterface != null) {
                                mLeftButtonInterface.onItemClick(view);
                            }
                            mDialog.dismiss();
                        }
                    });
                }
            }
            if (mRightButton != null) {  //右侧按钮
                if (mRightButtonMsg == null || "".equalsIgnoreCase(mRightButtonMsg)
                        || mRightButtonInterface == null) {
                    mRightButton.setVisibility(View.GONE);
                } else {
                    mRightButton.setText(mRightButtonMsg);
                    if (mRightButtonSize > 0) {
                        mRightButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, mRightButtonSize);
                    }
                    mRightButton.setTextColor(mRightButtonColor);
                    mRightButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mRightButtonInterface != null) {
                                mRightButtonInterface.onItemClick(view);
                            }
                            mDialog.dismiss();
                        }
                    });
                }
            }
        } else {
            mLayoutTwoButtons.setVisibility(View.GONE);
            mLayoutOneButtons.setVisibility(View.GONE);
        }
        mDialog.setCanceledOnTouchOutside(mTouchable);
        mDialog.setCancelable(mTouchable);
    }
}

