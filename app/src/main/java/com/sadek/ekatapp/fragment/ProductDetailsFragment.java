package com.sadek.ekatapp.fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.HomeProductAdapter;
import com.sadek.ekatapp.adapter.OptionAdapter;
import com.sadek.ekatapp.adapter.SliderAdapter;
import com.sadek.ekatapp.model.CartModel;
import com.sadek.ekatapp.model.OptionModel;
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
import cn.refactor.lib.colordialog.PromptDialog;
import io.realm.Realm;
import io.realm.RealmResults;


public class ProductDetailsFragment extends Fragment {

    Unbinder unbinder;
    //init the Slider Recycler
    @BindView(R.id.product_detail_slider_recycler)
    RecyclerView product_detail_slider_recycler;
    @BindView(R.id.product_detail_slider_indicator)
    CircleIndicator2 product_detail_slider_indicator;

    @BindView(R.id.product_detail_color_recycler)
    RecyclerView product_detail_color_recycler;

    @BindView(R.id.product_detail_size_recycler)
    RecyclerView product_detail_size_recycler;

    @BindView(R.id.product_detail_ruler_recycler)
    RecyclerView product_detail_ruler_recycler;

    @BindView(R.id.product_detail_more_details_txt)
    TextView product_detail_more_details_txt;
    @BindView(R.id.product_detail_more_plus)
    TextView product_detail_more_plus;


    @BindView(R.id.product_detail_video_video)
    VideoView product_detail_video_video;
    @BindView(R.id.product_detail_video_plus)
    TextView product_detail_video_plus;


    @BindView(R.id.number_button_value_txt)
    TextView number_button_value_txt;

    @BindView(R.id.home_may_like_recycler)
    RecyclerView home_may_like_recycler;

    @BindView(R.id.product_detail_old_price)
    TextView product_detail_old_price;

    @BindView(R.id.cart_number)
    TextView cart_number;


    HomeProductAdapter homeProductAdapter;
    List<ProductModel> productModelList;


    SliderAdapter sliderAdapter;
    List<SliderModel> sliderModelList;

    OptionAdapter colorOptionAdapter;
    List<OptionModel> colorOptionModelList;

    OptionAdapter sizeOptionAdapter;
    List<OptionModel> sizeOptionModelList;

    OptionAdapter rulerOptionAdapter;
    List<OptionModel> rulerOptionModelList;

    Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        realm = Realm.getDefaultInstance();
        initUI();
    }


    private void initUI() {

//        product_detail_old_price.setText(product.getOfferPrice() + " " + getString(R.string.currency));
        product_detail_old_price.setPaintFlags(product_detail_old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        sliderModelList = new ArrayList<>();
        colorOptionModelList = new ArrayList<>();
        sizeOptionModelList = new ArrayList<>();
        rulerOptionModelList = new ArrayList<>();
        productModelList = new ArrayList<>();

        setSliderData();
        //init the offers
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        product_detail_slider_recycler.setLayoutManager(layoutManager);

        sliderAdapter = new SliderAdapter(sliderModelList, getContext());
        product_detail_slider_recycler.setAdapter(sliderAdapter);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(product_detail_slider_recycler);
        product_detail_slider_indicator.attachToRecyclerView(product_detail_slider_recycler, pagerSnapHelper);
        sliderAdapter.registerAdapterDataObserver(product_detail_slider_indicator.getAdapterDataObserver());
        Common.autoScrollRecycler(product_detail_slider_recycler, sliderModelList.size());


        //product_detail_color_recycler
        final RecyclerView.LayoutManager mLayoutManager_detail_color = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        product_detail_color_recycler.setLayoutManager(mLayoutManager_detail_color);
        colorOptionAdapter = new OptionAdapter(colorOptionModelList, getContext(), 0);
        product_detail_color_recycler.setAdapter(colorOptionAdapter);


        //product_detail_size_recycler
        final RecyclerView.LayoutManager mLayoutManager_detail_size = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        product_detail_size_recycler.setLayoutManager(mLayoutManager_detail_size);
        sizeOptionAdapter = new OptionAdapter(sizeOptionModelList, getContext(), 1);
        product_detail_size_recycler.setAdapter(sizeOptionAdapter);


        //product_detail_ruler_recycler
        final RecyclerView.LayoutManager mLayoutManager_detail_ruler = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        product_detail_ruler_recycler.setLayoutManager(mLayoutManager_detail_ruler);
        rulerOptionAdapter = new OptionAdapter(rulerOptionModelList, getContext(), 2);
        product_detail_ruler_recycler.setAdapter(rulerOptionAdapter);


        //home_may_like_recycler
        final RecyclerView.LayoutManager mLayoutManager_home_may_like = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        home_may_like_recycler.setLayoutManager(mLayoutManager_home_may_like);
        homeProductAdapter = new HomeProductAdapter(productModelList, getContext());
        home_may_like_recycler.setAdapter(homeProductAdapter);

    }

    private void setSliderData() {
        sliderModelList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg"));
        sliderModelList.add(new SliderModel("https://www.ekat.ae/wp-content/uploads/2019/01/Untitled-3-247x296.jpg"));

        colorOptionModelList.add(new OptionModel("#ff238980", ""));
        colorOptionModelList.add(new OptionModel("#ffa12d2d", ""));
        colorOptionModelList.add(new OptionModel("#ff40472f", ""));
        colorOptionModelList.add(new OptionModel("#ffd2e6a0", ""));

        sizeOptionModelList.add(new OptionModel("#ffe5e7df", "S"));
        sizeOptionModelList.add(new OptionModel("#ffe5e7df", "M"));
        sizeOptionModelList.add(new OptionModel("#ffe5e7df", "L"));
        sizeOptionModelList.add(new OptionModel("#ffe5e7df", "XL"));
        sizeOptionModelList.add(new OptionModel("#ffe5e7df", "XXL"));


        rulerOptionModelList.add(new OptionModel("#5e0091ff", "100"));
        rulerOptionModelList.add(new OptionModel("#5e0091ff", "110"));
        rulerOptionModelList.add(new OptionModel("#5e0091ff", "120"));
        rulerOptionModelList.add(new OptionModel("#5e0091ff", "130"));
        rulerOptionModelList.add(new OptionModel("#5e0091ff", "140"));


        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2019/01/Untitled-3-247x296.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));
        productModelList.add(new ProductModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "كلاب", "120 ر.ا", "وصل حديثاَ"));


        product_detail_video_video.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");

        if (cartNumber() == 0) {
            cart_number.setVisibility(View.GONE);
        } else {
            cart_number.setVisibility(View.VISIBLE);
            cart_number.setText(cartNumber() + "");
        }

    }


    @OnClick(R.id.product_detail_more_plus)
    void product_detail_more_plus(View view) {
        if (product_detail_more_details_txt.getVisibility() == View.VISIBLE) {
            product_detail_more_details_txt.setVisibility(View.GONE);
            product_detail_more_plus.setText("+");

        } else {
            product_detail_more_details_txt.setVisibility(View.VISIBLE);
            product_detail_more_plus.setText("-");
        }
    }

    @OnClick(R.id.product_detail_video_plus)
    void product_detail_video_plus(View view) {
        if (product_detail_video_video.getVisibility() == View.VISIBLE) {
            product_detail_video_video.setVisibility(View.GONE);
            product_detail_video_plus.setText("+");
            product_detail_video_video.pause();
        } else {
            product_detail_video_video.setVisibility(View.VISIBLE);
            product_detail_video_plus.setText("-");
            product_detail_video_video.start();
        }
    }

    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }

    //app_bar_notification_btn
    @OnClick(R.id.app_bar_notification_btn)
    void app_bar_notification_btn(View view) {
        ((MainActivity) getContext()).switchToPage(16, null, R.string.app_name);
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

    @OnClick(R.id.product_detail_add_to_cart)
    void product_detail_add_to_cart(View view) {
        addRecord();
    }

    @OnClick(R.id.product_detail_go_to_cart)
    void product_detail_go_to_cart(View view) {
        ((MainActivity) getContext()).switchToPage(16, null, R.string.app_name);
    }

    public void addRecord() {
        realm.beginTransaction();

        CartModel cartModel = realm.createObject(CartModel.class);
        cartModel.setId(cartNumber());
        cartModel.setName("الاسم");
        cartModel.setPrice("122");
        cartModel.setQuantity(number_button_value_txt.getText().toString());
        cartModel.setImage("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg");
        realm.commitTransaction();
        cart_number.setVisibility(View.VISIBLE);
        cart_number.setText(cartNumber() + "");
        Common.showErrorDialog2(getActivity(),PromptDialog.DIALOG_TYPE_SUCCESS, R.string.empty, R.string.success_add_to_cart);

    }

    public int cartNumber() {
        RealmResults<CartModel> results = realm.where(CartModel.class).findAll();
        return ((RealmResults) results).size();
    }
}
