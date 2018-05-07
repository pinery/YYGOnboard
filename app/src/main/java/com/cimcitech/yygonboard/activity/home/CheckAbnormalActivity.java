package com.cimcitech.yygonboard.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.home.CheckAbnormalAdapter;
import com.cimcitech.yygonboard.adapter.home.SelfCheckAdapter;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.model.home.SelfCheckVo;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

//自检异常
public class CheckAbnormalActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;

    private CheckAbnormalAdapter adapter;
    private List<String> data = new ArrayList<>();
    private int pageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_abnormal);
        ButterKnife.bind(this);
        getXmlView();
    }

    public void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("123");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });

        adapter = new CheckAbnormalAdapter(CheckAbnormalActivity.this, data);
        adapter.setOnRecyclerViewItemClickListener(new BaseRvAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(CheckAbnormalActivity.this, CheckAbnormalActivity.class));
            }
        });
        recyclerView.setVLinerLayoutManager();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingListener(new MyRecyclerView.LoadingListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getCheckAbnormalData();
            }
        });
        getCheckAbnormalData();
    }

    public void getCheckAbnormalData() {
        for (int i = 0; i < 15; i++)
            data.add("123");
        adapter.addData(data);
        recyclerView.loadMoreComplete();
        //recyclerView.noMoreLoading();
    }
}
