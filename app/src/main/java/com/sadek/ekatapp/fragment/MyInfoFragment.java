package com.sadek.ekatapp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rilixtech.CountryCodePicker;
import com.sadek.ekatapp.R;
import com.sadek.ekatapp.adapter.OrderAdapter;
import com.sadek.ekatapp.model.OrderModel;
import com.sadek.ekatapp.utils.Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MyInfoFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.ccp)
    CountryCodePicker ccp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {

        Typeface typeFace=Typeface.createFromAsset(getContext().getAssets(),"fonts/Tajawal-Bold.ttf");
        ccp.setTypeFace(typeFace);
       }



}
