package com.sadek.ekatapp.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import com.sadek.ekatapp.R;
import com.sadek.ekatapp.activity.MainActivity;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import cn.refactor.lib.colordialog.PromptDialog;

public class Common {


    public static final String ORDER_STATUS_COMPLETED = "0";
    public static final String ORDER_STATUS_PROGRESS = "1";
    public static final String ORDER_STATUS_CANCELED = "2";
    public static final String Language = "Language";
    public static final String userID = "userID";
    public static final String userPassword ="userPassword";

    public static void autoScrollRecycler(final RecyclerView recyclerView, final int dataListSize) {
        final int speedScroll = 4000;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                if (recyclerView != null) {
                    if (count > dataListSize + 1) {
                        count = 0;
                    }
                    if (count <= dataListSize + 1) {
                        recyclerView.scrollToPosition(count);
                        count++;
                        handler.postDelayed(this, speedScroll);
                    }
                }
            }
        };
        handler.postDelayed(runnable, speedScroll);
    }

    public static void showErrorDialog(Activity activity, int title, int message) {
        new FancyAlertDialog.Builder(activity)
                .setTitle(activity.getString(title))
                .setBackgroundColor(Color.parseColor("#ffff4444"))  //Don't pass R.color.colorvalue
                .setMessage(activity.getString(message))
//                .setNegativeBtnText("Cancel")
                .setPositiveBtnBackground(Color.parseColor("#ffff4444"))  //Don't pass R.color.colorvalue
                .setPositiveBtnText(activity.getString(R.string.ok))
//                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                .setAnimation(Animation.POP)
                .isCancellable(true)
                .setIcon(R.drawable.ic_error_outline_black_24dp, Icon.Visible)
                .OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
//                        Toast.makeText(getApplicationContext(),"Rate",Toast.LENGTH_SHORT).show();

                    }
                })
//                .OnNegativeClicked(new FancyAlertDialogListener() {
//                    @Override
//                    public void OnClick() {
////                        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
//                    }
//                })
                .build();
    }

    public static void showErrorDialog2(final Activity activity, final int type, int title, int message) {
        PromptDialog dialog = new PromptDialog(activity)
                .setDialogType(type)
                .setAnimationEnable(true)
                .setTitleText(activity.getString(title))
                .setContentText(activity.getString(message))
                .setPositiveListener(activity.getString(R.string.ok), new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog dialog) {
                        if (type == PromptDialog.DIALOG_TYPE_SUCCESS)
//                            ((MainActivity) activity).onBackPressed();
                            ((MainActivity) activity).switchToPage(1, null, R.string.app_name);
                        dialog.dismiss();
                    }
                });
        dialog.setCancelable(false);
        dialog.show();
    }


}
