package com.cimcitech.yygonboard.activity.condition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cimcitech.yygonboard.R;

import butterknife.ButterKnife;

public class ConditionActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_condition, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
