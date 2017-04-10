package com.example.eladron.androidappdevforbeginners;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by eladron on 16/01/2017.
 */

public class App37_HorizontalScrollViewGalleryAdapter extends BaseAdapter {

    Context context;

    //constructor
    public App37_HorizontalScrollViewGalleryAdapter(Context context) {
        this.context = context;
    }

    //implementing abstract methods
    @Override
    public int getCount() {
        return Hero.heroImages.length;
    }

    @Override
    public Object getItem(int position) {
        return Hero.heroImages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView = new ImageView(context);
        imgView.setImageResource(Hero.heroImages[position]);
        imgView.setLayoutParams(new GridView.LayoutParams(400, 400));
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        imgView.setPadding(100, 100, 100, 100);
        return imgView;

    }
}
