package com.sadek.ekatapp.utils;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class Common {


    public static final String ORDER_STATUS_COMPLETED = "0";
    public static final String ORDER_STATUS_PROGRESS = "1";
    public static final String ORDER_STATUS_CANCELED = "2";

    public static void autoScrollRecycler(final RecyclerView recyclerView, final int dataListSize){
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
}
