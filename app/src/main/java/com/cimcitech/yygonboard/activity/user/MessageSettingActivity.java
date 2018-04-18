package com.cimcitech.yygonboard.activity.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageSettingActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_setting);
        ButterKnife.bind(this);
        getXmlView();
    }

    public void getXmlView(){
        titleBarView.initViewsVisible(true,true,false,false);
        titleBarView.setTitle("消息设置");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
    }
}
