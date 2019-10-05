package com.khusainov.rinat.converter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class ConverterActivity extends AppCompatActivity implements IMainOnItemClickListener {
    public static final String TAG = ConverterActivity.class.getSimpleName();

    private RecyclerView mRecyclerView;
    private List<Unit.ValueTypes> mValueTypes = Arrays.asList(Unit.ValueTypes.values());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(new ConverterAdapter(mValueTypes, this));
    }

    @Override
    public void onClick() {
        Intent intent = DetailActivity.newIntent(this);
        startActivity(intent);
    }
}
