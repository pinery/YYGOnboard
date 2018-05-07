package com.cimcitech.yygonboard.activity.home;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.activity.user.MyCarDetailActivity;
import com.cimcitech.yygonboard.activity.user.MyCarListActivity;
import com.cimcitech.yygonboard.adapter.home.FaultDescriptionAdapter;
import com.cimcitech.yygonboard.adapter.home.HomeCarListAdapter;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.utils.ToastUtil;
import com.cimcitech.yygonboard.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

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

    //private HomeGridViewAdapter gridViewAdapter;
    private PopupWindow pop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home, container, false);
        ButterKnife.bind(this, view);
        getXmlView();
        return view;
    }

    public void getXmlView() {
        //gridViewAdapter = new HomeGridViewAdapter(getActivity());
        showCarListPopWin();
    }

    @OnClick({R.id.check_mileage_maintain_btn, R.id.check_time_maintain_btn, R.id.home_grid_4, R.id.car_list_view,
            R.id.home_driving_log, R.id.home_data_request, R.id.home_data_statistics,R.id.home_monthly_report})
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
            case R.id.home_grid_4:
                startActivity(new Intent(getActivity(), SelfCheckActivity.class));
                break;
            case R.id.car_list_view:
                pop.showAtLocation(view, Gravity.CENTER, 0, 0);
                break;
            case R.id.home_driving_log:
                startActivity(new Intent(getActivity(), DrivingLogActivity.class));
                break;
            case R.id.home_data_request:
                startActivity(new Intent(getActivity(), DataQueryActivity.class));
                break;
            case R.id.home_data_statistics:
                startActivity(new Intent(getActivity(), DataStatisticsActivity.class));
                break;
            case R.id.home_monthly_report:
                startActivity(new Intent(getActivity(), MonthlyReportActivity.class));
                break;
        }
    }

    private void showCarListPopWin() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        // 引入窗口配置文件
        View view = inflater.inflate(R.layout.home_car_list_pop_view, null);
        view.getBackground().setAlpha(100);
        // 创建PopupWindow对象
        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, false);
        // 需要设置一下此参数，点击外边可消失
        pop.setBackgroundDrawable(new BitmapDrawable());
        // 设置点击窗口外边窗口消失
        pop.setOutsideTouchable(false);
        // 设置此参数获得焦点，否则无法点击
        pop.setFocusable(true);
        //添加数据
        MyRecyclerView popRecyclerView = view.findViewById(R.id.recyclerView);
        List<String> strings = new ArrayList<>();
        HomeCarListAdapter adapter = new HomeCarListAdapter(view.getContext(), strings);
        popRecyclerView.setVLinerLayoutManager();
        popRecyclerView.setAdapter(adapter);
        popRecyclerView.setHasFixedSize(true);
        view.findViewById(R.id.pop_reward_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
        adapter.setOnRecyclerViewItemClickListener(new BaseRvAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastUtil.showToast(position + "");
            }
        });
        getCarListData(strings, adapter, popRecyclerView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void getCarListData(List<String> strings, HomeCarListAdapter adapter, MyRecyclerView recyclerView) {
        for (int i = 0; i < 5; i++)
            strings.add("粤B12345" + i);
        adapter.addData(strings);
        recyclerView.loadMoreComplete();
        //recyclerView.noMoreLoading();
    }
}
