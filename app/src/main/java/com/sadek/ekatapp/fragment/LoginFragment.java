package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.interfaces.LoginInterface;
import com.sadek.ekatapp.model.body.LoginBody;
import com.sadek.ekatapp.model.response.LoginResponse;
import com.sadek.ekatapp.presentsers.LoginPresenter;
import com.sadek.ekatapp.utils.Common;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.refactor.lib.colordialog.PromptDialog;
import io.paperdb.Paper;


public class LoginFragment extends Fragment implements LoginInterface {

    Unbinder unbinder;
    @BindView(R.id.login_email_txt)
    EditText login_email_txt;
    @BindView(R.id.login_password_txt)
    EditText login_password_txt;

    LoginBody request;

    public static KProgressHUD dialog = null;

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
        LoginPresenter.sendLogin(getContext(), request, this);
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
        request = new LoginBody();
        request.setPassword(pass);
        request.setUsername(email);
        return true;

    }


    @Override
    public void showProgress(boolean show) {
        if (show) {
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }

    @Override
    public void onErorr(String response) {

        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void onSuccess(LoginResponse response) {


        Paper.book().write(Common.userID, response.getToken());

        Paper.book().write(Common.userPassword, request.getPassword());
        getChildFragmentManager().popBackStack("tag", FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Common.showErrorDialog2(getActivity(), PromptDialog.DIALOG_TYPE_SUCCESS, R.string.sucess, R.string.your_acount_susessfly_Logedin);

    }
}
