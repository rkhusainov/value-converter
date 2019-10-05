package com.khusainov.rinat.converter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ConverterAdapter extends RecyclerView.Adapter<ConverterAdapter.ConverterHolder> {

    private List<Unit.ValueTypes> mValueTypes;
    private IMainOnItemClickListener mOnItemClickListener;

    public ConverterAdapter(List<Unit.ValueTypes> items, IMainOnItemClickListener onItemClickListener) {
        this.mValueTypes = items;
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ConverterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.li_item, parent, false);
        return new ConverterHolder(view, mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ConverterHolder holder, int position) {
        Unit.ValueTypes item = mValueTypes.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mValueTypes.size();
    }

    class ConverterHolder extends RecyclerView.ViewHolder {
        private TextView mValueName;

        public ConverterHolder(@NonNull View itemView, final IMainOnItemClickListener listener) {
            super(itemView);
            mValueName = itemView.findViewById(R.id.text_view_value_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick();
                }
            });
        }

        void bind(Unit.ValueTypes item) {
            mValueName.setText(item.toString());
        }
    }
}
