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


public class ForgetPasswordEmailFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.forget_password_email_txt)
    EditText forget_password_email_txt;



    @BindView(R.id.tabTxt)
    TextView tabTxt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_forget_password_email, container, false);
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


    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }

    //forget_password_email_btn
    @OnClick(R.id.forget_password_email_btn)
    void forget_password_email_btn(View view) {
        if (!validate())
            return;
        ((MainActivity)getContext()).switchToPage(13, null, R.string.app_name);
    }



    private Boolean validate() {
        forget_password_email_txt.setError(null);

        String email = forget_password_email_txt.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            forget_password_email_txt.setError(getString(R.string.enter_valid_email));
            return false;
        }
        return true;

    }
}
