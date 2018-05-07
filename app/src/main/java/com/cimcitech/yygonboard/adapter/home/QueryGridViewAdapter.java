package com.cimcitech.yygonboard.adapter.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cimcitech on 2018/4/25.
 */

public class QueryGridViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private String[] datas = {
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
            "2000",
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
            "月度报表",
            "数据统计",
            "数据查询",
            "车宝自检",
            "行车日志",
            "商城",
            "洗车",
            "4S店",
    };

    public QueryGridViewAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.length;
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
            convertView = inflater.inflate(R.layout.query_data_grid_item_view, null);
            wrapper = new ViewHolder(convertView);
            convertView.setTag(wrapper);
        } else {
            wrapper = (ViewHolder) convertView.getTag();
        }
        wrapper.valueTv.setText(datas[position]);
        wrapper.keyTv.setText(texts[position]);
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.value_tv)
        TextView valueTv;
        @Bind(R.id.key_tv)
        TextView keyTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
