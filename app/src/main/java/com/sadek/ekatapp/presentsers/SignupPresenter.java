package com.sadek.ekatapp.presentsers;

import android.content.Context;
import android.provider.Settings;

import com.sadek.ekatapp.interfaces.SignupInterface;
import com.sadek.ekatapp.model.body.SignupBody;
import com.sadek.ekatapp.model.response.SignupResponse;
import com.sadek.ekatapp.service.CCallback;
import com.sadek.ekatapp.service.ServiceBuilder;
import com.sadek.ekatapp.utils.Common;

import org.json.JSONObject;

import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupPresenter {
    private final String TAG = "signup";

    public static void sendSignup(Context context, SignupBody request, final SignupInterface signupInterface) {
        Paper.init(context);
        signupInterface.showProgress(true);


//        request.setLanguage("English");
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
//        request.setDeviceid(android_id);

        String lang = Paper.book().read(Common.Language);

        Call<SignupResponse> myCall = ServiceBuilder.getRouter(context).getCreateAccountResponse(request,"ck_9d1296652958a3209e71c50839b27300a38cb174","cs_88afda5fc025c1afd449cdc5ab84055da4d8f3e9",lang);
        myCall.enqueue(new Callback<SignupResponse>() {

//            @Override
//            public void onErrorBadRequest(String response) {
//                signupInterface.showProgress(false);
//                signupInterface.onErorr(response);
//            }
//
//            @Override
//            public void onErrorUnauthorized(String response) {
//                signupInterface.showProgress(false);
//                signupInterface.onErorr(response);
//            }

            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                signupInterface.showProgress(false);
                if (response.isSuccessful()) {
                    signupInterface.onSignupSuccess(response.body());
                }

            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
//                JSONObject jsonObject = new JSONObject(response.errorBody().string());
//                String ErrorMessage = jsonObject.getString("message");
                signupInterface.showProgress(false);
                signupInterface.onErorr(t.getMessage());
            }
        });
    }



}
