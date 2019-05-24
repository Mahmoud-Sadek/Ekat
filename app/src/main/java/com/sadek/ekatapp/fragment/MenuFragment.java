package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.MenuAdapter;
import com.sadek.ekatapp.model.MenuModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MenuFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.menu_recycler)
    RecyclerView menu_recycler;


    MenuAdapter menuModelAdapter;
    List<MenuModel> menuModelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.include_menu_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        menuModelList = new ArrayList<>();

        menuModelList.add(new MenuModel("الحيوانات الاليفة"));
        menuModelList.add(new MenuModel("الحيوانات والطيور البرية"));
        menuModelList.add(new MenuModel("طيور الزينة"));
        menuModelList.add(new MenuModel("الماشية"));
        menuModelList.add(new MenuModel("طعام للحيوانات والطيور"));
        menuModelList.add(new MenuModel("مستلزمات الحيوانات والطيور"));

        //menu_recycler
        final RecyclerView.LayoutManager mLayoutManager_menu = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        menu_recycler.setLayoutManager(mLayoutManager_menu);
        menuModelAdapter = new MenuAdapter(menuModelList, getContext());
        menu_recycler.setAdapter(menuModelAdapter);


    }

    //menu_my_account_btn
    @OnClick(R.id.menu_my_account_btn)
    void menu_my_account_btn(View view) {
        ((MainActivity) getContext()).switchToPage(8, null, R.string.app_name);
    }

    //menu_home_btn
    @OnClick(R.id.menu_home_btn)
    void menu_home_btn(View view) {
        getActivity().onBackPressed();
    }

    //menu_add_advertisement_btn
    @OnClick(R.id.menu_add_advertisement_btn)
    void menu_add_advertisement_btn(View view) {
        ((MainActivity) getContext()).switchToPage(10, null, R.string.app_name);
    }

    //menu_order_animal_btn
    @OnClick(R.id.menu_order_animal_btn)
    void menu_order_animal_btn(View view) {
        ((MainActivity) getContext()).switchToPage(11, null, R.string.app_name);
    }


    //menu_logout_btn
    @OnClick(R.id.menu_logout_btn)
    void menu_logout_btn(View view) {
        ((MainActivity) getContext()).switchToPage(4, null, R.string.app_name);
    }


}
