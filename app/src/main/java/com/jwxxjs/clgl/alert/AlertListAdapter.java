package com.jwxxjs.clgl.alert;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jwxxjs.AbsRecyclerViewAdapter;
import com.jwxxjs.clgl.R;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/11/24 0024.
 *
 * @link
 * @description
 */

public class AlertListAdapter extends AbsRecyclerViewAdapter{

    private List<AlertItem> mAllAlerts;

    public AlertListAdapter(RecyclerView recyclerView, List<AlertItem> allAlerts) {
        super(recyclerView);
        this.mAllAlerts = allAlerts;
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(LayoutInflater.from(getContext())
                .inflate(R.layout.item_alert_list, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            AlertItem listBean = mAllAlerts.get(position);
            itemViewHolder.mAlertTitle.setText(listBean.getmAlertTitle());
            itemViewHolder.mAlertLevel.setText(listBean.getmAlertLevel());
            itemViewHolder.mAlertDetail.setText(listBean.getmAlertDetail());
            setSortNumTextSize(itemViewHolder, position);

        }
        super.onBindViewHolder(holder, position);
    }


    private void setSortNumTextSize(ItemViewHolder itemViewHolder, int position) {
        if (position == 0) {
            itemViewHolder.mAlertTitle.setTextSize(24);
            itemViewHolder.mAlertTitle.setTextColor(
                    getContext().getResources().getColor(R.color.color_primary));
        } else if (position == 1) {
            itemViewHolder.mAlertTitle.setTextSize(22);
            itemViewHolder.mAlertTitle.setTextColor(
                    getContext().getResources().getColor(R.color.color_primary));
        } else if (position == 2) {
            itemViewHolder.mAlertTitle.setTextSize(18);
            itemViewHolder.mAlertTitle.setTextColor(
                    getContext().getResources().getColor(R.color.color_primary));
        } else {
            itemViewHolder.mAlertTitle.setTextSize(16);
            itemViewHolder.mAlertTitle.setTextColor(
                    getContext().getResources().getColor(R.color.color_primary_dark));
        }
    }


    @Override
    public int getItemCount() {
        return mAllAlerts.size();
    }


    public class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        TextView mAlertTitle;
        TextView mAlertLevel;
        TextView mAlertDetail;



        public ItemViewHolder(View itemView) {
            super(itemView);
            mAlertTitle = $(R.id.item_alert_title);
            mAlertLevel = $(R.id.item_alert_level);
            mAlertDetail = $(R.id.item_alert_details);


        }
    }
}

