package com.khusainov.rinat.converter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailFragment extends Fragment {

    public static final String KEY = "KEY";
    public static final String DEFAULT_VALUE = "1";

    private TextView mTextViewFrom;
    private TextView mTextViewTo;
    private EditText mEditTextFrom;
    private EditText mEditTextTo;
    private Spinner mSpinnerFrom;
    private Spinner mSpinnerTo;

    private Unit.ValueTypes mValueType;
    private ArrayAdapter<?> mSpinnerAdapterFrom;

    private List<Unit.Length> mLengths;
    private List<Unit.Mass> mMasses;
    private List<String> mRuLengths = new ArrayList<>();
    private List<String> mRuMasses = new ArrayList<>();

    private int mSpinnerFromPosition = 0;
    private int mSpinnerToPosition = 0;


    public static DetailFragment newInstance(Unit.ValueTypes valueTypes) {
        Bundle args = new Bundle();
        args.putSerializable(KEY, valueTypes);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextViewFrom = view.findViewById(R.id.text_view_from);
        mTextViewTo = view.findViewById(R.id.text_view_to);

        if (getArguments() != null) {
            mValueType = (Unit.ValueTypes) getArguments().getSerializable(KEY);
        }

        if (mValueType != null) {
            getActivity().setTitle(mValueType.mNameRes);
        }

        initRuUnits();
        initEditText(view);
        initSpinner(view);
    }

    private void initRuUnits() {
        mLengths = Arrays.asList(Unit.Length.values());
        for (Unit.Length length : mLengths) {
            mRuLengths.add(getResources().getString(length.mNameRes));
        }

        mMasses = Arrays.asList(Unit.Mass.values());
        for (Unit.Mass masses : mMasses) {
            mRuMasses.add(getResources().getString(masses.mNameRes));
        }
    }

    private void initEditText(View view) {
        mEditTextFrom = view.findViewById(R.id.edit_text_from);
        mEditTextTo = view.findViewById(R.id.edit_text_to);
        mEditTextFrom.setText(DEFAULT_VALUE);

        mEditTextFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    String result = calculation(charSequence.toString(), mSpinnerFromPosition, mSpinnerToPosition);
                    mEditTextTo.setText(result);
                } else mEditTextTo.setText("");
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void initSpinner(View view) {
        mSpinnerFrom = view.findViewById(R.id.spinner_from);
        mSpinnerTo = view.findViewById(R.id.spinner_to);

        switch (mValueType) {
            case LENGTH:
                mSpinnerAdapterFrom = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mRuLengths);
                break;
            case MASS:
                mSpinnerAdapterFrom = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mRuMasses);
                break;
            default:
                break;
        }

        mSpinnerAdapterFrom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mSpinnerFrom.setAdapter(mSpinnerAdapterFrom);
        mSpinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                mSpinnerFromPosition = position;
                String result;
                if (mEditTextFrom.getText().length() > 0) {
                    result = calculation(mEditTextFrom.getText().toString(), mSpinnerFromPosition, mSpinnerToPosition);
                    mEditTextTo.setText(result);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        mSpinnerTo.setAdapter(mSpinnerAdapterFrom);
        mSpinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                mSpinnerToPosition = position;
                String result;
                if (mEditTextFrom.getText().length() > 0) {
                    result = calculation(mEditTextFrom.getText().toString(), mSpinnerFromPosition, mSpinnerToPosition);
                    mEditTextTo.setText(result);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public String calculation(String value, int positionFrom, int positionTo) {
        double result = 0;
        switch (mValueType) {
            case LENGTH:
                result = Double.parseDouble(value) / Unit.Length.values()[positionFrom].value * Unit.Length.values()[positionTo].value;
                mTextViewFrom.setText(mRuLengths.get(positionFrom));
                mTextViewTo.setText(mRuLengths.get(positionTo));
                break;
            case MASS:
                result = Double.parseDouble(value) / Unit.Mass.values()[positionFrom].value * Unit.Mass.values()[positionTo].value;
                mTextViewFrom.setText(mRuMasses.get(positionFrom));
                mTextViewTo.setText(mRuMasses.get(positionTo));
                break;
            default:
                break;
        }
        return String.valueOf(result);
    }
}
