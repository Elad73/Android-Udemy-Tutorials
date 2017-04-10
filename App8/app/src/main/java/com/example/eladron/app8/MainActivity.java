package com.example.eladron.app8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Is Healthy
        TextView txtHealthy = (TextView) findViewById(R.id.txtHealthy);
        final CheckBox chxHealthyYes  = (CheckBox) findViewById(R.id.chxHealthyYes);
        final CheckBox chxHealthyNo  = (CheckBox) findViewById(R.id.chxHealthyNo);
        boolean amIHealthy = false;
        int power = 70;

        //True And True
        TextView txtTrue = (TextView) findViewById(R.id.txtTrue);
        final CheckBox chxTrueYes  = (CheckBox) findViewById(R.id.chxTrueYes);
        final CheckBox chxTrueNo  = (CheckBox) findViewById(R.id.chxTrueNo);


       /* chxHealthyYes.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if  (chxHealthyYes.isChecked()) {
                    amIHealthy = true;
                    chxHealthyNo.setChecked(false);
                }



            }

        });

        chxHealthyNo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if  (chxHealthyNo.isChecked()) {
                    amIHealthy = false;
                    chxHealthyYes.setChecked(false);
                }

            }

        });*/


        amIHealthy = (power > 80);

        chxHealthyYes.setChecked(amIHealthy);
        chxHealthyNo.setChecked(!amIHealthy);

        //True And True

        boolean trueAndTrue = (true  && true);
        

    }
}
