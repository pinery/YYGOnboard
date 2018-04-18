package com.cimcitech.yygonboard.adapter.user;

import android.content.Context;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.base.BaseViewHolder;
import com.cimcitech.yygonboard.model.user.MyCarListVo;
import com.cimcitech.yygonboard.utils.Config;

import java.util.List;

/**
 * Created by cimcitech on 2018/4/18.
 */

public class MyCarListAdapter extends BaseRvAdapter<MyCarListVo> {

    private Context context;

    public MyCarListAdapter(Context context, List<MyCarListVo> data) {
        super(Config.CONTEXT, R.layout.my_cat_list_item_view, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCarListVo item) {
        helper.setText(R.id.car_brands_tv, item.getName());
    }
}


