package com.cimcitech.yygonboard.activity.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.widget.MyAppTitleBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPwdActivity extends AppCompatActivity {

    @Bind(R.id.title_bar_view)
    MyAppTitleBar titleBarView;
    @Bind(R.id.rb_my_family)
    RadioButton rbMyFamily;
    @Bind(R.id.rb_my_neighbour)
    RadioButton rbMyNeighbour;
    @Bind(R.id.radio_group_top)
    RadioGroup radioGroupTop;
    @Bind(R.id.next_1_bt)
    Button next1Bt;
    @Bind(R.id.user_number_tv)
    TextView userNumberTv;
    @Bind(R.id.code_et)
    EditText codeEt;
    @Bind(R.id.get_code_bt)
    Button getCodeBt;
    @Bind(R.id.next_2_bt)
    Button next2Bt;
    @Bind(R.id.password_et)
    EditText passwordEt;
    @Bind(R.id.confirm_password_et)
    EditText confirmPasswordEt;
    @Bind(R.id.next_3_bt)
    Button next3Bt;
    @Bind(R.id.go_login_bt)
    Button goLoginBt;

    private View passwordView1, passwordView2, passwordView3, passwordView4;
    private List<View> passwordViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        ButterKnife.bind(this);
        getXmlView();
    }

    public void getXmlView() {
        titleBarView.initViewsVisible(true, true, false, false);
        titleBarView.setTitle("找回密码");
        titleBarView.setOnLeftButtonClickListener(new MyAppTitleBar.OnLeftButtonClickListener() {
            @Override
            public void onLeftButtonClick(View v) {
                if (isShowView() != null)
                    if (isShowView() == passwordView1) {
                        finish();
                    } else if (isShowView() == passwordView2) {
                        showPasswordView(passwordView1);
                    } else if (isShowView() == passwordView3) {
                        showPasswordView(passwordView2);
                    } else if (isShowView() == passwordView4) {
                        finish();//既然成功了返回也直接关闭
                    }
            }
        });
        passwordView1 = this.findViewById(R.id.password_view_1);
        passwordView2 = this.findViewById(R.id.password_view_2);
        passwordView3 = this.findViewById(R.id.password_view_3);
        passwordView4 = this.findViewById(R.id.password_view_4);
        passwordViews.add(passwordView1);
        passwordViews.add(passwordView2);
        passwordViews.add(passwordView3);
        passwordViews.add(passwordView4);
    }

    @OnClick({R.id.next_1_bt, R.id.next_2_bt, R.id.next_3_bt, R.id.go_login_bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_1_bt:
                showPasswordView(passwordView2);
                break;
            case R.id.next_2_bt:
                showPasswordView(passwordView3);
                break;
            case R.id.next_3_bt:
                showPasswordView(passwordView4);
                break;
            case R.id.go_login_bt:
                finish();
                break;
        }
    }

    public void showPasswordView(View view) {
        passwordView1.setVisibility(View.GONE);
        passwordView2.setVisibility(View.GONE);
        passwordView3.setVisibility(View.GONE);
        passwordView4.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
    }

    //获取当前显示的view
    public View isShowView() {
        for (int i = 0; i < passwordViews.size(); i++) {
            if (passwordViews.get(i).getVisibility() == View.VISIBLE)
                return passwordViews.get(i);
        }
        return null;
    }
}
