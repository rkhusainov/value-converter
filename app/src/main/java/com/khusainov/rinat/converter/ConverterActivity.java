package com.khusainov.rinat.converter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ConverterActivity extends AppCompatActivity implements IMainOnItemClickListener {

    private RecyclerView mConverterRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mConverterRecyclerView = findViewById(R.id.recycler);
        mConverterRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mConverterRecyclerView.addItemDecoration(dividerItemDecoration);
        mConverterRecyclerView.setAdapter(new ConverterAdapter(this));
    }

    @Override
    public void onClick(Unit.ValueTypes currentType) {
        Intent intent = DetailActivity.newIntent(this, currentType);
        startActivity(intent);
    }
}
