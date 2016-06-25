package com.example.administrator.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

import com.vic.base.control.HttpRequestManager;

/**
 * Created by Administrator on 2016/6/25.
 */
public abstract class BaseActivity extends Activity{
    public HttpRequestManager mHttpRequestManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initManager();
    }

    private void initManager() {
        mHttpRequestManager = HttpRequestManager.getInstance();
    }


    public abstract void initViews();

    public abstract void initData();
}
