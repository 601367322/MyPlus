package com.example.sbb.myapplication.base;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

import com.example.sbb.myapplication.utils.UIUtils;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

/**
 * Created by Administrator on 2014/12/22.
 */
@EActivity
public abstract class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //UIUtils.setSystemBarTintColor(this);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            UIUtils.setSystemBarTintColor(this);

        }
    }

    @AfterViews
    public abstract void init();

}
