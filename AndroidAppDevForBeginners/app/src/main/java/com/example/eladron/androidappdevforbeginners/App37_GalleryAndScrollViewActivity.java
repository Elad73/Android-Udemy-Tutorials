package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by eladron on 16/01/2017.
 */

public class App37_GalleryAndScrollViewActivity extends AppCompatActivity {

    GridView gridView;

    LinearLayout linearLayoutHorizontal;
    ImageView imgHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app37_gallery_and_scrollview_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gridView = (GridView) findViewById(R.id.gridViewImages);
        App37_HorizontalScrollViewGalleryAdapter adapter = new App37_HorizontalScrollViewGalleryAdapter(App37_GalleryAndScrollViewActivity.this);
        gridView.setAdapter(adapter);

        linearLayoutHorizontal =  (LinearLayout) findViewById(R.id.linearLayoutHorizontal);
        imgHero = (ImageView) findViewById(R.id.imgHero);

        for (int index = 0; index < Hero.heroImages.length; index++) {
            final int i = index;
            ImageView imgView= new ImageView(App37_GalleryAndScrollViewActivity.this);
            imgView.setImageResource(Hero.heroImages[index]);
            letsSetlayoutParamsForImageView(imgView);
            imgView.setPadding(100, 100, 100, 100);
            imgView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgHero.setImageResource(Hero.heroImages[i]);
                    letsSetlayoutParamsForImageView(imgHero);
                    Toast.makeText(App37_GalleryAndScrollViewActivity.this, "This is " + Hero.heroNames[i], Toast.LENGTH_LONG).show();
                }
            });
            linearLayoutHorizontal.addView(imgView);
        }


    }

    public void letsSetlayoutParamsForImageView(ImageView imgView) {
        imgView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
    }
}
