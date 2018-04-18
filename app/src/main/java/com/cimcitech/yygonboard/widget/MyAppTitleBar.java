package com.cimcitech.yygonboard.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;

/**
 * Created by cimcitech on 2018/3/29.
 */

public class MyAppTitleBar extends LinearLayout {
    private OnLeftButtonClickListener mLeftButtonClickListener;
    private OnRightButtonClickListener mRightButtonClickListener;
    private MyViewHolder mViewHolder;
    private View viewAppTitle;
    public static long lastClickTime = 0;

    public MyAppTitleBar(Context context) {
        super(context);
        init();
    }

    public MyAppTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public MyAppTitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        viewAppTitle = inflater.inflate(R.layout.view_activity_titlebar, null);
        this.addView(viewAppTitle, layoutParams);
        mViewHolder = new MyViewHolder(this);
        mViewHolder.llLeftGoBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFastDoubleClick()) {
                    return;
                }
                if (mLeftButtonClickListener != null) {
                    mLeftButtonClickListener.onLeftButtonClick(v);
                }
            }
        });
        mViewHolder.llRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFastDoubleClick()) {
                    return;
                }
                if (mRightButtonClickListener != null) {
                    mRightButtonClickListener.OnRightButtonClick(v);
                }
            }
        });
    }

    // 解决用户连续点击造成出现多个相同的activity
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (timeD >= 0 && timeD <= 500) {
            return true;
        } else {
            lastClickTime = time;
            return false;
        }
    }

    public void initViewsVisible(boolean isLeftButtonVisile, boolean isCenterTitleVisile, boolean isRightIconVisile, boolean isRightTitleVisile) {
        // 左侧返回
        mViewHolder.llLeftGoBack.setVisibility(isLeftButtonVisile ? View.VISIBLE : View.INVISIBLE);
        // 中间标题
        mViewHolder.tvCenterTitle.setVisibility(isCenterTitleVisile ? View.VISIBLE : View.INVISIBLE);
        // 右侧返回图标,文字
        if (!isRightIconVisile && !isRightTitleVisile) {
            mViewHolder.llRight.setVisibility(View.INVISIBLE);
        } else {
            mViewHolder.llRight.setVisibility(View.VISIBLE);
        }
        mViewHolder.ivRightComplete.setVisibility(isRightIconVisile ? View.VISIBLE : View.GONE);
        mViewHolder.tvRightComplete.setVisibility(isRightTitleVisile ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            mViewHolder.tvCenterTitle.setText(title);
        }
    }

    public void setListIcon(int sourceID) {
        mViewHolder.ivLeftComplete.setImageResource(sourceID);
    }

    public void setRightTitle(String text) {
        if (!TextUtils.isEmpty(text)) {
            mViewHolder.tvRightComplete.setText(text);
        }
    }

    public void setRightIcon(int sourceID) {
        mViewHolder.ivRightComplete.setImageResource(sourceID);
    }

    public void setLeftOnclick(OnLeftButtonClickListener mOnLeftButtonClickListener) {
        if (mOnLeftButtonClickListener != null) {
        }
    }

    public void setAppBackground(int color) {
        viewAppTitle.setBackgroundColor(color);
    }

    public void setOnLeftButtonClickListener(OnLeftButtonClickListener listen) {
        mLeftButtonClickListener = listen;
    }

    public void setOnRightButtonClickListener(OnRightButtonClickListener listen) {
        mRightButtonClickListener = listen;
    }

    public static abstract interface OnLeftButtonClickListener {
        public abstract void onLeftButtonClick(View v);
    }

    public static abstract interface OnRightButtonClickListener {
        public abstract void OnRightButtonClick(View v);
    }

    static class MyViewHolder {
        LinearLayout llLeftGoBack;
        TextView tvCenterTitle;
        LinearLayout llRight;
        ImageButton ivRightComplete;
        TextView tvRightComplete;
        ImageButton ivLeftComplete;

        public MyViewHolder(View v) {
            llLeftGoBack = v.findViewById(R.id.llLeftGoBack);
            tvCenterTitle = v.findViewById(R.id.tvCenterTitle);
            llRight = v.findViewById(R.id.llRight);
            ivRightComplete = v.findViewById(R.id.ivRightComplete);
            tvRightComplete = v.findViewById(R.id.tvRightComplete);
            ivLeftComplete = v.findViewById(R.id.ivLeftComplete);
        }
    }
}
