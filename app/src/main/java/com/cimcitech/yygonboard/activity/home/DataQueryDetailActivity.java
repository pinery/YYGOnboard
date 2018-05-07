package com.cimcitech.yygonboard.activity.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.adapter.home.QueryGridViewAdapter;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;
import com.cimcitech.yygonboard.widget.MyGridView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DataQueryDetailActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.data_grid)
    MyGridView dataGrid;

    private QueryGridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_query_detail);
        ButterKnife.bind(this);
        getXmlView();
    }

    private void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("粤B666666");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
        gridViewAdapter = new QueryGridViewAdapter(DataQueryDetailActivity.this);
        dataGrid.setAdapter(gridViewAdapter);
    }
}
