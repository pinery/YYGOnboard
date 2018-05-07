package com.cimcitech.yygonboard.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DataQueryActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_query);
        ButterKnife.bind(this);
        getXmlView();
    }

    private void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("数据查询");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.query_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.query_btn:
                startActivity(new Intent(DataQueryActivity.this, DataQueryDetailActivity.class));
                break;
        }
    }
}
