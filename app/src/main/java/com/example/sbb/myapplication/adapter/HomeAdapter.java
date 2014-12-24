package com.example.sbb.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sbb.myapplication.R;
import com.example.sbb.myapplication.base.BaseAdapter;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by sbb on 2014/12/24.
 */
public class HomeAdapter extends BaseAdapter<String, HomeAdapter.ViewHolder> {

    public HomeAdapter(List list, Context context) {
        super(list, context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textview.setText(getItem(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.textview)
        TextView textview;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
