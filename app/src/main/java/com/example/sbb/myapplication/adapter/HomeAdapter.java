package com.example.sbb.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sbb.myapplication.R;
import com.example.sbb.myapplication.base.BaseAdapter;

import org.lucasr.twowayview.widget.StaggeredGridLayoutManager;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by sbb on 2014/12/24.
 */
public class HomeAdapter extends BaseAdapter<String> {

    public HomeAdapter(List list, Context context) {
        super(list, context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.textview)
        TextView textview;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public boolean useHeader() {
        return false;
    }

    @Override
    public ViewHolder onCreateHeaderViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindHeaderView(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public boolean useFooter() {
        return true;
    }

    @Override
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
        FootViewHolder holder = new FootViewHolder(LayoutInflater.from(context).inflate(R.layout.footer_view, parent, false));
        return holder;
    }

    @Override
    public void onBindFooterView(RecyclerView.ViewHolder holder, int position) {
        final StaggeredGridLayoutManager.LayoutParams lp =
                (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
        final int size = context.getResources().getDisplayMetrics().widthPixels;
        lp.span = 2;
        lp.width = size;
        holder.itemView.setLayoutParams(lp);
    }

    @Override
    public void onBindBasicItemView(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).textview.setText(getItem(position));
        ((ViewHolder)holder).textview.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.MATCH_PARENT, (position + 1) * 50));
    }

    @Override
    public RecyclerView.ViewHolder onCreateBasicItemViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }


    @Override
    public int getBasicItemType(int position) {
        return 0;
    }
}
