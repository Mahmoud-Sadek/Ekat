package com.sadek.ekatapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.sadek.ekatapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class PaymentMethodFragment extends Fragment {

    Unbinder unbinder;


    @BindView(R.id.payment_radio)
    RadioGroup payment_radio;

    @BindView(R.id.pay_on_delivery_desc)
    TextView pay_on_delivery_desc;
    @BindView(R.id.pay_by_visa_desc)
    TextView pay_by_visa_desc;
    @BindView(R.id.pay_by_bank_desc)
    TextView pay_by_bank_desc;
    @BindView(R.id.tabTxt)
    TextView tabTxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment_method, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        tabTxt.setText(R.string.payment_method);

        payment_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.pay_on_delivery_radio){
                    pay_on_delivery_desc.setVisibility(View.VISIBLE);
                    pay_by_bank_desc.setVisibility(View.INVISIBLE);
                    pay_by_visa_desc.setVisibility(View.INVISIBLE);
                }else if (checkedId == R.id.pay_by_bank_radio){
                    pay_on_delivery_desc.setVisibility(View.INVISIBLE);
                    pay_by_bank_desc.setVisibility(View.VISIBLE);
                    pay_by_visa_desc.setVisibility(View.INVISIBLE);
                }else  if (checkedId == R.id.pay_by_visa_radio){
                    pay_on_delivery_desc.setVisibility(View.INVISIBLE);
                    pay_by_bank_desc.setVisibility(View.INVISIBLE);
                    pay_by_visa_desc.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }


}
