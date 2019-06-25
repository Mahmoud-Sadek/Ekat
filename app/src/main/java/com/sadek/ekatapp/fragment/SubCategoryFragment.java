package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.CategoryAdapter;
import com.sadek.ekatapp.model.CartModel;
import com.sadek.ekatapp.model.MainCategoriesModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.realm.Realm;
import io.realm.RealmResults;


public class SubCategoryFragment extends Fragment {

    Unbinder unbinder;


    @BindView(R.id.app_bar_share_btn)
    ImageView app_bar_share_btn;

    @BindView(R.id.tabTxt)
    TextView tabTxt;

    @BindView(R.id.cart_number)
    TextView cart_number;

    @BindView(R.id.sub_category_recycler)
    RecyclerView sub_category_recycler;

    CategoryAdapter categoryAdapter;
    List<MainCategoriesModel> categoriesModels;

    Realm realm;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sub_category, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        realm = Realm.getDefaultInstance();
        initUI();
    }


    private void initUI() {
        tabTxt.setText("طيور زينة");
        app_bar_share_btn.setVisibility(View.GONE);

        categoriesModels = new ArrayList<>();

        setSliderData();

        //sub_category_recycler
        final RecyclerView.LayoutManager mLayoutManager_sub_category = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        sub_category_recycler.setLayoutManager(mLayoutManager_sub_category);
        categoryAdapter = new CategoryAdapter(categoriesModels, getContext());
        sub_category_recycler.setAdapter(categoryAdapter);

        if (cartNumber() == 0) {
            cart_number.setVisibility(View.GONE);
        } else {
            cart_number.setVisibility(View.VISIBLE);
            cart_number.setText(cartNumber() + "");
        }

    }

    private void setSliderData() {
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));
        categoriesModels.add(new MainCategoriesModel("https://www.ekat.ae/wp-content/uploads/2019/04/vet-aquadent-247x296.jpg", "كلاب"));


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

    public int cartNumber() {
        RealmResults<CartModel> results = realm.where(CartModel.class).findAll();
        return ((RealmResults) results).size();
    }
}
