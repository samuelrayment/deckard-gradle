package com.example.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * RecyclerAdapter displays X cells where X is the numberOfItems.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public interface RecyclerAdapterOnClickListener {
        public void onClick(int index);
    }

    private Context mContext;
    private int mNumberOfItems = 0;
    private RecyclerAdapterOnClickListener mListener;

    public RecyclerAdapter(Context applicationContext, RecyclerAdapterOnClickListener listener) {
        mContext = applicationContext;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext)
                .inflate(R.layout.view_cell, viewGroup, false);
        return new ViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.bindIndex(i);
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
        TextView mTextView;
        private RecyclerAdapterOnClickListener mListener;
        private int mIndex;

        public ViewHolder(View itemView, RecyclerAdapterOnClickListener listener) {
            super(itemView);
            mListener = listener;
            ButterKnife.inject(this, itemView);
        }

        public void bindIndex(int index) {
            mIndex = index;
            mTextView.setText("" + index);
        }

        @OnClick(R.id.cell_view)
        public void onClick(View view) {
            Log.e("TEST", "View Clicked");
            mListener.onClick(mIndex);
        }
    }
}
