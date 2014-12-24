package com.example.sbb.myapplication.base;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

@EFragment
public abstract class BaseFragment extends Fragment{

    @AfterViews
    public abstract void init();
}
