package com.example.eladron.androidappdevforbeginners;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by eladron on 07/02/2017.
 */
public class MD_Font {

    private static MD_Font ourInstance = new MD_Font();

    private String   fontPath = null;
    private Typeface typeface = null;
    private Context  context  = null;
    private float    fontSize = 14;

    public static MD_Font getInstance() {
        return ourInstance;
    }

    private MD_Font() {
    }

    public void Init (Context context, String fontPath, float fontSize) {

        this.context = context;
        this.fontPath = fontPath;
        this.fontSize = fontSize;

        typeface = Typeface.createFromAsset(this.context.getAssets(), this.fontPath);
    }


    //Getters
    public String getFontPath() {
        return fontPath;
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public float getFontSize() {
        return fontSize;
    }

}
