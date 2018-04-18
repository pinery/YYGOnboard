package com.cimcitech.yygonboard.activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.user_name_tv)
    EditText userNameTv;
    @Bind(R.id.code_et)
    EditText codeEt;
    @Bind(R.id.get_code_bt)
    Button getCodeBt;
    @Bind(R.id.user_password_tv)
    EditText userPasswordTv;
    @Bind(R.id.confirm_password_et)
    EditText confirmPasswordEt;
    @Bind(R.id.register_submit_bt)
    Button registerSubmitBt;
    @Bind(R.id.finish_bt)
    Button finishBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        getXmlView();
    }

    public void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("注册");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                finish();
            }
        });
    }
}
