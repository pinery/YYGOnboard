package com.cimcitech.yygonboard.adapter.home;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.base.BaseViewHolder;
import com.cimcitech.yygonboard.utils.Config;

import java.util.List;

/**
 * Created by cimcitech on 2018/4/20.
 */

public class CheckAbnormalAdapter extends BaseRvAdapter<String> {

    private Context context;

    public CheckAbnormalAdapter(Context context, List<String> data) {
        super(Config.CONTEXT, R.layout.check_abnormal_item_view, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView statusTv = helper.getView(R.id.status_tv);
        if (helper.getPosition() % 2 == 0) {
            statusTv.setBackgroundResource(R.drawable.button_bg_blue);
        } else
            statusTv.setBackgroundResource(R.drawable.button_bg_red);
    }
}


