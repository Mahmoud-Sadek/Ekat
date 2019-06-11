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
import com.sadek.ekatapp.interfaces.CartInterface;
import com.sadek.ekatapp.model.CartModel;
import com.sadek.ekatapp.model.NotificationsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<CartModel> contents;
    private Context mContext;
    private int row_index = 0;
//    Realm realm;
    CartInterface cartInterface;

    public CartAdapter(List<CartModel> contents, Context mContext, CartInterface cartInterface) {
        this.contents = contents;
        this.mContext = mContext;
//        realm = Realm.getDefaultInstance();
        this.cartInterface = cartInterface;
    }


    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;


        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        Picasso.with(mContext).load(contents.get(position).getImage()).into(holder.cart_item_image);
        holder.cart_item_name_txt.setText(contents.get(position).getName());
        holder.cart_item_price_txt.setText(Double.parseDouble(contents.get(position).getPrice())*Double.parseDouble(contents.get(position).getQuantity())+mContext.getString(R.string.a_e_d));
        holder.number_button_value_txt.setText(contents.get(position).getQuantity());

        holder.item_cart_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteRecord(contents.get(position).getId());
//                contents.remove(position);
//                notifyDataSetChanged();
            }
        });

    }
    public void deleteRecord(int id){
        cartInterface.onItemRemoves(id);
//        RealmResults<CartModel> results = realm.where(CartModel.class).equalTo("id", id).findAll();
//
//        realm.beginTransaction();
//
//        results.deleteAllFromRealm();
//
//        realm.commitTransaction();
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_cart_delete)
        ImageView item_cart_delete;
        @BindView(R.id.cart_item_image)
        ImageView cart_item_image;
        @BindView(R.id.cart_item_name_txt)
        TextView cart_item_name_txt;
        @BindView(R.id.cart_item_price_txt)
        TextView cart_item_price_txt;

        @BindView(R.id.number_button_value_txt)
        TextView number_button_value_txt;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }



        //number button
        @OnClick(R.id.number_button_plus_btn)
        void number_button_plus_btn(View view) {
            int currentNumber = Integer.parseInt(number_button_value_txt.getText().toString()) + 1;
            number_button_value_txt.setText(currentNumber + "");
        }

        @OnClick(R.id.number_button_minus_btn)
        void number_button_minus_btn(View view) {
            int currentNumber = Integer.parseInt(number_button_value_txt.getText().toString()) - 1;
            if (currentNumber != 0)
                number_button_value_txt.setText(currentNumber + "");
        }
    }

}