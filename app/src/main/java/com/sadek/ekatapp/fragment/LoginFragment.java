package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
import cn.refactor.lib.colordialog.PromptDialog;


public class LoginFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.login_email_txt)
    EditText login_email_txt;
    @BindView(R.id.login_password_txt)
    EditText login_password_txt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {

    }

    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }


    //login_btn
    @OnClick(R.id.login_btn)
    void login_btn(View view) {
        if (!validate())
            return;
        getActivity().onBackPressed();
    }

    //register_btn
    @OnClick(R.id.register_btn)
    void register_btn(View view) {
        ((MainActivity)getContext()).switchToPage(5, null, R.string.app_name);
    }

    //login_forget_password
    @OnClick(R.id.login_forget_password)
    void login_forget_password(View view) {
        ((MainActivity)getContext()).switchToPage(12, null, R.string.app_name);
    }


    private Boolean validate() {
        login_password_txt.setError(null);
        login_email_txt.setError(null);

        String email = login_email_txt.getText().toString();
        String pass = login_password_txt.getText().toString();
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            login_email_txt.setError(getString(R.string.enter_valid_email));
            Common.showErrorDialog2(getActivity(),PromptDialog.DIALOG_TYPE_WRONG, R.string.error, R.string.enter_valid_email);
            return false;
        } else if (pass.isEmpty() || pass.length() < 6) {
            login_password_txt.setError(getString(R.string.enter_valid_password));
            Common.showErrorDialog(getActivity(), R.string.error, R.string.enter_valid_password);
            return false;
        }
        return true;

    }
}
