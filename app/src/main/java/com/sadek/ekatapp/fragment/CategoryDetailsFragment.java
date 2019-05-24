package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.FilterAdapter;
import com.sadek.ekatapp.adapter.HomeProductAdapter;
import com.sadek.ekatapp.adapter.ProductAdapter;
import com.sadek.ekatapp.adapter.SliderAdapter;
import com.sadek.ekatapp.model.FilterModel;
import com.sadek.ekatapp.model.ProductModel;
import com.sadek.ekatapp.model.SliderModel;
import com.sadek.ekatapp.utils.Common;
import com.sadek.ekatapp.view.CircleIndicator2;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class CategoryDetailsFragment extends Fragment {

    Unbinder unbinder;
    //init the Slider Recycler
    @BindView(R.id.category_detail_slider_recycler)
    RecyclerView category_detail_slider_recycler;
    @BindView(R.id.category_detail_slider_indicator)
    CircleIndicator2 category_detail_slider_indicator;


    @BindView(R.id.app_bar_share_btn)
    ImageView app_bar_share_btn;

    @BindView(R.id.category_detail_products_recycler)
    RecyclerView category_detail_products_recycler;

    @BindView(R.id.category_detail_filter_recycler)
    RecyclerView category_detail_filter_recycler;

    ProductAdapter productAdapter;
    List<ProductModel> productModelList;

    FilterAdapter filterAdapter;
    List<FilterModel> filterModelList;


    SliderAdapter sliderAdapter;
    List<SliderModel> sliderModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }


    private void initUI() {
        app_bar_share_btn.setVisibility(View.GONE);

        sliderModelList = new ArrayList<>();
        productModelList = new ArrayList<>();
        filterModelList = new ArrayList<>();

        setSliderData();
        //init the offers
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        category_detail_slider_recycler.setLayoutManager(layoutManager);

        sliderAdapter = new SliderAdapter(sliderModelList, getContext());
        category_detail_slider_recycler.setAdapter(sliderAdapter);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(category_detail_slider_recycler);
        category_detail_slider_indicator.attachToRecyclerView(category_detail_slider_recycler, pagerSnapHelper);
        sliderAdapter.registerAdapterDataObserver(category_detail_slider_indicator.getAdapterDataObserver());
        Common.autoScrollRecycler(category_detail_slider_recycler, sliderModelList.size());


        //category_detail_products_recycler
        final RecyclerView.LayoutManager mLayoutManager_category_detail_products = new GridLayoutManager(getContext(), 2);
        category_detail_products_recycler.setLayoutManager(mLayoutManager_category_detail_products);
        productAdapter = new ProductAdapter(productModelList, getContext());
        category_detail_products_recycler.setAdapter(productAdapter);

        //category_detail_filter_recycler
        final RecyclerView.LayoutManager mLayoutManager_category_filter_products = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        category_detail_filter_recycler.setLayoutManager(mLayoutManager_category_filter_products);
        filterAdapter = new FilterAdapter(filterModelList, getContext());
        category_detail_filter_recycler.setAdapter(filterAdapter);

    }

    private void setSliderData() {
        sliderModelList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17.jpg"));
        sliderModelList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-2.jpg"));


        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/cat_dogkit-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/shampoo-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/REVOLOTION-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/B12-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/epi-soothe-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/VIBRAC0A-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/01/Untitled-3-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));

        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));
        filterModelList.add(new FilterModel("كلاب"));

    }


    @OnClick(R.id.category_detail_filter_txt)
    void category_detail_filter_txt(View view) {

    }
    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }
    //app_bar_notification_btn
    @OnClick(R.id.app_bar_notification_btn)
    void app_bar_notification_btn(View view) {
        ((MainActivity)getContext()).switchToPage(15, null, R.string.app_name);
    }

}
