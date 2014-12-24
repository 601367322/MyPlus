package com.example.sbb.myapplication.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2014/12/22.
 */
public abstract class BaseAdapter<E, T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {

    public List<E> list;
    public Context context;

    public E getItem(int position) {
        if (list != null && list.size() > 0 && position < list.size()) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public abstract T onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract void onBindViewHolder(T holder, int position);

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setList(List<E> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<E> getList() {
        return list;
    }

    public BaseAdapter (List<E> list, Context context){
        this.list=list;
        this.context=context;
    }
}
