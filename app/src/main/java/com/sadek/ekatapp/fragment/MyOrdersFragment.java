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
import com.sadek.ekatapp.adapter.OrderAdapter;
import com.sadek.ekatapp.adapter.SliderAdapter;
import com.sadek.ekatapp.adapter.SubCategoryAdapter;
import com.sadek.ekatapp.model.MainCategoriesModel;
import com.sadek.ekatapp.model.OrderModel;
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


public class MyOrdersFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.my_orders_recycler)
    RecyclerView my_orders_recycler;


    OrderAdapter orderAdapter;
    List<OrderModel> orderModelList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_orders, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        orderModelList = new ArrayList<>();


        setSliderData();


        //my_orders_recycler
        final RecyclerView.LayoutManager mLayoutManager_my_orders = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        my_orders_recycler.setLayoutManager(mLayoutManager_my_orders);
        orderAdapter = new OrderAdapter(orderModelList, getContext());
        my_orders_recycler.setAdapter(orderAdapter);


       }

    private void setSliderData() {


        orderModelList.add(new OrderModel("طلب", "#12345678", "05-02-2019", Common.ORDER_STATUS_COMPLETED));
        orderModelList.add(new OrderModel("طلب", "#12345678", "05-02-2019", Common.ORDER_STATUS_CANCELED));
        orderModelList.add(new OrderModel("طلب", "#12345678", "05-02-2019", Common.ORDER_STATUS_PROGRESS));


    }


}
