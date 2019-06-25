package com.sadek.ekatapp.presentsers;

import android.content.Context;
import android.provider.Settings;

import com.sadek.ekatapp.interfaces.LoginInterface;
import com.sadek.ekatapp.interfaces.SignupInterface;
import com.sadek.ekatapp.model.body.LoginBody;
import com.sadek.ekatapp.model.body.SignupBody;
import com.sadek.ekatapp.model.response.LoginResponse;
import com.sadek.ekatapp.model.response.SignupResponse;
import com.sadek.ekatapp.service.ServiceBuilder;
import com.sadek.ekatapp.utils.Common;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private final String TAG = "signup";

    public static void sendLogin(Context context, LoginBody request, final LoginInterface loginInterface) {
        Paper.init(context);
        loginInterface.showProgress(true);


//        request.setLanguage("English");
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
//        request.setDeviceid(android_id);

        String lang = Paper.book().read(Common.Language);

        Call<LoginResponse> myCall = ServiceBuilder.getRouter(context).getLoginResponse(request);
        myCall.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                loginInterface.showProgress(false);
                if (response.isSuccessful()) {
                    loginInterface.onSuccess(response.body());
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                JSONObject jsonObject = new JSONObject(response.errorBody().string());
//                String ErrorMessage = jsonObject.getString("message");
                loginInterface.showProgress(false);
                loginInterface.onErorr(t.getMessage());
            }
        });
    }



}
