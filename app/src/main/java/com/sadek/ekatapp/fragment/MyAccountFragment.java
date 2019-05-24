package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
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


public class MyAccountFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.my_account_info_image)
    ImageView my_account_info_image;
    @BindView(R.id.my_account_info_txt)
    TextView my_account_info_txt;
    @BindView(R.id.tabTxt)
    TextView tabTxt;
    @BindView(R.id.my_account_order_image)
    ImageView my_account_order_image;
    @BindView(R.id.my_account_order_txt)
    TextView my_account_order_txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        tabTxt.setText(R.string.profile);

        switchToPage(1, null, R.string.app_name);
    }

    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }

    //my_account_orders
    @OnClick(R.id.my_account_orders)
    void my_account_orders(View view) {
        switchToPage(1, null, R.string.app_name);
        my_account_info_image.setColorFilter(ContextCompat.getColor(getContext(), R.color.disableItem));
        my_account_info_txt.setTextColor(getContext().getResources().getColor(R.color.disableItem));

        my_account_order_image.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        my_account_order_txt.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
    }

    //my_account_info
    @OnClick(R.id.my_account_info)
    void my_account_info(View view) {
        switchToPage(2, null, R.string.app_name);

        my_account_info_image.setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        my_account_info_txt.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));

        my_account_order_image.setColorFilter(ContextCompat.getColor(getContext(), R.color.disableItem));
        my_account_order_txt.setTextColor(getContext().getResources().getColor(R.color.disableItem));
    }

    public void switchToPage(int page, Bundle bundle, int nameId) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.abc_fade_in,
                R.anim.abc_fade_out);

        String name = getResources().getString(nameId);
        Fragment nextFragment;
        switch (page) {

            case 1:
                nextFragment = new MyOrdersFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.my_account_container, nextFragment, name);
                transaction.commit();
                break;

            case 2:
                nextFragment = new MyInfoFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.my_account_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
        }
    }


}
