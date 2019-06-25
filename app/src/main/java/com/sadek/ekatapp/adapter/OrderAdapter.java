package com.sadek.ekatapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.model.OrderModel;
import com.sadek.ekatapp.utils.Common;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<OrderModel> contents;
    private Context mContext;
    private int row_index = 0;

    public OrderAdapter(List<OrderModel> contents, Context mContext) {
        this.contents = contents;
        this.mContext = mContext;
    }


    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;


        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {



        holder.order_name_txt.setText(contents.get(position).getOrderName());
        holder.order_number_txt.setText(contents.get(position).getOrderNumber());
        holder.order_date_txt.setText(contents.get(position).getOrderDate());
        if (contents.get(position).getOrderStatus().equals(Common.ORDER_STATUS_COMPLETED)) {
            holder.order_status_txt.setText(R.string.order_completed);
            holder.order_status_image.setImageResource(R.drawable.ic_checked_order);
            holder.order_status_txt.setTextColor(mContext.getResources().getColor(R.color.orderCompleted));
        }else if (contents.get(position).getOrderStatus().equals(Common.ORDER_STATUS_PROGRESS)) {
            holder.order_status_txt.setText(R.string.order_in_progress);
            holder.order_status_image.setImageResource(R.drawable.ic_time_left_order);
            holder.order_status_txt.setTextColor(mContext.getResources().getColor(R.color.orderProgress));
        }else if (contents.get(position).getOrderStatus().equals(Common.ORDER_STATUS_CANCELED)) {
            holder.order_status_txt.setText(R.string.order_canceled);
            holder.order_status_image.setImageResource(R.drawable.ic_error_order);
            holder.order_status_txt.setTextColor(mContext.getResources().getColor(R.color.orderCanceled));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)mContext).switchToPage(9, null, R.string.app_name);
            }
        });

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_status_image)
        ImageView order_status_image;
        @BindView(R.id.order_name_txt)
        TextView order_name_txt;
        @BindView(R.id.order_number_txt)
        TextView order_number_txt;
        @BindView(R.id.order_status_txt)
        TextView order_status_txt;
        @BindView(R.id.order_date_txt)
        TextView order_date_txt;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

}