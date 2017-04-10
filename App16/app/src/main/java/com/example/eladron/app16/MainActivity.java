package com.example.eladron.app16;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final TextView txtDice1 = (TextView) findViewById(R.id.txtDice1);
        final TextView txtDice2 = (TextView) findViewById(R.id.txtDice2);
        final TextView txtDice3 = (TextView) findViewById(R.id.txtDice3);
        final TextView txtDice4 = (TextView) findViewById(R.id.txtDice4);
        final TextView txtDice5 = (TextView) findViewById(R.id.txtDice5);
        final TextView txtDice6 = (TextView) findViewById(R.id.txtDice6);

        Button btnRoll = (Button) findViewById(R.id.btnRoll);

        final SecureRandom secureRandNum = new SecureRandom();
        final int[] occuences = new int[7];

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int times = 0; times < 500000; times++) {
                    int randNum = 1 + secureRandNum.nextInt(6);
                    ++occuences[randNum];
                }

                for (int i=1; i <= occuences.length; i++) {

                    switch(i) {
                        case 1:
                            txtDice1.setText(occuences[i] + "");
                            break;
                        case 2:
                            txtDice2.setText(occuences[i] + "");
                            break;
                        case 3:
                            txtDice3.setText(occuences[i] + "");
                            break;
                        case 4:
                            txtDice4.setText(occuences[i] + "");
                            break;
                        case 5:
                            txtDice5.setText(occuences[i] + "");
                            break;
                        case 6:
                            txtDice6.setText(occuences[i] + "");
                            break;
                    }

                }
            }
        });

    }




}
