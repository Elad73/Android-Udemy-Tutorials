package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

/**
 * Created by eladron on 16/01/2017.
 */

public class App38_ImageSwitcherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    LinearLayout linearLayoutHorizontal;
    ImageSwitcher imgSwitcher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app38_image_switcher_activity);

        linearLayoutHorizontal = (LinearLayout) findViewById(R.id.linearLayoutHorizontal);
        imgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);

        imgSwitcher.setFactory(App38_ImageSwitcherActivity.this);


        for (int index = 0; index < Hero.heroImages.length; index++) {
            final int i = index;
            ImageView imgView = new ImageView(App38_ImageSwitcherActivity.this);
            imgView.setImageResource(Hero.heroImages[index]);
            letsSetlayoutParamsForImageView(imgView);
            imgView.setPadding(100, 100, 100, 100);
            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgSwitcher.setImageResource(Hero.heroImages[i]);
                    Toast.makeText(App38_ImageSwitcherActivity.this, "This is " + Hero.heroNames[i], Toast.LENGTH_LONG).show();
                }
            });
            linearLayoutHorizontal.addView(imgView);
        }
    }

    public void letsSetlayoutParamsForImageView(ImageView imgView) {
        imgView.setLayoutParams(new LinearLayout.LayoutParams(1000, 1000));
    }

    @Override
    public View makeView() {
        ImageView imgView = new ImageView(App38_ImageSwitcherActivity.this);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        imgView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        imgSwitcher.setInAnimation(AnimationUtils.loadAnimation(App38_ImageSwitcherActivity.this, android.R.anim.slide_in_left));
        imgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(App38_ImageSwitcherActivity.this, android.R.anim.slide_out_right));

        return imgView;
    }
}
