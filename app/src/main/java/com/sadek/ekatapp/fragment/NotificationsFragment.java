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
import com.sadek.ekatapp.adapter.NotificationsAdapter;
import com.sadek.ekatapp.adapter.OrderAdapter;
import com.sadek.ekatapp.model.NotificationsModel;
import com.sadek.ekatapp.model.OrderModel;
import com.sadek.ekatapp.utils.Common;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class NotificationsFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.tabTxt)
    TextView tabTxt;
    @BindView(R.id.notification_recycler)
    RecyclerView notification_recycler;


    NotificationsAdapter notificationsAdapter;
    List<NotificationsModel> notificationsModelList;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
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
        tabTxt.setText(R.string.notifications);

        notificationsModelList = new ArrayList<>();

        setSliderData();


        //notification_recycler
        final RecyclerView.LayoutManager mLayoutManager_notifications = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        notification_recycler.setLayoutManager(mLayoutManager_notifications);
        notificationsAdapter = new NotificationsAdapter(notificationsModelList, getContext());
        notification_recycler.setAdapter(notificationsAdapter);


       }

    private void setSliderData() {

        notificationsModelList.add(new NotificationsModel("New Collection Arrived"));
    }


}
