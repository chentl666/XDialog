package com.chentl.xdialoglib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Spanned;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chentl.xdialoglib.R;
import com.chentl.xdialoglib.model.MiddleDialogController;
import com.chentl.xdialoglib.model.MiddleDialogParams;
import com.chentl.xdialoglib.model.ViewDialogListener;

public class XDialogMiddle extends Dialog {
    private MiddleDialogController mController = null;

    public XDialogMiddle(Context context) {
        super(context, R.style.common_dialog);
        mController = new MiddleDialogController(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_select_dialog);
        installView();
    }

    private void installView() {
        mController.mTitleView = (TextView) findViewById(R.id.dialog_title);
        mController.mContentView = (TextView) findViewById(R.id.dialog_content_message);
        mController.mLayoutTwoButtons = (RelativeLayout) findViewById(R.id.dialog_two_button);
        mController.mLeftButton = (TextView) findViewById(R.id.dialog_left_button);
        mController.mRightButton = (TextView) findViewById(R.id.dialog_right_button);
        mController.mLayoutOneButtons = (RelativeLayout) findViewById(R.id.dialog_one_button);
        mController.mOneButton = (TextView) findViewById(R.id.dialog_confirm_button);
        mController.installView();
    }


    public static class Builder {
        private MiddleDialogParams mParams = null;
        private XDialogMiddle dialog = null;

        public Builder(Context context) {
            mParams = new MiddleDialogParams(context);
        }

        /**
         * 设置标题
         */
        public Builder setTitle(String title) {
            mParams.mTitle = title;
            return this;
        }

        /**
         * 设置内容
         */
        public Builder setContent(String content) {
            mParams.mContent = content;
            return this;
        }

        /**
         * 设置内容
         */
        public Builder setContent(Spanned spanned) {
            mParams.mSpanned = spanned;
            return this;
        }

        /**
         * 设置位置
         */
        public Builder setContentGravity(int gravity) {
            mParams.mGravity = gravity;
            return this;
        }

        /**
         * 设置内容 字体大小
         */
        public Builder setContentSize(int size) {//此参数请直接写sp的数值即可
            mParams.mContentSize = size;
            return this;
        }

        /**
         * 设置标题 字体大小
         */
        public Builder setTitleSize(int size) {//此参数请直接写sp的数值即可
            mParams.mTitleSize = size;
            return this;
        }

        /**
         * 设置一个按钮 字体大小
         */
        public Builder setOneButtonSize(int size) {//此参数请直接写sp的数值即可
            mParams.mOneButtonSize = size;
            return this;
        }

        /**
         * 设置左边按钮 字体大小
         */
        public Builder setLeftButtonSize(int size) {//此参数请直接写sp的数值即可
            mParams.mLeftButtonSize = size;
            return this;
        }

        /**
         * 设置右边按钮 字体大小
         */
        public Builder setRightButtonSize(int size) {//此参数请直接写sp的数值即可
            mParams.mRightButtonSize = size;
            return this;
        }

        /**
         * 设置内容 字体颜色
         */
        public Builder setContentColor(int color) {
            mParams.mContentColor = color;
            return this;
        }

        /**
         * 设置标题 字体颜色
         */
        public Builder setTitleColor(int color) {
            mParams.mTitleColor = color;
            return this;
        }

        /**
         * 设置一个按钮 字体颜色
         */
        public Builder setOneButtonColor(int color) {
            mParams.mOneButtonColor = color;
            return this;
        }

        /**
         * 设置左边按钮 字体颜色
         */
        public Builder setLeftButtonColor(int color) {
            mParams.mLeftButtonColor = color;
            return this;
        }

        /**
         * 设置右边按钮 字体颜色
         */
        public Builder setRightButtonColor(int color) {
            mParams.mRightButtonColor = color;
            return this;
        }

        /**
         * 设置一个按钮 点击监听
         */
        public Builder setOneButtonInterface(String buttonText, ViewDialogListener btn) {
            mParams.mOneButtonMsg = buttonText;
            mParams.mOneButtonInterface = btn;
            return this;
        }

        /**
         * 设置两个按钮 点击取消监听
         */
        public Builder setLeftButtonInterface(String leftButtonText, ViewDialogListener left) {
            mParams.mLeftButtonMsg = leftButtonText;
            mParams.mLeftButtonInterface = left;
            return this;
        }

        /**
         * 设置两个按钮 点击确认监听
         */
        public Builder setRightButtonInterface(String rightButtonText, ViewDialogListener right) {
            mParams.mRightButtonMsg = rightButtonText;
            mParams.mRightButtonInterface = right;
            return this;
        }

        /**
         * Dialog show
         */
        public XDialogMiddle show() {
            XDialogMiddle dialog = new XDialogMiddle(mParams.mContext);
            mParams.apply(dialog.mController);
            dialog.show();
            return dialog;
        }

        /**
         * Dialog dismiss
         */
        public void dismiss() {
            if (null != dialog && dialog.isShowing()) {
                dialog.dismiss();
                dialog = null;
            }
        }

        /**
         * 点击其他区域
         */
        public Builder setTouchAble(boolean touchAble) {
            mParams.mTouchAble = touchAble;
            return this;
        }
    }

}
