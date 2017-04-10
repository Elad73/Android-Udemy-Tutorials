package com.example.eladron.androidappdevforbeginners;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by eladron on 09/01/2017.
 */

public class App34_CustomizedListViewAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;

    int[] animalImages = {R.drawable.app34_bear, R.drawable.app34_bird, R.drawable.app34_cat, R.drawable.app34_cow, R.drawable.app34_dolphin,
            R.drawable.app34_fish, R.drawable.app34_fox, R.drawable.app34_horse, R.drawable.app34_lion, R.drawable.app34_tiger};

    String[] animalNames = {"Bear", "Bird", "Cat", "Cow", "Dolphin", "Fish", "Fox", "Horse", "Lion", "Tiger"};
    int[] animalPower    = {200, 20, 50, 150, 50, 10, 70, 400, 250, 220};
    int[] animalSpeed    = {50, 80, 60, 10, 50, 40, 80, 350, 200, 100};

    //constructors
    public App34_CustomizedListViewAdapter(Context context) {

        this.context   = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //implementing abstract methods of "BaseAdapter"
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
    public View getView(int position, View view, ViewGroup parent) {

        view = layoutInflater.inflate(R.layout.app34_customized_list_view2, null);

        ImageView imgAnimal     = (ImageView) view.findViewById(R.id.imgAnimal44);
        final TextView txtAnimalName = (TextView) view.findViewById(R.id.txtAnimalName);
        final TextView txtAnimalPower = (TextView) view.findViewById(R.id.txtAnimalPower);
        final TextView txtAnimalSpeed = (TextView) view.findViewById(R.id.txtAnimalSpeed);

        String oldTxtAnimalNameValue = txtAnimalName.getText().toString();
        String oldTxtAnimalPower = txtAnimalPower.getText().toString();
        String oldTxtAnimalSpeed = txtAnimalSpeed.getText().toString();

        /*
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), animalImages[position], options);

        imgAnimal.setImageBitmap(bm);
        */

        //if want to reduce the images resolutions reduce the required height and width.
        imgAnimal.setImageBitmap(decodeSampledBitmapFromResource(context.getResources(), animalImages[position], 100,100));

        txtAnimalName.setText(oldTxtAnimalNameValue + " " + animalNames[position]);
        txtAnimalPower.setText(oldTxtAnimalPower + " " + animalPower[position]);
        txtAnimalSpeed.setText(oldTxtAnimalSpeed + " " +  animalSpeed[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, txtAnimalName.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;


    }

    public static int calculateInSampleSize (BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource (Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
