package com.cimcitech.yygonboard.adapter.home;

import android.content.Context;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.base.BaseViewHolder;
import com.cimcitech.yygonboard.utils.Config;

import java.util.List;

/**
 * Created by cimcitech on 2018/4/19.
 */

public class FaultDescriptionAdapter extends BaseRvAdapter<String> {

    private Context context;

    public FaultDescriptionAdapter(Context context, List<String> data) {
        super(Config.CONTEXT, R.layout.fault_description_item_view, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}


