package com.mondra.utils;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by eladron on 09/01/2017.
 */

public class CustomFont extends AppCompatActivity {

    private Typeface custom_font;
    private String font_file;
    private AssetManager am;



    //constructors --------------------------------
    public CustomFont(String font_file) {
        this.font_file   = font_file;
    }

    //getters & setters --------------------------------
    public String getFont_file() {
        return font_file;
    }

    public void setFont_file(String font_file) {
        this.font_file = font_file;
    }

    //methods --------------------------------
    //Todo: currently the getAssets() return null, I think since I dont pass a context to the class!!
    public Typeface createFromAsset() {

        Typeface tf = null;

        try {
            tf = Typeface.createFromAsset(getAssets(), font_file);
        }
        catch(Exception e) {
            Log.d("Log DEBUG ", e.toString());
        }

        return tf;
    }
}
