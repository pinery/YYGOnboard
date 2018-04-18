package com.cimcitech.yygonboard.adapter.home;

import android.content.Context;
import android.widget.ImageView;

import com.cimcitech.yygonboard.R;
import com.cimcitech.yygonboard.base.BaseRvAdapter;
import com.cimcitech.yygonboard.base.BaseViewHolder;
import com.cimcitech.yygonboard.model.home.SelfCheckVo;
import com.cimcitech.yygonboard.utils.Config;

import java.util.List;

/**
 * Created by cimcitech on 2018/4/18.
 */

public class SelfCheckAdapter extends BaseRvAdapter<SelfCheckVo> {

    private Context context;

    public SelfCheckAdapter(Context context, List<SelfCheckVo> data) {
        super(Config.CONTEXT, R.layout.self_check_item_view, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelfCheckVo item) {
        helper.setText(R.id.check_name_tv, item.getName());
        ImageView checkImage = helper.getView(R.id.check_image_iv);
        if (helper.getPosition() % 2 == 0) {
            checkImage.setBackgroundResource(R.mipmap.self_check_ok_icon);
        } else
            checkImage.setBackgroundResource(R.mipmap.self_check_careful_icon);
    }
}


