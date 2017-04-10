package com.example.eladron.app13;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView txtIndex = (TextView) findViewById(R.id.txtIndex);
        TextView txtValue = (TextView) findViewById(R.id.txtValue);
        LinearLayout linlVertical1 = (LinearLayout) findViewById(R.id.linlVertical1);
        LinearLayout linlVertical2 = (LinearLayout) findViewById(R.id.linlVertical2);
        String oldTxtIndexValue;
        String oldTxtValueValue;
        final int LENGTH_OF_ARRAY = 15;
        float[] floatNumArr = new float[LENGTH_OF_ARRAY];

        //initializing the float array
        for (int index = 0; index < floatNumArr.length; index++) {

            floatNumArr[index] = 5 + 3 * index;
            TextView txtIndexTemp = new TextView(this);
            txtIndexTemp.setTextColor(Color.CYAN);
            //txtIndexTemp.setFontFeatureSettings();
            txtIndexTemp.setText(index + "");
            linlVertical1.addView(txtIndexTemp);

            TextView txtValueTemp = new TextView(this);
            txtValueTemp.setTextColor(Color.CYAN);
            txtValueTemp.setText(floatNumArr[index] + "");
            linlVertical2.addView(txtValueTemp);


        }

       /* for (int index = 0; index < floatNumArr.length; index++) {

            oldTxtIndexValue = txtIndex.getText().toString();
            oldTxtValueValue = txtValue.getText().toString();

            txtIndex.setText(oldTxtIndexValue + index + "\n");
            txtValue.setText(oldTxtValueValue + floatNumArr[index] + "\n");
        }*/




    }


}
