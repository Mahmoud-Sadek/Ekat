package com.sadek.ekatapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.model.NotificationsModel;
import com.sadek.ekatapp.model.OrderModel;
import com.sadek.ekatapp.utils.Common;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.ViewHolder> {

    private List<NotificationsModel> contents;
    private Context mContext;
    private int row_index = 0;

    public NotificationsAdapter(List<NotificationsModel> contents, Context mContext) {
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
                .inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {



        holder.notification_txt.setText(contents.get(position).getTitle());


    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.notification_txt)
        TextView notification_txt;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

}