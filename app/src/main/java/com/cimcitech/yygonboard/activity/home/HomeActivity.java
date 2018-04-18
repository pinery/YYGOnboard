package com.cimcitech.yygonboard.activity.home;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.HomeGridViewAdapter;
import com.cimcitech.yygonboard.widget.MyGridView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends Fragment {

    @Bind(R.id.homeCarIcon)
    ImageView homeCarIcon;
    @Bind(R.id.check_mileage_maintain_btn)
    Button checkMileageMaintainBtn;
    @Bind(R.id.check_time_maintain_btn)
    Button checkTimeMaintainBtn;
    @Bind(R.id.mileage_maintain_btn)
    Button mileageMaintainBtn;
    @Bind(R.id.mileage_tv)
    TextView mileageTv;
    @Bind(R.id.mileage_bar_view)
    RelativeLayout mileageBarView;
    @Bind(R.id.mileage_maintain_view)
    LinearLayout mileageMaintainView;
    @Bind(R.id.mileage_maintain_layout)
    RelativeLayout mileageMaintainLayout;
    @Bind(R.id.time_maintain_btn)
    Button timeMaintainBtn;
    @Bind(R.id.time_tv)
    TextView timeTv;
    @Bind(R.id.time_bar_view)
    RelativeLayout timeBarView;
    @Bind(R.id.time_maintain_view)
    LinearLayout timeMaintainView;
    @Bind(R.id.time_maintain_layout)
    RelativeLayout timeMaintainLayout;
    @Bind(R.id.maintain_layout)
    LinearLayout maintainLayout;
    @Bind(R.id.house_grid)
    MyGridView houseGrid;

    private HomeGridViewAdapter gridViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        ButterKnife.bind(this, view);
        getXmlView();
        return view;
    }

    public void getXmlView() {
        gridViewAdapter = new HomeGridViewAdapter(getActivity());
        houseGrid.setAdapter(gridViewAdapter);
        houseGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 3) {//车宝自检
                    startActivity(new Intent(getActivity(), SelfCheckActivity.class));
                }
            }
        });
    }

    @OnClick({R.id.check_mileage_maintain_btn, R.id.check_time_maintain_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_mileage_maintain_btn:
                mileageMaintainLayout.setVisibility(View.VISIBLE);
                timeMaintainLayout.setVisibility(View.GONE);
                maintainLayout.setBackgroundResource(R.mipmap.home_radio_left_bg);
                break;
            case R.id.check_time_maintain_btn:
                mileageMaintainLayout.setVisibility(View.GONE);
                timeMaintainLayout.setVisibility(View.VISIBLE);
                maintainLayout.setBackgroundResource(R.mipmap.home_radio_right_bg);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
