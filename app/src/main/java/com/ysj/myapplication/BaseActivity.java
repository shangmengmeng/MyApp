package com.ysj.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pig on 2016/12/25.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout();
        initView();
        setData();

    }

    protected abstract void setLayout();



    protected abstract void initView();

    protected abstract void setData();
}
