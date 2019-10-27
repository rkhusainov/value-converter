package com.khusainov.rinat.converter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragment extends Fragment {

    private RecyclerView mConverterRecyclerView;
    private ConverterAdapter mConverterAdapter = new ConverterAdapter(new IConverterOnItemClickListener() {
        @Override
        public void onClick(Unit.ValueTypes valueTypes) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, DetailFragment.newInstance(valueTypes))
                    .addToBackStack(null)
                    .commit();
        }
    });

    public static ListFragment newInstance() {
        return new ListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_converter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mConverterRecyclerView = view.findViewById(R.id.recycler);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mConverterRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        mConverterRecyclerView.addItemDecoration(dividerItemDecoration);
        mConverterRecyclerView.setAdapter(mConverterAdapter);
    }
}
