package com.cimcitech.yygonboard.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.activity.user.MyCarDetailActivity;
import com.cimcitech.yygonboard.activity.user.MyCarListActivity;
import com.cimcitech.yygonboard.adapter.home.SelfCheckAdapter;
import com.cimcitech.yygonboard.adapter.user.MyCarListAdapter;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.model.home.SelfCheckVo;
import com.cimcitech.yygonboard.model.user.MyCarListVo;
import com.cimcitech.yygonboard.utils.ToastUtil;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

//车宝自检
public class SelfCheckActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.top_mid_view)
    RelativeLayout topMidView;
    @Bind(R.id.check_btn)
    Button checkBtn;
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;

    private SelfCheckAdapter adapter;
    private List<SelfCheckVo> data = new ArrayList<>();
    private int pageNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_check);
        ButterKnife.bind(this);
        getXmlView();
    }

    public void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, true);
        titleBarView.setTitle("车宝自检");
        titleBarView.setRightTitle("故障说明");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
        titleBarView.setOnRightButtonClickListener(new MyAppTitleBar.OnRightButtonClickListener() {
            @Override
            public void OnRightButtonClick(View v) {
                ToastUtil.showNetError();
            }
        });

        adapter = new SelfCheckAdapter(SelfCheckActivity.this, data);
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
                getSelfCheckData();
            }
        });
        getSelfCheckData();
    }

    public void getSelfCheckData() {
        for (int i = 0; i < 10; i++) {
            SelfCheckVo selfCheckVo = new SelfCheckVo();
            selfCheckVo.setName("货到付款" + i);
            data.add(selfCheckVo);
        }
        adapter.addData(data);
        recyclerView.loadMoreComplete();
        //recyclerView.noMoreLoading();
    }
}
