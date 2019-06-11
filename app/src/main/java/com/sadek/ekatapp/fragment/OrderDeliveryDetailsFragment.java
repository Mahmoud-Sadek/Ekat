package com.sadek.ekatapp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rilixtech.CountryCodePicker;
import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class OrderDeliveryDetailsFragment extends Fragment {

    Unbinder unbinder;


    @BindView(R.id.ccp)
    CountryCodePicker ccp;

    @BindView(R.id.tabTxt)
    TextView tabTxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order_delivery_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        tabTxt.setText(R.string.order_delivery_details);


        Typeface typeFace=Typeface.createFromAsset(getContext().getAssets(),"fonts/BCN_Medium.otf");
        ccp.setTypeFace(typeFace);
       }


    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }


    //confirm_btn
    @OnClick(R.id.confirm_btn)
    void confirm_btn(View view) {
        ((MainActivity)getContext()).switchToPage(19, null, R.string.app_name);

    }



}
