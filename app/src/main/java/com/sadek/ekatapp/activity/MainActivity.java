package com.sadek.ekatapp.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.fragment.AddAdvertisementFragment;
import com.sadek.ekatapp.fragment.AnimalWantedFragment;
import com.sadek.ekatapp.fragment.CartFragment;
import com.sadek.ekatapp.fragment.CategoryDetailsFragment;
import com.sadek.ekatapp.fragment.ForgetConfirmPhoneCodeFragment;
import com.sadek.ekatapp.fragment.ForgetPasswordCodeFragment;
import com.sadek.ekatapp.fragment.ForgetPasswordEmailFragment;
import com.sadek.ekatapp.fragment.ForgetPasswordFinalFragment;
import com.sadek.ekatapp.fragment.LoginFragment;
import com.sadek.ekatapp.fragment.MainFragment;
import com.sadek.ekatapp.fragment.MenuFragment;
import com.sadek.ekatapp.fragment.MyAccountFragment;
import com.sadek.ekatapp.fragment.NotificationsFragment;
import com.sadek.ekatapp.fragment.OrderDeliveryDetailsFragment;
import com.sadek.ekatapp.fragment.OrderDetailsFragment;
import com.sadek.ekatapp.fragment.PaymentMethodFragment;
import com.sadek.ekatapp.fragment.PrivacyPolicyFragment;
import com.sadek.ekatapp.fragment.ProductDetailsFragment;
import com.sadek.ekatapp.fragment.RegisterFragment;
import com.sadek.ekatapp.fragment.SubCategoryFragment;

public class MainActivity extends BaseActitvty {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchToPage(1, null, R.string.app_name);
    }

    public void switchToPage(int page, Bundle bundle, int nameId) {

        FragmentTransaction transaction = getTransaction();
        String name = getResources().getString(nameId);
        Fragment nextFragment;

        transaction.setCustomAnimations(R.anim.side_in, R.anim.side_out);
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        switch (page) {

            case 1:
//                getWindow().setStatusBarColor(getResources().getColor(R.color.textprimaryColor));
                nextFragment = new MainFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.commit();
                break;

            case 2:
//                getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
                nextFragment = new ProductDetailsFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;

            case 3:
//                getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
                nextFragment = new CategoryDetailsFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 4:
                nextFragment = new LoginFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 5:
                nextFragment = new RegisterFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 6:
                nextFragment = new PrivacyPolicyFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 7:
                getWindow().setStatusBarColor(getResources().getColor(R.color.barBackground));
                nextFragment = new MenuFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 8:
                nextFragment = new MyAccountFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 9:
                nextFragment = new OrderDetailsFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 10:
                nextFragment = new AddAdvertisementFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 11:
                nextFragment = new AnimalWantedFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 12:
                nextFragment = new ForgetPasswordEmailFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 13:
                nextFragment = new ForgetPasswordCodeFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 14:
                nextFragment = new ForgetPasswordFinalFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 15:
                nextFragment = new NotificationsFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 16:
                nextFragment = new CartFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 17:
                nextFragment = new SubCategoryFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 18:
                nextFragment = new OrderDeliveryDetailsFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 19:
                nextFragment = new ForgetConfirmPhoneCodeFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
            case 20:
                nextFragment = new PaymentMethodFragment();
                nextFragment.setArguments(bundle);
                transaction.replace(R.id.head_container, nextFragment, name);
                transaction.addToBackStack(name);
                transaction.commit();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getTransaction().setCustomAnimations(R.anim.side_in, R.anim.side_out);
        overridePendingTransition(R.anim.side_in, R.anim.side_out);
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.head_container);
//        if (f instanceof ProductDetailsFragment) {
//            getWindow().setStatusBarColor(getResources().getColor(android.R.color.white));
//        }else
            if (f instanceof MenuFragment) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.barBackground));
        }else  {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
}
