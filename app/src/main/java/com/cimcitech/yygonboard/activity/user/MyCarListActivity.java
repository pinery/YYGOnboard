package com.cimcitech.yygonboard.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.user.MyCarListAdapter;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.model.user.MyCarListVo;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyCarListActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;

    private List<MyCarListVo> data = new ArrayList<>();
    private MyCarListAdapter adapter;
    private int pageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_car_list);
        ButterKnife.bind(this);
        getXmlView();
    }

    public void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("车辆列表");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });

        adapter = new MyCarListAdapter(MyCarListActivity.this, data);
        adapter.setOnRecyclerViewItemClickListener(new BaseRvAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(MyCarListActivity.this, MyCarDetailActivity.class));
            }
        });
        recyclerView.setVLinerLayoutManager();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLoadingListener(new MyRecyclerView.LoadingListener() {
            @Override
            public void onLoadMore() {
                pageNum++;
                getCarListData();
            }
        });
        getCarListData();
    }

    public void getCarListData() {
        for (int i = 0; i < 10; i++) {
            MyCarListVo myCarListVo = new MyCarListVo();
            myCarListVo.setName("奥迪" + i);
            data.add(myCarListVo);
        }
        adapter.addData(data);
        recyclerView.loadMoreComplete();
        //recyclerView.noMoreLoading();
    }
}
