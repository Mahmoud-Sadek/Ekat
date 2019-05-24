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
import com.sadek.ekatapp.model.MainCategoriesModel;
import com.sadek.ekatapp.model.MenuModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private List<MenuModel> contents;
    private Context mContext;
    public MenuAdapter(List<MenuModel> contents, Context mContext) {
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
                .inflate(R.layout.item_menu, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        //todo here to get the image and load it
        if (mContext != null)
//            Common.BASE_IMAGE_URL+

        holder.txt.setText(contents.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)mContext).switchToPage(17, null, R.string.app_name);
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
        @BindView(R.id.menu_txt)TextView txt;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


    }

}