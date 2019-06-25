package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ForgetConfirmPhoneCodeFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.confirm_phone_code_txt)
    EditText confirm_phone_code_txt;

    @BindView(R.id.tabTxt)
    TextView tabTxt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_confirm_phone_code, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        tabTxt.setText("");
    }



    //confirm_phone_code_continue_btn
    @OnClick(R.id.confirm_phone_code_continue_btn)
    void confirm_phone_code_continue_btn(View view) {
        if (!validate())
            return;
        ((MainActivity)getContext()).switchToPage(20, null, R.string.app_name);
    }
    //confirm_phone_code_resent_code_btn
    @OnClick(R.id.confirm_phone_code_resent_code_btn)
    void confirm_phone_code_resent_code_btn(View view) {
        ((MainActivity)getContext()).switchToPage(12, null, R.string.app_name);
    }

    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }



    private Boolean validate() {
        confirm_phone_code_txt.setError(null);

        String code = confirm_phone_code_txt.getText().toString();

        if (code.isEmpty() ) {
            confirm_phone_code_txt.setError(getString(R.string.enter_valid_code));
            return false;
        }
        return true;

    }

}
