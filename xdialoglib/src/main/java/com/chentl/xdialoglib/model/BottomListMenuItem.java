package com.chentl.xdialoglib.model;

import android.graphics.Color;

public  class BottomListMenuItem {
    private SelectDialogListener mListener;
    private String content;
    private int color = Color.parseColor("#4a4a4a");
    private int textsize = 16;

    public BottomListMenuItem(String content, SelectDialogListener clickListener) {
        this.content = content;
        this.mListener = clickListener;
    }

    public BottomListMenuItem(String content, SelectDialogListener clickListener, int color) {
        this.content = content;
        this.color = color;
        this.mListener = clickListener;
    }

    public BottomListMenuItem(String content, SelectDialogListener clickListener, int color, int textsize) {
        this.content = content;
        this.color = color;
        this.textsize = textsize;
        this.mListener = clickListener;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTextsize() {
        return textsize;
    }

    public void setTextsize(int textsize) {
        this.textsize = textsize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public SelectDialogListener getmListener() {
        return mListener;
    }

    public void setmListener(SelectDialogListener mListener) {
        this.mListener = mListener;
    }
}
