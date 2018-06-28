package com.jwxxjs.clgl.vehicleinfo;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jwxxjs.clgl.R;

import java.util.List;

/**
 * Created by zcl on 2018/3/28.
 *
 * @link
 * @description
 */

public class VehicleInfoAdapter extends BaseQuickAdapter<VehicleItem,BaseViewHolder> {
    public VehicleInfoAdapter(int layoutResId, @Nullable List<VehicleItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, VehicleItem item) {
        helper.setText(R.id.item_vehicleinfo_plateNo,item.getPlateNumber());
        helper.setText(R.id.item_vehicleinfo_department,item.getOrganizeId());
        helper.setText(R.id.item_vehicleinfo_startdate,item.getSignalModel().getBuildDate());

    }

    @Override
    protected BaseViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View convertView = layoutInflater.inflate(R.layout.item_vehicle_info, null, false); // if use parent, only first line will show up
        return new BaseViewHolder(convertView);
    }
}
