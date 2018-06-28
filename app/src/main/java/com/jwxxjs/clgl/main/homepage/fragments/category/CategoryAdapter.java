package com.jwxxjs.clgl.main.homepage.fragments.category;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jwxxjs.AbsRecyclerViewAdapter;
import com.jwxxjs.clgl.R;

/**
 * Created by Administrator on 2017/11/24 0024.
 *
 * @link
 * @description
 */

public class CategoryAdapter extends AbsRecyclerViewAdapter {

    private String[] itemNames = new String[]{
            "报警记录", "车辆信息", "待定",
            "待定", "待定", "待定",
    };

    private int[] itemIcons = new int[]{
            R.drawable.ic_alert, R.drawable.ic_vehicle,
            R.drawable.ic_tmp_24dp, R.drawable.ic_tmp_24dp,
            R.drawable.ic_tmp_24dp, R.drawable.ic_tmp_24dp,
    };


    public CategoryAdapter(RecyclerView recyclerView) {
        super(recyclerView);
    }


    @Override
    public ClickableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bindContext(parent.getContext());
        return new ItemViewHolder(
                LayoutInflater.from(getContext()).inflate(R.layout.item_message_category, parent, false));
    }


    @Override
    public void onBindViewHolder(ClickableViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mItemIcon.setImageResource(itemIcons[position]);
            itemViewHolder.mItemText.setText(itemNames[position]);
        }
        super.onBindViewHolder(holder, position);
    }


    @Override
    public int getItemCount() {
        return itemIcons.length;
    }


    private class ItemViewHolder extends AbsRecyclerViewAdapter.ClickableViewHolder {

        ImageView mItemIcon;
        TextView mItemText;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mItemIcon = $(R.id.item_category_icon);
            mItemText = $(R.id.item_category_title);
        }
    }
}
