package com.sadek.ekatapp.interfaces;

import com.sadek.ekatapp.model.response.LoginResponse;
import com.sadek.ekatapp.model.response.SignupResponse;

public interface LoginInterface {

    void showProgress(boolean show);

    void onErorr(String response);

    void onSuccess(LoginResponse response);
}
