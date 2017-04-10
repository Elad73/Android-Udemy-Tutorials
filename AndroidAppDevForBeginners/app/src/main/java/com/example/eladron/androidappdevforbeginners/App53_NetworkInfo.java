package com.example.eladron.androidappdevforbeginners;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by eladron on 12/02/2017.
 */

public class App53_NetworkInfo {

    public static int getNetworkStatus(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        android.net.NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo != null) {
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    return 1;
                case ConnectivityManager.TYPE_MOBILE:
                    return 0;
                default:
                    return 3;
            }
        }
        else { //the device is not connected to the internet at all.
            return 1000;
        }
    }
}
