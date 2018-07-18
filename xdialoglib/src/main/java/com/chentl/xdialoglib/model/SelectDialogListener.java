package com.chentl.xdialoglib.model;

import android.view.View;
import android.widget.AdapterView;

public interface SelectDialogListener {
    public void onItemClick(AdapterView<?> parent, View view, int position, long id);
}
