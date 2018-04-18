package com.cimcitech.yygonboard.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cimcitech.yygonboard.MainActivity;
import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.user_name_tv)
    EditText userNameTv;
    @Bind(R.id.user_password_tv)
    EditText userPasswordTv;
    @Bind(R.id.login_submit_bt)
    Button loginSubmitBt;
    @Bind(R.id.update_password_tv)
    TextView updatePasswordTv;
    @Bind(R.id.register_bt)
    Button registerBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.register_bt, R.id.update_password_tv, R.id.login_submit_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_bt:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.update_password_tv:
                startActivity(new Intent(LoginActivity.this, ForgetPwdActivity.class));
                break;
            case R.id.login_submit_bt:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
