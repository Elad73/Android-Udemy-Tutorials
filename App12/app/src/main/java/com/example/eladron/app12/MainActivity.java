package com.example.eladron.app12;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
        String oldTextIndexValue;
        String oldTextValueValue;

        int[] intArr = new int[10];

        for (int counter = 0; counter < intArr.length; counter++) {

            oldTextIndexValue = txtIndex.getText().toString();
            oldTextValueValue = txtValue.getText().toString();


            txtIndex.setText(oldTextIndexValue + counter + "\n");
            txtValue.setText(oldTextValueValue + intArr[counter] + "\n");
        }


    }


}
