package com.sadek.ekatapp.fragment;

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
import com.sadek.ekatapp.adapter.HomeProductAdapter;
import com.sadek.ekatapp.adapter.OptionAdapter;
import com.sadek.ekatapp.adapter.OrderItemsAdapter;
import com.sadek.ekatapp.adapter.SliderAdapter;
import com.sadek.ekatapp.model.OptionModel;
import com.sadek.ekatapp.model.OrderItemModel;
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


public class OrderDetailsFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.order_details_order_items_recycler)
    RecyclerView order_details_order_items_recycler;


    OrderItemsAdapter orderItemsAdapter;
    List<OrderItemModel> orderItemModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }


    private void initUI() {

        orderItemModels = new ArrayList<>();

        setSliderData();

        //order_details_order_items_recycler
        final RecyclerView.LayoutManager mLayoutManager_detail_color = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        order_details_order_items_recycler.setLayoutManager(mLayoutManager_detail_color);
        orderItemsAdapter = new OrderItemsAdapter(orderItemModels , getContext());
        order_details_order_items_recycler.setAdapter(orderItemsAdapter);


    }

    private void setSliderData() {

        orderItemModels.add(new OrderItemModel("صقر عربي صحراوي", "1 ×","250 ا.د"));
        orderItemModels.add(new OrderItemModel("صقر عربي صحراوي", "1 ×","250 ا.د"));
        orderItemModels.add(new OrderItemModel("صقر عربي صحراوي", "1 ×","250 ا.د"));

    }


}
