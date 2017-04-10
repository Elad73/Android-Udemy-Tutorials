package com.example.eladron.androidappdevforbeginners;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by eladron on 16/01/2017.
 */

public class App36_GridViewAdapter extends BaseAdapter {

    int[] animalImages = {R.drawable.app34_bear, R.drawable.app34_bird, R.drawable.app34_cat, R.drawable.app34_cow, R.drawable.app34_dolphin,
            R.drawable.app34_fish, R.drawable.app34_fox, R.drawable.app34_horse, R.drawable.app34_lion, R.drawable.app34_tiger, R.drawable.app34_bear, R.drawable.app34_bird, R.drawable.app34_cat, R.drawable.app34_cow, R.drawable.app34_dolphin,
            R.drawable.app34_fish, R.drawable.app34_fox, R.drawable.app34_horse, R.drawable.app34_lion, R.drawable.app34_tiger};

    String[] animalNames = {"Bear", "Bird", "Cat", "Cow", "Dolphin", "Fish", "Fox", "Horse", "Lion", "Tiger",
                            "Bear", "Bird", "Cat", "Cow", "Dolphin", "Fish", "Fox", "Horse", "Lion", "Tiger"};

    Context context;

    //constructors
    public App36_GridViewAdapter(Context context) {

        this.context = context;
    }

    //abstract methods implementations
    @Override
    public int getCount() {
        return animalImages.length;
    }

    @Override
    public Object getItem(int position) {
        return animalImages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ImageView imgView = new ImageView(context);
        imgView.setImageResource(animalImages[position]);
        imgView.setLayoutParams(new GridView.LayoutParams(200,200));
        imgView.setPadding(10,10,10,10);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "The Name of the Animal is: " + animalNames[position], Toast.LENGTH_SHORT).show();
            }
        });

        return imgView;
    }
}
