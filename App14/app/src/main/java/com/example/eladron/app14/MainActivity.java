package com.example.eladron.app14;

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

        TextView txtTotal = (TextView) findViewById(R.id.txtTotal);
        TextView txtCalculations = (TextView) findViewById(R.id.txtCalculations);

        String oldText;

        int[] inArray = {2, 54, 34, 76, 23, 4, 7, 86, 4, 65};
        int totalValue = 0;

        for (int index = 0; index < inArray.length; index++) {

            totalValue = totalValue + inArray[index];

            oldText = txtCalculations.getText().toString();
            txtCalculations.setText(oldText + totalValue + "+" + inArray[index] + "=" + totalValue + "\n");
        }

        txtTotal.setText(totalValue + "");

    }

}
