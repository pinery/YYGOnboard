package com.cimcitech.yygonboard.activity.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.UiSettings;
import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.home.StatisticsGridViewAdapter;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DataStatisticsActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.map)
    MapView mMapView;
    @Bind(R.id.data_grid)
    MyGridView dataGrid;

    private AMap aMap;
    private StatisticsGridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_statistics);
        ButterKnife.bind(this);
        getXmlView();
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);
    }

    private void getXmlView() {
        setMapProperty();
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("数据统计");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
        gridViewAdapter = new StatisticsGridViewAdapter(DataStatisticsActivity.this);
        dataGrid.setAdapter(gridViewAdapter);
    }

    //设置地图一些属性
    public void setMapProperty() {
        if (aMap == null) {
            aMap = mMapView.getMap();
            UiSettings uiSettings = aMap.getUiSettings();
            uiSettings.setLogoBottomMargin(-50);//隐藏logo
            uiSettings.setZoomControlsEnabled(false);//隐藏缩放
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }
}
