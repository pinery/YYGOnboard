package com.cimcitech.yygonboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cimcitech on 2018/4/17.
 */

public class HomeGridViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Integer[] Images = {
            R.mipmap.home_grid_icon_1,
            R.mipmap.home_grid_icon_2,
            R.mipmap.home_grid_icon_3,
            R.mipmap.home_grid_icon_4,
            R.mipmap.home_grid_icon_5,
            R.mipmap.home_grid_icon_6,
            R.mipmap.home_grid_icon_7,
            R.mipmap.home_grid_icon_8
    };

    private String[] texts = {
            "月度报表",
            "数据统计",
            "数据查询",
            "车宝自检",
            "行车日志",
            "商城",
            "洗车",
            "4S店",
    };

    public HomeGridViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder wrapper = null;
        if (wrapper == null) {
            convertView = inflater.inflate(R.layout.home_grid_item_view, null);
            wrapper = new ViewHolder(convertView);
            convertView.setTag(wrapper);
        } else {
            wrapper = (ViewHolder) convertView.getTag();
        }
        wrapper.logoButton.setBackgroundResource(Images[position]);
        wrapper.tvLogo.setText(texts[position]);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.logoButton)
        ImageView logoButton;
        @Bind(R.id.tv_logo)
        TextView tvLogo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
