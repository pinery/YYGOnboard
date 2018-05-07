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

public class StatisticsGridViewAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private String[] datas = {
            "0.00",
            "0.00",
            "0.00",
            "0.00",
    };

    private String[] texts = {
            "平均转速\n（r/min）",
            "日行驶里程\n（km）",
            "平均车速\n（km/h）",
            "日消费\n（￥）",
    };

    public StatisticsGridViewAdapter(Context context) {
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
            convertView = inflater.inflate(R.layout.statistics_grid_view_item, null);
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
