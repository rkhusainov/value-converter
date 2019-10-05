package com.khusainov.rinat.converter;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private Spinner toSpinner;
    private Spinner fromSpinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_detail);
    }
}
