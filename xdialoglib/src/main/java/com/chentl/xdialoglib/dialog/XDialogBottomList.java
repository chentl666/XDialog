package com.chentl.xdialoglib.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.chentl.xdialoglib.R;
import com.chentl.xdialoglib.adapter.DialogBottomAdapter;
import com.chentl.xdialoglib.model.BottomListMenuItem;
import com.chentl.xdialoglib.model.SelectDialogListener;

import java.util.ArrayList;
import java.util.List;

public class XDialogBottomList extends Dialog implements View.OnClickListener, AdapterView.OnItemClickListener {
    private static Activity mActivity;
    private Button mMBtn_Cancel;
    private TextView mTv_Title;
    private static List<BottomListMenuItem> btnMenu;
    private static String mTitle;
    private static int mTitleItemColor = Color.parseColor("#4a4a4a");
    private static int mTitleItemTextSize = 18;
    private static String mCancel = "取消";
    private static int mcancelItemColor = Color.parseColor("#4a4a4a");
    private static int mcancelItemTextSize = 16;

    private static boolean mTouchable = true;

    public XDialogBottomList(Activity activity) {
        super(activity, R.style.common_dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.view_dialog_select,
                null);
        setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        Window window = getWindow();
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = mActivity.getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        onWindowAttributesChanged(wl);
        initViews();
    }

    private void initViews() {
        DialogBottomAdapter dialogAdapter=new DialogBottomAdapter(mActivity,btnMenu);
        ListView dialogList = findViewById(R.id.dialog_list);
        dialogList.setOnItemClickListener(this);
        dialogList.setAdapter(dialogAdapter);
        mMBtn_Cancel = findViewById(R.id.mBtn_Cancel);
        mTv_Title = findViewById(R.id.mTv_Title);
        mMBtn_Cancel.setOnClickListener(this);
        if (!TextUtils.isEmpty(mTitle) && mTv_Title != null) {
            mTv_Title.setVisibility(View.VISIBLE);
            mTv_Title.setText(mTitle);
        } else {
            mTv_Title.setVisibility(View.GONE);
        }
        mMBtn_Cancel.setTextColor(mcancelItemColor);
        mMBtn_Cancel.setTextSize(mcancelItemTextSize);
        mMBtn_Cancel.setText(mCancel);

        setCanceledOnTouchOutside(mTouchable);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        btnMenu.get(position).getmListener().onItemClick(parent, view, position, id);
        dismiss();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        btnMenu = null;
        mActivity = null;
    }

    public static class Builder {

        public Builder(Activity activity) {
            mActivity = activity;
            btnMenu = new ArrayList<BottomListMenuItem>();
        }


        public Builder addMenuItem(BottomListMenuItem item) {
            btnMenu.add(item);
            return this;
        }

        public Builder addMenuListItem(List<String> mReportList, SelectDialogListener clickListener) {
            BottomListMenuItem item = null;
            for (int i = 0; i < mReportList.size(); i++) {
                item = new BottomListMenuItem(mReportList.get(i), clickListener);
                btnMenu.add(item);
            }
            return this;
        }

        public Builder addMenuListItem(List<String> mReportList, SelectDialogListener clickListener, int color, int textsize) {
            BottomListMenuItem item = null;
            for (int i = 0; i < mReportList.size(); i++) {
                item = new BottomListMenuItem(mReportList.get(i), clickListener, color, textsize);
                btnMenu.add(item);
            }
            return this;
        }

        public Builder setCancelContent(String c) {
            mCancel = c;
            return this;
        }

        public Builder setCancelColor(int cancelItemColor) {
            mcancelItemColor = cancelItemColor;
            return this;
        }

        public Builder setCancelTextSize(int cancelItemTextSize) {
            mcancelItemTextSize = cancelItemTextSize;
            return this;
        }

        public Builder setTitleContent(String title) {
            mTitle = title;
            return this;
        }

        public Builder setTitleColor(int titleItemColor) {
            mTitleItemColor = titleItemColor;
            return this;
        }

        public Builder setTitleTextSize(int titleItemTextSize) {
            mTitleItemTextSize = titleItemTextSize;
            return this;
        }

        public Builder setTouchable(boolean touchable) {
            mTouchable = touchable;
            return this;
        }

        public XDialogBottomList show() {
            if (null != mActivity && (!(mActivity instanceof Activity) || !((Activity) mActivity).isFinishing())) {
                XDialogBottomList dialog = new XDialogBottomList(mActivity);
                dialog.show();
                return dialog;
            }
            return null;
        }
    }

}
