package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ForgetPasswordFinalFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.forget_password_pass_txt)
    EditText forget_password_pass_txt;
    @BindView(R.id.forget_password_confirm_pass_txt)
    EditText forget_password_confirm_pass_txt;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forget_password_final, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {

    }



    //forget_password_code_continue_btn
    @OnClick(R.id.forget_password_code_continue_btn)
    void forget_password_code_continue_btn(View view) {
        if (!validate())
            return;
        getActivity().onBackPressed();
    }

    private Boolean validate() {
        forget_password_pass_txt.setError(null);

        String pass = forget_password_pass_txt.getText().toString();
        String confPass = forget_password_confirm_pass_txt.getText().toString();

        if (pass.isEmpty() || pass.length() < 6) {
            forget_password_pass_txt.setError(getString(R.string.enter_valid_password));
            return false;
        }else if (confPass.isEmpty() || confPass.length() < 6 || !confPass.equals(pass)) {
            forget_password_confirm_pass_txt.setError(getString(R.string.enter_valid_password));
            return false;
        }
        return true;

    }
}
