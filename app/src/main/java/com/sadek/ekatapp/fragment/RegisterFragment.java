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

import com.rilixtech.Country;
import com.rilixtech.CountryCodePicker;
import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.sadek.ekatapp.adapter.NothingSelectedSpinnerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class RegisterFragment extends Fragment {

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
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
                if (position != 0)
                    register_city_txt_.setVisibility(View.GONE);
                else if (position == 1) {
                    register_city_spinner.setVisibility(View.VISIBLE);
                    register_city_txt.setVisibility(View.GONE);
                } else {
                    register_city_spinner.setVisibility(View.GONE);
                    register_city_txt.setVisibility(View.VISIBLE);


                    register_location_spinner.setVisibility(View.GONE);
                    register_location_txt.setVisibility(View.VISIBLE);
                }
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                if (!register_city_spinner.isSelected()) {
                    register_location_spinner.setVisibility(View.GONE);
                    register_location_txt.setVisibility(View.VISIBLE);
                }
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


        Typeface typeFace=Typeface.createFromAsset(getContext().getAssets(),"fonts/BCN_Medium.otf");
        ccp.setTypeFace(typeFace);
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
        getActivity().onBackPressed();
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
        return true;

    }
}
