package com.example.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by sam.rayment on 19/01/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Context mContext;
    private int mNumberOfItems;

    public RecyclerAdapter(Context applicationContext, int numberOfItems) {
        mContext = applicationContext;
        mNumberOfItems = numberOfItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.view_cell, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.textView.setText("" + i);
    }

    @Override
    public int getItemCount() {
        return mNumberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        mNumberOfItems = numberOfItems;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.text_view)
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
