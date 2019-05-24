package com.sadek.ekatapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.model.ImageModel;
import com.sadek.ekatapp.model.SliderModel;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<ImageModel> contents;
    private Context mContext;
    public ImageAdapter(List<ImageModel> contents, Context mContext) {
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
                .inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);


    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        int position = positions % contents.size();

        //todo here to get the image and load it
        if (mContext != null)
//            Common.BASE_IMAGE_URL+
//            Picasso.with(mContext).load(contents.get(position).getImage()).into(holder.image);


            try {
                Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), contents.get(position).getImage());
                holder.image.setImageBitmap(bitmapImage);
            } catch (IOException e) {
                e.printStackTrace();
            }



        holder.item_image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contents.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
        @BindView(R.id.item_image)ImageView image;
        @BindView(R.id.item_image_delete)ImageView item_image_delete;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

}