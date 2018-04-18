package com.cimcitech.yygonboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cimcitech.yygonboard.activity.condition.ConditionActivity;
import com.cimcitech.yygonboard.activity.home.HomeActivity;
import com.cimcitech.yygonboard.activity.location.LocationActivity;
import com.cimcitech.yygonboard.activity.user.UserActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {


    @Bind(R.id.bottom_nav_content)
    LinearLayout bottomNavContent;
    @Bind(R.id.bottom_navigation_bar_container)
    BottomNavigationBar bottomNavigationBarContainer;

    private BottomNavigationItem annexItem;
    private BottomNavigationItem homeItem;
    private BottomNavigationItem orderItem;
    private BottomNavigationItem userItem;
    private BadgeItem badgeItem; //角标
    private HomeActivity homeActivity;
    private LocationActivity locationActivity;
    private ConditionActivity conditionActivity;
    private UserActivity userActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBottomNavBar();
    }

    /*初始化底部导航栏*/
    private void initBottomNavBar() {
        bottomNavigationBarContainer.setAutoHideEnabled(false);//自动隐藏
        bottomNavigationBarContainer.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBarContainer.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBarContainer.setBarBackgroundColor(R.color.white);//背景颜色
        bottomNavigationBarContainer.setInActiveColor(R.color.black);//未选中时的颜色
        bottomNavigationBarContainer.setActiveColor(R.color.bottom_text_color);//选中时的颜色

        homeItem = new BottomNavigationItem(R.mipmap.main_bottom_home_icon, "首页");
        annexItem = new BottomNavigationItem(R.mipmap.main_bottom_location_icon, "位置");
        orderItem = new BottomNavigationItem(R.mipmap.main_bottom_condition_icon, "车况");
        userItem = new BottomNavigationItem(R.mipmap.main_bottom_user_icon, "我的");
        //badgeItem = new BadgeItem().setBackgroundColor(Color.RED).setText("99").setHideOnSelect(true);//角标
        //annexItem.setBadgeItem(badgeItem);

        bottomNavigationBarContainer.addItem(homeItem).addItem(annexItem).addItem(orderItem).addItem(userItem);
        bottomNavigationBarContainer.initialise();
        bottomNavigationBarContainer.setTabSelectedListener(this);
        setDefaultActivity();//显示默认的Activity
    }

    /*设置默认Fragment*/
    private void setDefaultActivity() {
        if (homeActivity == null)
            homeActivity = new HomeActivity();
        addFrag(homeActivity);
        /*默认显示msgFrag*/
        getSupportFragmentManager().beginTransaction().show(homeActivity).commit();
    }

    /*添加Frag*/
    private void addFrag(Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (frag != null && !frag.isAdded())
            ft.add(R.id.bottom_nav_content, frag);
        ft.commit();
    }

    /*隐藏所有fragment*/
    private void hideAllFrag() {
        hideFrag(homeActivity);
        hideFrag(locationActivity);
        hideFrag(conditionActivity);
        hideFrag(userActivity);
    }

    /*隐藏frag*/
    private void hideFrag(Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (frag != null && frag.isAdded())
            ft.hide(frag);
        ft.commit();
    }

    @Override
    public void onTabSelected(int position) {
        hideAllFrag();//先隐藏所有frag
        switch (position) {
            case 0:
                if (homeActivity == null)
                    homeActivity = new HomeActivity();
                addFrag(homeActivity);
                getSupportFragmentManager().beginTransaction().show(homeActivity).commit();
                //getSupportActionBar().setTitle("消息");
                break;
            case 1:
                if (locationActivity == null)
                    locationActivity = new LocationActivity();
                addFrag(locationActivity);
                getSupportFragmentManager().beginTransaction().show(locationActivity).commit();
                //getSupportActionBar().setTitle("任务");
                break;
            case 2:
                if (conditionActivity == null)
                    conditionActivity = new ConditionActivity();
                addFrag(conditionActivity);
                getSupportFragmentManager().beginTransaction().show(conditionActivity).commit();
                //getSupportActionBar().setTitle("公告");
                break;
            case 3:
                if (userActivity == null)
                    userActivity = new UserActivity();
                addFrag(userActivity);
                getSupportFragmentManager().beginTransaction().show(userActivity).commit();
                //getSupportActionBar().setTitle("公告");
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
