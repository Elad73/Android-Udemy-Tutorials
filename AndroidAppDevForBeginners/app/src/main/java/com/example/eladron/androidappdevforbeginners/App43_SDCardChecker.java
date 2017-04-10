package com.example.eladron.androidappdevforbeginners;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

/**
 * Created by eladron on 23/01/2017.
 */

public class App43_SDCardChecker {

    public static void checkWeatherExternalStorageAvailableOrNot(Context context) {

        boolean isExternaStorageAvailable = false;
        boolean isExternalStorageWriteable = false;

        String state = Environment.getExternalStorageState();

        switch (state) {

            case Environment.MEDIA_MOUNTED:
                //we can read and write the media
                isExternalStorageWriteable = isExternaStorageAvailable = true;
                Toast.makeText(context, "read and write", Toast.LENGTH_LONG).show();
                break;
            case Environment.MEDIA_MOUNTED_READ_ONLY:
                //we can only read the media
                isExternaStorageAvailable = true;
                isExternalStorageWriteable = false;
                Toast.makeText(context, "read only", Toast.LENGTH_LONG).show();
                break;
            default:
                //we can neither read nor write
                isExternalStorageWriteable = isExternaStorageAvailable = false;
                Toast.makeText(context, "neither read nor write", Toast.LENGTH_LONG).show();
                break;


        }
    }
}
