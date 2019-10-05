package com.khusainov.rinat.converter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    public static final String TAG = DetailActivity.class.getSimpleName();
    public static final String KEY = "KEY";

    private EditText mEditTextFrom;
    private EditText mEditTextTo;
    private Spinner mFromSpinner;
    private Spinner mToSpinner;

    public static Intent newIntent(Context context, String value) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(KEY, value);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mEditTextFrom = findViewById(R.id.edit_text_from);
        mEditTextTo = findViewById(R.id.edit_text_to);
        mFromSpinner = findViewById(R.id.spinner_from);
        mToSpinner = findViewById(R.id.spinner_to);

        String text = getIntent().getStringExtra(KEY);
        mEditTextTo.setText(text);
    }
}
