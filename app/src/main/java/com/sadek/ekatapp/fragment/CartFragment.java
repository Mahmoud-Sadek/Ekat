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
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.CartAdapter;
import com.sadek.ekatapp.interfaces.CartInterface;
import com.sadek.ekatapp.model.CartModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;


public class CartFragment extends Fragment implements CartInterface {

    Unbinder unbinder;

    @BindView(R.id.cart_total_price)
    TextView cart_total_price;
    @BindView(R.id.tabTxt)
    TextView tabTxt;
    @BindView(R.id.cart_recycler)
    RecyclerView cart_recycler;

    @BindView(R.id.cart_cart_layout)
    View cart_cart_layout;
    @BindView(R.id.cart_empty_cart_layout)
    View cart_empty_cart_layout;


    CartAdapter cartAdapter;
    List<CartModel> cartModelList;

    Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        realm = Realm.getDefaultInstance();
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
        cartAdapter = new CartAdapter(cartModelList, getContext(), this);
        cart_recycler.setAdapter(cartAdapter);


    }

    private void setSliderData() {
        cartNumber();
//        cartModelList.add(new CartModel(1, "https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم", "2", "250 A.E.D"));
//        cartModelList.add(new CartModel(1, "https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم", "2", "250 A.E.D"));
//        cartModelList.add(new CartModel(1, "https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم", "2", "250 A.E.D"));
//        cartModelList.add(new CartModel(1, "https://www.ekat.ae/wp-content/uploads/2018/12/happy-cats.jpg", "الاسم", "2", "250 A.E.D"));
    }

    public void cartNumber() {
        cartModelList.clear();
//        cartAdapter.notifyDataSetChanged();
        Double total_price = 0.0;
        RealmResults<CartModel> results = realm.where(CartModel.class).findAll();
        for (CartModel cartModel : results) {
            cartModelList.add(cartModel);
            total_price += Double.parseDouble(cartModel.getPrice()) * Double.parseDouble(cartModel.getQuantity());
        }
        cart_total_price.setText(total_price + "د.ا");

        if (total_price == 0.0){
            cart_empty_cart_layout.setVisibility(View.VISIBLE);
            cart_cart_layout.setVisibility(View.GONE);
        }else {

            cart_empty_cart_layout.setVisibility(View.GONE);
            cart_cart_layout.setVisibility(View.VISIBLE);
        }
    }

    //
    @OnClick(R.id.continue_btn)
    void continue_btn(View view) {
        ((MainActivity) getContext()).switchToPage(18, null, R.string.app_name);
    }

    @Override
    public void onItemRemoves(int id) {
        RealmResults<CartModel> results = realm.where(CartModel.class).equalTo("id", id).findAll();
        realm.beginTransaction();
        results.deleteAllFromRealm();
        realm.commitTransaction();

        cartNumber();
        cartAdapter.notifyDataSetChanged();
    }
}
