package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewAnimator;
import android.widget.ViewFlipper;

/**
 * Created by eladron on 17/01/2017.
 */

public class App39_FlipImageActivity extends AppCompatActivity implements View.OnClickListener{


    ViewFlipper viewFlipper;
    ImageButton btnNext;
    ImageButton btnPrev;
    ViewAnimator viewAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app39_filp_image);


        btnNext = (ImageButton) findViewById(R.id.btnNext);
        btnPrev = (ImageButton) findViewById(R.id.btnPrev);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);

        letsAddTheImagesToTheViewFlipper(viewFlipper);
        letsAddTheImagesToTheViewAnimator(viewAnimator);

        useAnimationForViewFlipper(viewFlipper);
        useAnimationForViewFlipper(viewAnimator);

        btnNext.setOnClickListener(App39_FlipImageActivity.this);
        btnPrev.setOnClickListener(App39_FlipImageActivity.this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnNext:
                viewFlipper.showNext();
                viewAnimator.showNext();
                break;
            case R.id.btnPrev:
                viewFlipper.showPrevious();
                viewAnimator.showPrevious();
                break;
        }

    }

    private void letsAddTheImagesToTheViewAnimator(ViewAnimator viewAnimator) {
        for (int index = 0; index < DragonImages.dragonImages.length; index++) {
            ImageView imgView = new ImageView(App39_FlipImageActivity.this);
            imgView.setImageResource(DragonImages.dragonImages[index]);
            Utils.LetsSetLayoutParamsForImageView(imgView, 1000, 1000);
            imgView.setPadding(100, 100, 100, 100);
            viewAnimator.addView(imgView);
        }
    }

    private void letsAddTheImagesToTheViewFlipper(ViewFlipper viewFlipper) {
        for (int index = 0; index < DragonImages.dragonImages.length; index++) {
            ImageView imgView = new ImageView(App39_FlipImageActivity.this);
            imgView.setImageResource(DragonImages.dragonImages[index]);
            Utils.LetsSetLayoutParamsForImageView(imgView, 1000, 1000);
            imgView.setPadding(100, 100, 100, 100);
            viewFlipper.addView(imgView);
        }
    }

    private void useAnimationForViewFlipper(ViewFlipper viewFlipper) {
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(App39_FlipImageActivity.this, android.R.anim.slide_in_left));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(App39_FlipImageActivity.this, android.R.anim.slide_out_right));
    }

    private void useAnimationForViewFlipper(ViewAnimator viewAnimator) {
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(App39_FlipImageActivity.this, android.R.anim.fade_in));
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(App39_FlipImageActivity.this, android.R.anim.fade_out));
    }
}
