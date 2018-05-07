package com.cimcitech.yygonboard.activity.home;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.home.DrivingLogAdapter;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DrivingLogActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.rb_my_repair)
    RadioButton rbMyRepair;
    @Bind(R.id.rb_to_repair)
    RadioButton rbToRepair;
    @Bind(R.id.radio_group_top)
    RadioGroup radioGroupTop;
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;

    private List<String> data = new ArrayList<>();
    private int pageNum = 1;
    private DrivingLogAdapter adapter;
    private PopupWindow pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_log);
        ButterKnife.bind(this);
        getXmlView();
    }

    @OnClick({R.id.add_driving_log})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_driving_log:
                pop.showAtLocation(view, Gravity.CENTER, 0, 0);
                break;
        }
    }

    public void getXmlView() {
        showAddDrivingLogPopWin();
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("行车日志");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
        radioGroupTop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_my_repair:

                        break;
                    case R.id.rb_to_repair:

                        break;
                }
            }
        });
        rbMyRepair.setChecked(true);

        adapter = new DrivingLogAdapter(DrivingLogActivity.this, data);
        adapter.setOnRecyclerViewItemClickListener(new BaseRvAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        recyclerView.setVLinerLayoutManager();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingListener(new MyRecyclerView.LoadingListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getDrivingLogData();
            }
        });
        getDrivingLogData();
    }

    public void getDrivingLogData() {
        for (int i = 0; i < 5; i++)
            data.add("111");
        adapter.addData(data);
        recyclerView.loadMoreComplete();
        //recyclerView.noMoreLoading();
    }

    private void showAddDrivingLogPopWin() {
        LayoutInflater inflater = LayoutInflater.from(DrivingLogActivity.this);
        // 引入窗口配置文件
        View view = inflater.inflate(R.layout.driving_log_pop_view, null);
        view.getBackground().setAlpha(100);
        // 创建PopupWindow对象
        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, false);
        // 需要设置一下此参数，点击外边可消失
        pop.setBackgroundDrawable(new BitmapDrawable());
        // 设置点击窗口外边窗口消失
        pop.setOutsideTouchable(false);
        // 设置此参数获得焦点，否则无法点击
        pop.setFocusable(true);
        //getxmlview
        view.findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
        view.findViewById(R.id.ok_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
    }
}
