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
import com.sadek.ekatapp.model.OptionModel;
import com.sadek.ekatapp.model.OrderItemModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderItemsAdapter extends RecyclerView.Adapter<OrderItemsAdapter.ViewHolder> {

    private List<OrderItemModel> contents;
    private Context mContext;
    private int row_index = 0;

    public OrderItemsAdapter(List<OrderItemModel> contents, Context mContext) {
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
                .inflate(R.layout.item_order_details, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.order_item_name.setText(contents.get(position).getName());
        holder.order_item_quantity.setText(contents.get(position).getQuantity());
        holder.order_item_price.setText(contents.get(position).getPrice());


    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.order_item_name)
        TextView order_item_name;
        @BindView(R.id.order_item_quantity)
        TextView order_item_quantity;
        @BindView(R.id.order_item_price)
        TextView order_item_price;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

}