package com.khusainov.rinat.converter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ConverterHolder extends RecyclerView.ViewHolder {

    private TextView mItems;

    public ConverterHolder(@NonNull View itemView) {
        super(itemView);

        mItems = itemView.findViewById(R.id.tv_item);
    }


    public void bind(String item, final ConverterAdapter.OnItemClickListener clickListener) {
        mItems.setText(item);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onClick();
            }
        });
    }
}
