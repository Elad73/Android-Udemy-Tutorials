package com.example.eladron.androidappdevforbeginners;

import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by eladron on 17/01/2017.
 */

public class Utils {

    static void LetsSetLayoutParamsForImageView(ImageView imageView, int width, int height) {
        imageView.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }
}
