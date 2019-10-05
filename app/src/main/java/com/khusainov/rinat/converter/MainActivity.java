package com.khusainov.rinat.converter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ConverterAdapter.OnItemClickListener {

    private RecyclerView mRecyclerView;
    private List<String> items;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.items)));
        mRecyclerView = findViewById(R.id.recycler);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(new ConverterAdapter(items, this));
    }

    @Override
    public void onClick() {
        final Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
