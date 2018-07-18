package com.chentl.xdialoglib.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chentl.xdialoglib.R;
import com.chentl.xdialoglib.model.BottomListMenuItem;

import java.util.List;

public class DialogBottomAdapter extends BaseAdapter {
    private List<BottomListMenuItem> btnMenu;
    private Viewholder viewholder;
    private LayoutInflater layoutInflater;

    public DialogBottomAdapter(Activity context, List<BottomListMenuItem> btnMenu) {
        this.btnMenu = btnMenu;
        this.layoutInflater = context.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return btnMenu.size();
    }

    @Override
    public Object getItem(int position) {
        return btnMenu.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            viewholder = new Viewholder();
            convertView = layoutInflater.inflate(R.layout.view_dialog_item, null);
            viewholder.dialogItemButton = (TextView) convertView.findViewById(R.id.dialog_item_bt);
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        viewholder.dialogItemButton.setText(btnMenu.get(position).getContent());
        viewholder.dialogItemButton.setTextColor(btnMenu.get(position).getColor());
        viewholder.dialogItemButton.setTextSize(btnMenu.get(position).getTextsize());
        if (1 == btnMenu.size()) {
            viewholder.dialogItemButton.setBackgroundResource(R.drawable.dialog_item_bg_only);
        } else if (position == 0) {
            viewholder.dialogItemButton.setBackgroundResource(R.drawable.select_dialog_item_bg_top);
        } else if (position == btnMenu.size() - 1) {
            viewholder.dialogItemButton.setBackgroundResource(R.drawable.select_dialog_item_bg_buttom);
        } else {
            viewholder.dialogItemButton.setBackgroundResource(R.drawable.select_dialog_item_bg_center);
        }
        return convertView;
    }
    public class Viewholder {
        public TextView dialogItemButton;
    }
}
