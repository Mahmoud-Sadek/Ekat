package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.HomeProductAdapter;
import com.sadek.ekatapp.adapter.MainCategoryAdapter;
import com.sadek.ekatapp.adapter.OfferAdapter;
import com.sadek.ekatapp.adapter.SliderAdapter;
import com.sadek.ekatapp.adapter.SubCategoryAdapter;
import com.sadek.ekatapp.model.MainCategoriesModel;
import com.sadek.ekatapp.model.ProductModel;
import com.sadek.ekatapp.model.SliderModel;
import com.sadek.ekatapp.utils.Common;
import com.sadek.ekatapp.view.CircleIndicator2;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MainFragment extends Fragment {

    Unbinder unbinder;
    //init the Slider Recycler
    @BindView(R.id.home_slider_recycler)
    RecyclerView home_slider_recycler;
    @BindView(R.id.home_slider_indicator)
    CircleIndicator2 home_slider_indicator;

    @BindView(R.id.home_categories_recycler)
    RecyclerView home_categories_recycler;

    @BindView(R.id.home_first_category_layout)
    View home_first_category_layout;
    @BindView(R.id.home_first_category_txt)
    TextView home_first_category_txt;
    @BindView(R.id.home_first_category_img)
    ImageView home_first_category_img;
    @BindView(R.id.home_first_category_recycler)
    RecyclerView home_first_category_recycler;

    @BindView(R.id.home_new_offers_recycler)
    RecyclerView home_new_offers_recycler;


    @BindView(R.id.home_second_category_layout)
    View home_second_category_layout;
    @BindView(R.id.home_second_category_txt)
    TextView home_second_category_txt;
    @BindView(R.id.home_second_category_img)
    ImageView home_second_category_img;
    @BindView(R.id.home_second_category_recycler)
    RecyclerView home_second_category_recycler;

    @BindView(R.id.home_may_like_recycler)
    RecyclerView home_may_like_recycler;


    SliderAdapter sliderAdapter;
    List<SliderModel> sliderModelList;

    MainCategoryAdapter mainCategoryAdapter;
    List<MainCategoriesModel> mainCategoriesModelList;


    SubCategoryAdapter subFirstCategoryAdapter;
    List<MainCategoriesModel> subFirstCategoriesModelList;

    SubCategoryAdapter subSecondCategoryAdapter;
    List<MainCategoriesModel> subSecondCategoriesModelList;

    OfferAdapter offerAdapter;
    List<SliderModel> offerList;

    HomeProductAdapter homeProductAdapter;
    List<ProductModel> productModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        mainCategoriesModelList = new ArrayList<>();
        sliderModelList = new ArrayList<>();
        subFirstCategoriesModelList = new ArrayList<>();
        subSecondCategoriesModelList = new ArrayList<>();
        offerList = new ArrayList<>();
        productModelList = new ArrayList<>();


        setSliderData();
        //init the offers
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        home_slider_recycler.setLayoutManager(layoutManager);

        sliderAdapter = new SliderAdapter(sliderModelList, getContext());
        home_slider_recycler.setAdapter(sliderAdapter);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(home_slider_recycler);
        home_slider_indicator.attachToRecyclerView(home_slider_recycler, pagerSnapHelper);
        sliderAdapter.registerAdapterDataObserver(home_slider_indicator.getAdapterDataObserver());
        Common.autoScrollRecycler(home_slider_recycler, sliderModelList.size());


        //home_categories_recycler
        final RecyclerView.LayoutManager mLayoutManager_home_categories = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        home_categories_recycler.setLayoutManager(mLayoutManager_home_categories);
        mainCategoryAdapter = new MainCategoryAdapter(mainCategoriesModelList, getContext());
        home_categories_recycler.setAdapter(mainCategoryAdapter);

        //home_first_category_recycler
        final RecyclerView.LayoutManager mLayoutManager_home_first_category = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        home_first_category_recycler.setLayoutManager(mLayoutManager_home_first_category);
        subFirstCategoryAdapter = new SubCategoryAdapter(subFirstCategoriesModelList, getContext());
        home_first_category_recycler.setAdapter(subFirstCategoryAdapter);


        //home_second_category_recycler
        final RecyclerView.LayoutManager mLayoutManager_home_second_category = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        home_second_category_recycler.setLayoutManager(mLayoutManager_home_second_category);
        subSecondCategoryAdapter = new SubCategoryAdapter(subSecondCategoriesModelList, getContext());
        home_second_category_recycler.setAdapter(subSecondCategoryAdapter);


        //home_new_offers_recycler
        final RecyclerView.LayoutManager mLayoutManager_home_new_offers = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        home_new_offers_recycler.setLayoutManager(mLayoutManager_home_new_offers);
        offerAdapter = new OfferAdapter(offerList, getContext());
        home_new_offers_recycler.setAdapter(offerAdapter);


        //home_may_like_recycler
        final RecyclerView.LayoutManager mLayoutManager_home_may_like = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        home_may_like_recycler.setLayoutManager(mLayoutManager_home_may_like);
        homeProductAdapter = new HomeProductAdapter(productModelList, getContext());
        home_may_like_recycler.setAdapter(homeProductAdapter);
    }

    private void setSliderData() {
        sliderModelList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2019/01/parrot-offer-web-en.jpg"));
        sliderModelList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2019/01/Untitled-3-247x296.jpg"));

        offerList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2018/07/G1-247x296.jpeg"));
        offerList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2019/01/Untitled-3-247x296.jpg"));
        offerList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg"));
        offerList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg"));
        offerList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg"));
        offerList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2019/01/Untitled-3-247x296.jpg"));

        mainCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-2.jpg", "كلاب"));
        mainCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-1.jpg", "قطط"));
        mainCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17.jpg", "طيور"));
        mainCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-2.jpg", "كلاب"));
        mainCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-1.jpg", "قطط"));
        mainCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17.jpg", "طيور"));

        Picasso.with(getContext()).load("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17.jpg").into(home_first_category_img);
        Picasso.with(getContext()).load("https://www.ekat.ae/wp-content/uploads/2018/12/2018-12-18_03-03-17-2.jpg").into(home_second_category_img);


        subFirstCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/parrot-toy-247x296.jpg", "كلاب"));
        subFirstCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/bird-gromming-247x296.jpg", "كلاب"));
        subFirstCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/parrot-clothing-247x296.jpg", "كلاب"));
        subFirstCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/canares-247x296.jpg", "كلاب"));
        subFirstCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/shutterstock_1-247x296.jpg", "كلاب"));
        subFirstCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/PIGEONS-247x296.jpg", "كلاب"));
        subFirstCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/Golden-Pheasant-247x296.jpg", "كلاب"));


        subSecondCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/01/gromming-247x296.jpg", "كلاب"));
        subSecondCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/Dog-Bowls-247x296.jpg", "كلاب"));
        subSecondCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/cloth-247x296.jpg", "كلاب"));
        subSecondCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/as-247x296.jpg", "كلاب"));
        subSecondCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/Leashes-Collar-247x296.jpg", "كلاب"));
        subSecondCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/dog-toy-247x296.jpg", "كلاب"));
        subSecondCategoriesModelList.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2018/12/4001967099348-247x296.jpg", "كلاب"));



        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/cat_dogkit-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/shampoo-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/REVOLOTION-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/B12-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/epi-soothe-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/04/VIBRAC0A-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));


    }

    //app_bar_notification_btn
    @OnClick(R.id.app_bar_notification_btn)
    void app_bar_notification_btn(View view) {
        ((MainActivity)getContext()).switchToPage(15, null, R.string.app_name);
    }

    //app_bar_cart_btn
    @OnClick(R.id.app_bar_cart_btn)
    void app_bar_cart_btn(View view) {
        ((MainActivity)getContext()).switchToPage(16, null, R.string.app_name);
    }

    //app_bar_menu_btn
    @OnClick(R.id.app_bar_menu_btn)
    void app_bar_menu_btn(View view) {
        ((MainActivity)getContext()).switchToPage(7, null, R.string.app_name);
    }

    //home_first_category_see_all_txt
    @OnClick(R.id.home_first_category_see_all_txt)
    void home_first_category_see_all_txt(View view) {
        ((MainActivity)getContext()).switchToPage(3, null, R.string.app_name);
    }

    //home_first_category_see_all_txt
    @OnClick(R.id.home_second_category_see_all_txt)
    void home_second_category_see_all_txt(View view) {
        ((MainActivity)getContext()).switchToPage(3, null, R.string.app_name);
    }

}
