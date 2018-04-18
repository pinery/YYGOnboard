package com.cimcitech.yygonboard.activity.user;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cimcitech.yygonboard.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_user, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.user_car_layout, R.id.user_info_layout,R.id.user_message_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_car_layout:
                startActivity(new Intent(getActivity(), MyCarListActivity.class));
                break;
            case R.id.user_info_layout:
                startActivity(new Intent(getActivity(), UserInfoActivity.class));
                break;
            case R.id.user_message_layout:
                startActivity(new Intent(getActivity(), MessageSettingActivity.class));
                break;
        }
    }
}
