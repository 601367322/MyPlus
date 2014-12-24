package com.example.sbb.myapplication.fragment;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.example.sbb.myapplication.R;
import com.example.sbb.myapplication.activity.MainActivity;
import com.example.sbb.myapplication.adapter.HomeAdapter;
import com.example.sbb.myapplication.base.BaseFragment;
import com.example.sbb.myapplication.custom.MyRecyclerView;
import com.example.sbb.myapplication.custom.MySwipeRefreshLayout;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_main)
public class PlaceholderFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    @ViewById(R.id.refresh_layout)
    public MySwipeRefreshLayout swipeRefreshLayout;

    @ViewById(R.id.listview)
    public MyRecyclerView recyclerView;

    @FragmentArg
    public int selectNum;

    @Override
    public void init() {
        swipeRefreshLayout.setOnRefreshListener(this);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add(String.valueOf(i));
        }
        recyclerView.setAdapter(new HomeAdapter(list, getActivity()));
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
            }

            @Override
            public void onScrolled(RecyclerView r, int i, int i2) {
                System.out.println("First: " + recyclerView.getFirstVisiblePosition());
                System.out.println("Count: " + recyclerView.getChildCount());
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(selectNum);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 5000);
    }
}