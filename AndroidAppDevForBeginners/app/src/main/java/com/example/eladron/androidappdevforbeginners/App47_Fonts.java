package com.example.eladron.androidappdevforbeginners;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by eladron on 02/02/2017.
 */

public class App47_Fonts  extends AppCompatActivity {

    TextView txtFont;
    RadioGroup rg;
    EditText edtText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app47_fonts);

        txtFont = (TextView) findViewById(R.id.txtFont);
        rg = (RadioGroup) findViewById(R.id.rgFonts);
        edtText = (EditText) findViewById(R.id.edtTextToTry);


        try {
            String[] strFontsArr = getAssets().list("fonts");
            for (int i = 0; i < strFontsArr.length; i++) {
                String font_file = strFontsArr[i];

                final Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/" + font_file);
                String fonrName = font_file.substring(0, font_file.indexOf("."));
                RadioButton rb = new RadioButton(App47_Fonts.this);
                rb.setText(fonrName);
                rb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txtFont.setTypeface(custom_font);
                        if (TextUtils.isEmpty(edtText.getText())) {
                            Toast.makeText(App47_Fonts.this, "Please Enter Text to Try", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String txtToTry = edtText.getText().toString();
                            txtFont.setText(txtToTry);
                        }
                    }
                });
                rg.addView(rb);
            }
        }
        catch(IOException ioEx) {
            Toast.makeText(this, ioEx.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
