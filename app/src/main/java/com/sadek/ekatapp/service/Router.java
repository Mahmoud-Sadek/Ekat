package com.sadek.ekatapp.service;

import com.sadek.ekatapp.model.body.LoginBody;
import com.sadek.ekatapp.model.body.SignupBody;
import com.sadek.ekatapp.model.response.LoginResponse;
import com.sadek.ekatapp.model.response.SignupResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mahmoud Sadek on 1/11/2019.
 */

public interface Router {
    //Create Account
    @POST("wc/v3/customers")
    Call<SignupResponse> getCreateAccountResponse(@Body SignupBody signupBody,@Query ("consumer_key")String consumer_key,@Query ("consumer_secret")String consumer_secret,@Query ("lang")String lang);


    //login
    @POST("jwt-auth/v1/token")
    Call<LoginResponse> getLoginResponse(@Body LoginBody loginBody);


}
