package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.adapter.CartAdapter;
import com.sadek.ekatapp.adapter.NotificationsAdapter;
import com.sadek.ekatapp.model.CartModel;
import com.sadek.ekatapp.model.NotificationsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class CartFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.tabTxt)
    TextView tabTxt;
    @BindView(R.id.cart_recycler)
    RecyclerView cart_recycler;


    CartAdapter cartAdapter;
    List<CartModel> cartModelList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }


    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }
    private void initUI() {
        tabTxt.setText(R.string.shopping_cart);

        cartModelList = new ArrayList<>();

        setSliderData();


        //notification_recycler
        final RecyclerView.LayoutManager mLayoutManager_notifications = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        cart_recycler.setLayoutManager(mLayoutManager_notifications);
        cartAdapter = new CartAdapter(cartModelList, getContext());
        cart_recycler.setAdapter(cartAdapter);


       }

    private void setSliderData() {

        cartModelList.add(new CartModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم","2","250 A.E.D"));
        cartModelList.add(new CartModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم","2","250 A.E.D"));
        cartModelList.add(new CartModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم","2","250 A.E.D"));
        cartModelList.add(new CartModel("https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم","2","250 A.E.D"));
    }


}
