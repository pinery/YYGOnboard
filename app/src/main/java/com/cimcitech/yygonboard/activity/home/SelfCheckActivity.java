package com.cimcitech.yygonboard.activity.home;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.home.FaultDescriptionAdapter;
import com.cimcitech.yygonboard.adapter.home.SelfCheckAdapter;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.model.home.SelfCheckVo;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//车宝自检
public class SelfCheckActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.recyclerView)
    MyRecyclerView recyclerView;

    private SelfCheckAdapter adapter;
    private List<SelfCheckVo> data = new ArrayList<>();
    private int pageNum = 1;
    private Animation operatingAnim;
    private ImageView checkImageIv;
    private PopupWindow pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_check);
        ButterKnife.bind(this);
        getXmlView();
    }

    public void getXmlView() {
        showFaultDescriptionPopWin();
        operatingAnim = AnimationUtils.loadAnimation(SelfCheckActivity.this, R.anim.image_tip);
        LinearInterpolator lin = new LinearInterpolator();
        operatingAnim.setInterpolator(lin);

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
                pop.showAtLocation(v, Gravity.CENTER, 0, 0);
            }
        });

        //头部View
        View headView = LayoutInflater.from(SelfCheckActivity.this).inflate(R.layout.self_check_recycler_top_view, null);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        headView.setLayoutParams(lp);
        recyclerView.addHeaderView(headView);

        checkImageIv = headView.findViewById(R.id.check_image_iv);
        headView.findViewById(R.id.check_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operatingAnim != null)
                    checkImageIv.startAnimation(operatingAnim);
                //checkImageIv.clearAnimation();
            }
        });

        adapter = new SelfCheckAdapter(SelfCheckActivity.this, data);
        adapter.setOnRecyclerViewItemClickListener(new BaseRvAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(new Intent(SelfCheckActivity.this, CheckAbnormalActivity.class));
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
        for (int i = 0; i < 15; i++) {
            SelfCheckVo selfCheckVo = new SelfCheckVo();
            selfCheckVo.setName("货到付款" + i);
            data.add(selfCheckVo);
        }
        adapter.addData(data);
        recyclerView.loadMoreComplete();
        //recyclerView.noMoreLoading();
    }

    private void showFaultDescriptionPopWin() {
        LayoutInflater inflater = LayoutInflater.from(SelfCheckActivity.this);
        // 引入窗口配置文件
        View view = inflater.inflate(R.layout.fault_description_view, null);
        view.getBackground().setAlpha(100);
        // 创建PopupWindow对象
        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, false);
        // 需要设置一下此参数，点击外边可消失
        pop.setBackgroundDrawable(new BitmapDrawable());
        // 设置点击窗口外边窗口消失
        pop.setOutsideTouchable(false);
        // 设置此参数获得焦点，否则无法点击
        pop.setFocusable(true);
        //数据填充
        MyRecyclerView popRecyclerView = view.findViewById(R.id.recyclerView);
        List<String> strings = new ArrayList<>();
        FaultDescriptionAdapter adapter = new FaultDescriptionAdapter(view.getContext(), strings);
        popRecyclerView.setVLinerLayoutManager();
        popRecyclerView.setAdapter(adapter);
        popRecyclerView.setHasFixedSize(true);
        getFaultDescriptionData(strings, adapter, popRecyclerView);
        view.findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pop.dismiss();
            }
        });
    }

    public void getFaultDescriptionData(List<String> strings, FaultDescriptionAdapter adapter, MyRecyclerView popRecyclerView) {
        for (int i = 0; i < 6; i++)
            strings.add("123456");
        adapter.addData(strings);
        popRecyclerView.loadMoreComplete();
    }
}
