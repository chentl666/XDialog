package com.chentl.xdialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.chentl.xdialoglib.dialog.XDialogBottomList;
import com.chentl.xdialoglib.dialog.XDialogMiddle;
import com.chentl.xdialoglib.model.BottomListMenuItem;
import com.chentl.xdialoglib.model.SelectDialogListener;
import com.chentl.xdialoglib.model.ViewDialogListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.mbottom1).setOnClickListener(this);
        findViewById(R.id.middle1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mbottom1:
                showBottomListDialog1();
                break;
            case R.id.middle1:
                showMiddleDialog1();
                break;
        }
    }

    private void showMiddleDialog1() {
        Spanned spanned = Html.fromHtml("这是一个<font color='#00ffff'>富文本</font>");
        new XDialogMiddle.Builder(this)
                .setContentGravity(Gravity.CENTER)
                .setTouchAble(true)
                .setTitle("提示")
//                .setContent("你确定要退出吗？")
                .setContent(spanned)
                .setContentSize(16)
                .setTitleSize(18)
                .setOneButtonSize(14)
                .setLeftButtonSize(14)
                .setRightButtonSize(14)
                .setContentColor(Color.parseColor("#e91193"))
                .setTitleColor(Color.parseColor("#e91193"))
                .setOneButtonColor(Color.parseColor("#e91193"))
                .setLeftButtonColor(Color.parseColor("#e91193"))
                .setRightButtonColor(Color.parseColor("#e91193"))
//                .setOneButtonInterface("确定", new ViewDialogListener {
//                    @Override
//                    public void onItemClick(View view) {
//                        Toast.makeText(MainActivity.this, "点击一个按钮", Toast.LENGTH_SHORT).show();
//                    }
//                })
                .setLeftButtonInterface("取消", new ViewDialogListener() {
                    @Override
                    public void onItemClick(View view) {
                        Toast.makeText(MainActivity.this, "点击左边按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .setRightButtonInterface("确定", new ViewDialogListener() {
                    @Override
                    public void onItemClick(View view) {
                        Toast.makeText(MainActivity.this, "点击右边按钮", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void showBottomListDialog1() {
        List<String> names = new ArrayList<>();
        names.add("如果 button 宽高设置 wrap_content 并设置了 background 为一个图片的时候，会出现 wrap_content 无效的情况");
        names.add("相册");
        names.add("相机");

        new XDialogBottomList.Builder(this)
                .addMenuListItem(names, new SelectDialogListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, Color.parseColor("#e91855"), 18)

                .addMenuItem(new BottomListMenuItem("游戏", new SelectDialogListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }))

                .addMenuItem(new BottomListMenuItem("开心", new SelectDialogListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, "点击第几个位置    " + position, Toast.LENGTH_LONG).show();
                    }
                }, Color.parseColor("#e49633"), 12))
                .setCancelColor(Color.parseColor("#e91193"))
                .setCancelTextSize(18)
                .setCancelContent("取消")
                .setTitleColor(Color.parseColor("#e91193"))
                .setTitleTextSize(20)
                .setTitleContent("标题")
                .setTouchable(true)
                .show();
    }
}
