package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.adapter.CategoryAdapter;
import com.sadek.ekatapp.model.MainCategoriesModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SubCategoryFragment extends Fragment {

    Unbinder unbinder;


    @BindView(R.id.app_bar_share_btn)
    ImageView app_bar_share_btn;

    @BindView(R.id.sub_category_recycler)
    RecyclerView sub_category_recycler;

    CategoryAdapter categoryAdapter;
    List<MainCategoriesModel> categoriesModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sub_category, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }


    private void initUI() {
        app_bar_share_btn.setVisibility(View.GONE);

        categoriesModels = new ArrayList<>();

        setSliderData();

        //sub_category_recycler
        final RecyclerView.LayoutManager mLayoutManager_sub_category = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        sub_category_recycler.setLayoutManager(mLayoutManager_sub_category);
        categoryAdapter = new CategoryAdapter(categoriesModels, getContext());
        sub_category_recycler.setAdapter(categoryAdapter);

    }

    private void setSliderData() {
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
    }


}
