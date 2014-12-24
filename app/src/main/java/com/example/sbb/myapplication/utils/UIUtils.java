package com.example.sbb.myapplication.utils;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;

import com.example.sbb.myapplication.R;

/**
 * Created by sam on 14-10-30.
 */
public class UIUtils {
    public static void setSystemBarTintColor(Activity activity){
        if(SystemBarTintManager.isKitKat()){
            SystemBarTintManager tintManager = new SystemBarTintManager(activity);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintDrawable(new ColorDrawable(activity.getResources().getColor(R.color.holo_blue_dark)));
        }
    }
}
