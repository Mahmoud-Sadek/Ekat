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
import com.sadek.ekatapp.model.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductModel> contents;
    private Context mContext;

    public ProductAdapter(List<ProductModel> contents, Context mContext) {
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
                .inflate(R.layout.item_products, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        //todo here to get the image and load it
        if (mContext != null)
//            Common.BASE_IMAGE_URL+
            Picasso.with(mContext).load(contents.get(position).getImage()).into(holder.home_product_image);
        holder.home_product_txt.setText(contents.get(position).getTitle());
        holder.home_product_price.setText(contents.get(position).getPrice());
        holder.home_product_kind.setText(contents.get(position).getKind());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)mContext).switchToPage(2, null, R.string.app_name);
               /* Bundle bundle = new Bundle();
                bundle.putInt(Common.OfferId, contents.get(position).getId());
                bundle.putString(Common.OfferImage, contents.get(position).getImage());
                bundle.putString(Common.OfferName, contents.get(position).getTitle());
                Intent intent = new Intent(mContext, OfferActivity.class);
                // we will send food id to food detail class
                intent.putExtras(bundle);
                mContext.startActivity(intent);*/
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_product_image)
        ImageView home_product_image;
        @BindView(R.id.home_product_txt)
        TextView home_product_txt;
        @BindView(R.id.home_product_price)
        TextView home_product_price;
        @BindView(R.id.home_product_kind)
        TextView home_product_kind;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

}