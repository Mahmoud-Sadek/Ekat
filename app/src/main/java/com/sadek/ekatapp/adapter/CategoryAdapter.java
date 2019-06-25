package com.sadek.ekatapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.model.MainCategoriesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<MainCategoriesModel> contents;
    private Context mContext;

    public CategoryAdapter(List<MainCategoriesModel> contents, Context mContext) {
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
                .inflate(R.layout.item_sub_category, parent, false);
        return new ViewHolder(view);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        //todo here to get the image and load it
        if (mContext != null)
            holder.txt.setText(contents.get(position).getTitle());
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.sub_category_image.setBackgroundColor(color);


        //sub_category_recycler
        final RecyclerView.LayoutManager mLayoutManager_sub_category = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        holder.sub_category_recycler.setLayoutManager(mLayoutManager_sub_category);
        holder.categoryAdapter = new SubCategoryMenuAdapter(holder.categoriesModels, mContext);
        holder.sub_category_recycler.setAdapter(holder.categoryAdapter);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sub_category_recycler)
        RecyclerView sub_category_recycler;
        @BindView(R.id.sub_category_txt)
        TextView txt;
        @BindView(R.id.sub_category_image)
        ImageView sub_category_image;


        SubCategoryMenuAdapter categoryAdapter;
        List<MainCategoriesModel> categoriesModels;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            categoriesModels = new ArrayList<>();

            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));

/*

            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-2.jpg", "كلاب"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/01/gromming-247x296.jpg", "قطط"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/Golden-Pheasant-247x296.jpg", "طيور"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-2.jpg", "كلاب"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-1.jpg", "قطط"));
            categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/Golden-Pheasant-247x296.jpg", "طيور"));
*/
        }


    }

}