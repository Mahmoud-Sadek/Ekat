package com.sadek.ekatapp.interfaces;

import com.sadek.ekatapp.model.response.SignupResponse;

public interface SignupInterface {

    void showProgress(boolean show);

    void onErorr(String response);

    void onSignupSuccess(SignupResponse response);
}
