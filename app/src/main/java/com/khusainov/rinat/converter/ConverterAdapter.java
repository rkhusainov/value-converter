package com.khusainov.rinat.converter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConverterAdapter extends RecyclerView.Adapter<ConverterHolder> {

    private List<String> mItems;
    private OnItemClickListener mOnItemClickListener;

    public ConverterAdapter(List<String> items, OnItemClickListener listener) {
        this.mItems = items;
        mOnItemClickListener = listener;
    }

    @NonNull
    @Override
    public ConverterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_item, parent, false);
        return new ConverterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConverterHolder holder, int position) {
        String item = mItems.get(position);
        holder.bind(item,mOnItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    interface OnItemClickListener {
        void onClick();
    }
}
