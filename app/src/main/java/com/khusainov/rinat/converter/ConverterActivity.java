package com.khusainov.rinat.converter;

import androidx.fragment.app.Fragment;

import com.khusainov.rinat.converter.common.SingleFragmentActivity;

public class ConverterActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return ListFragment.newInstance();
    }
}
