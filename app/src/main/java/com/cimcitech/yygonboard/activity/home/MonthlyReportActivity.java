package com.cimcitech.yygonboard.activity.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amap.api.maps.MapView;
import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.home.MonthlyGridViewAdapter;
import com.cimcitech.yygonboard.adapter.home.QueryGridViewAdapter;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MonthlyReportActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.data_grid)
    MyGridView dataGrid;

    private MonthlyGridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_report);
        ButterKnife.bind(this);
        getXmlView();
    }

    private void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("月度报表");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
        gridViewAdapter = new MonthlyGridViewAdapter(MonthlyReportActivity.this);
        dataGrid.setAdapter(gridViewAdapter);
    }
}
