package com.sadek.ekatapp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.rilixtech.CountryCodePicker;
import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.NothingSelectedSpinnerAdapter;
import com.sadek.ekatapp.interfaces.SignupInterface;
import com.sadek.ekatapp.model.body.BillingEntity;
import com.sadek.ekatapp.model.body.ShippingEntity;
import com.sadek.ekatapp.model.body.SignupBody;
import com.sadek.ekatapp.model.response.SignupResponse;
import com.sadek.ekatapp.presentsers.SignupPresenter;
import com.sadek.ekatapp.utils.Common;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.refactor.lib.colordialog.PromptDialog;
import io.paperdb.Paper;


public class RegisterFragment extends Fragment implements SignupInterface {

    Unbinder unbinder;

    @BindView(R.id.register_name_txt)
    EditText register_name_txt;
    @BindView(R.id.register_email_txt)
    EditText register_email_txt;
    @BindView(R.id.register_password_txt)
    EditText register_password_txt;
    @BindView(R.id.register_phone_txt)
    EditText register_phone_txt;
    @BindView(R.id.ccp)
    CountryCodePicker ccp;
    @BindView(R.id.register_country_spinner)
    Spinner register_country_spinner;
    @BindView(R.id.register_city_spinner)
    Spinner register_city_spinner;
    @BindView(R.id.register_city_txt)
    EditText register_city_txt;
    @BindView(R.id.register_city_txt_)
    TextView register_city_txt_;
    @BindView(R.id.register_location_spinner)
    Spinner register_location_spinner;
    @BindView(R.id.register_location_txt)
    EditText register_location_txt;
    @BindView(R.id.register_location_txt_)
    TextView register_location_txt_;
    @BindView(R.id.register_confirm_checkbox)
    CheckBox register_confirm_checkbox;

    String country, city, region;
    SignupBody request;
    public static KProgressHUD dialog = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        dialog = new KProgressHUD(getContext());
        Paper.init(getContext());
        initUI();
    }

    private void initUI() {

        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(getContext(), R.array.country_array, android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        register_country_spinner.setPrompt(getString(R.string.country));

        register_country_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapterCountry,
                        R.layout.country_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        getContext()));
        register_country_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (position != 0)
//                    register_city_txt_.setVisibility(View.GONE);
//                else
                if (id == 0) {
                    register_city_spinner.setVisibility(View.VISIBLE);
                    register_city_txt.setVisibility(View.GONE);
                } else if (id <= 1) {
                    register_city_spinner.setVisibility(View.GONE);
                    register_city_txt.setVisibility(View.VISIBLE);


                    register_location_spinner.setVisibility(View.GONE);
                    register_location_txt.setVisibility(View.VISIBLE);
                }
                if (register_country_spinner.getSelectedItem() != null)
                    country = register_country_spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ArrayAdapter<CharSequence> adapterCity = ArrayAdapter.createFromResource(getContext(), R.array.city_array, android.R.layout.simple_spinner_item);
        adapterCity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        register_city_spinner.setPrompt(getString(R.string.city));

        register_city_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapterCity,
                        R.layout.city_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        getContext()));


        register_city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    register_location_txt_.setVisibility(View.GONE);
                    register_location_spinner.setVisibility(View.VISIBLE);
                    register_location_txt.setVisibility(View.GONE);
                }

                if (register_city_spinner.getSelectedItem() != null)
                    city = register_city_spinner.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (!register_city_spinner.isSelected()) {
                    register_location_spinner.setVisibility(View.GONE);
                    register_location_txt.setVisibility(View.VISIBLE);
                }

                if (register_location_spinner.getSelectedItem() != null)
                    region = register_location_spinner.getSelectedItem().toString();
            }
        });

        ArrayAdapter<CharSequence> adapterLocation = ArrayAdapter.createFromResource(getContext(), R.array.location_array, android.R.layout.simple_spinner_item);
        adapterLocation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        register_location_spinner.setPrompt(getString(R.string.city));

        register_location_spinner.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        adapterLocation,
                        R.layout.location_spinner_row_nothing_selected,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        getContext()));


        Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/Tajawal-Bold.ttf");
        ccp.setTypeFace(typeFace);
    }


    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }


    //register_city_txt_
    @OnClick(R.id.register_city_txt_)
    void register_city_txt_(View view) {
        Toast.makeText(getContext(), R.string.select_countrys, Toast.LENGTH_SHORT).show();
    }

    //register_city_txt_
    @OnClick(R.id.register_location_txt_)
    void register_location_txt_(View view) {
        Toast.makeText(getContext(), R.string.select_city, Toast.LENGTH_SHORT).show();
    }

    //login_btn
    @OnClick(R.id.login_btn)
    void login_btn(View view) {
        getActivity().onBackPressed();
    }

    //register_btn
    @OnClick(R.id.register_btn)
    void register_btn(View view) {
        if (!validate())
            return;

        SignupPresenter.sendSignup(getContext(), request, this);
    }

    //login_privacy_txt
    @OnClick(R.id.login_privacy_txt)
    void login_privacy_txt(View view) {
        ((MainActivity) getContext()).switchToPage(6, null, R.string.app_name);
    }


    private Boolean validate() {
        register_email_txt.setError(null);
        register_name_txt.setError(null);
        register_password_txt.setError(null);
        register_phone_txt.setError(null);

        String email = register_email_txt.getText().toString();
        String pass = register_password_txt.getText().toString();
        String name = register_name_txt.getText().toString();
        String phone = register_phone_txt.getText().toString();
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            register_email_txt.setError(getString(R.string.enter_valid_email));
            return false;
        } else if (pass.isEmpty() || pass.length() < 6) {
            register_password_txt.setError(getString(R.string.enter_valid_password));
            return false;
        } else if (name.isEmpty() || name.length() < 3) {
            register_name_txt.setError(getString(R.string.enter_valid_name));
            return false;
        } else if (phone.isEmpty() || phone.length() < 9) {
            register_phone_txt.setError(getString(R.string.enter_valid_phone));
            return false;
        } else if (!register_confirm_checkbox.isChecked()) {
//            register_phone_txt.setError(getString(R.string.enter_valid_phone));
            return false;
        }
        request = new SignupBody();
        request.setFirstName(name);
        request.setLastName(name);
        request.setUsername(name);
        request.setEmail(email);
        request.setPassword(pass);
        BillingEntity billingEntity = new BillingEntity();
        billingEntity.setEmail(email);
        billingEntity.setFirstName(name);
        billingEntity.setLastName(name);
        billingEntity.setPhone(phone);
        billingEntity.setCity(city);
        billingEntity.setCountry(country);
        billingEntity.setState(region);

        ShippingEntity shippingEntity = new ShippingEntity();
        shippingEntity.setFirstName(name);
        shippingEntity.setLastName(name);
        shippingEntity.setCountry(country);
        shippingEntity.setCity(city);
        shippingEntity.setState(region);

        request.setBilling(billingEntity);
        request.setShipping(shippingEntity);
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
        dialog.dismiss();
        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSignupSuccess(SignupResponse response) {
        dialog.dismiss();
        Paper.book().write(Common.userID, response.getId());

        Common.showErrorDialog2(getActivity(), PromptDialog.DIALOG_TYPE_SUCCESS, R.string.sucess, R.string.your_acount_susessfly_created);

    }
}
