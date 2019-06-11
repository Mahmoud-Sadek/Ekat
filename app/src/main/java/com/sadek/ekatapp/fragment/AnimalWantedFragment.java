package com.sadek.ekatapp.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rilixtech.CountryCodePicker;
import com.sadek.ekatapp.R;
import com.sadek.ekatapp.adapter.ImageAdapter;
import com.sadek.ekatapp.model.ImageModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;


public class AnimalWantedFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.upload_images_recycler)
    RecyclerView upload_images_recycler;

    @BindView(R.id.tabTxt)
    TextView tabTxt;


    @BindView(R.id.ccp)
    CountryCodePicker ccp;

    ImageAdapter imageAdapter;
    List<ImageModel> imageModelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_animal_wanted, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initUI();
    }

    private void initUI() {
        tabTxt.setText(R.string.add_ads_free);

        imageModelList = new ArrayList<>();
        //upload_images_recycler
        final RecyclerView.LayoutManager mLayoutManager_upload_images = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        upload_images_recycler.setLayoutManager(mLayoutManager_upload_images);
        imageAdapter = new ImageAdapter(imageModelList, getContext());
        upload_images_recycler.setAdapter(imageAdapter);

        Typeface typeFace=Typeface.createFromAsset(getContext().getAssets(),"fonts/BCN_Medium.otf");
        ccp.setTypeFace(typeFace);

    }
    //app_bar_back_btn
    @OnClick(R.id.app_bar_back_btn)
    void app_bar_back_btn(View view) {
        getActivity().onBackPressed();
    }

    //add_advert_upload_photo
    @OnClick(R.id.add_advert_upload_photo)
    void add_advert_upload_photo(View view) {
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    2000);
        } else {
            startGallery();
        }
    }

    private void startGallery() {
        Intent cameraIntent = new Intent(Intent.ACTION_GET_CONTENT);
        cameraIntent.setType("image/*");
        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 1000);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super method removed
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                Uri returnUri = data.getData();
                Bitmap bitmapImage = null;
                try {
                    bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageModelList.add(new ImageModel(returnUri));
                imageAdapter.notifyDataSetChanged();
            }
        }
    }



}
