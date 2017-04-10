package com.example.eladron.app10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {


    SecureRandom secureRanomNumbers = new SecureRandom();
    int numberOfDices = 50000;
    int number1 = 0;
    int number2 = 0;
    int number3 = 0;
    int number4 = 0;
    int number5 = 0;
    int number6 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        final TextView txtNumber1 = (TextView) findViewById(R.id.txtNumber1);
        final TextView txtNumber2 = (TextView) findViewById(R.id.txtNumber2);
        final TextView txtNumber3 = (TextView) findViewById(R.id.txtNumber3);
        final TextView txtNumber4 = (TextView) findViewById(R.id.txtNumber4);
        final TextView txtNumber5 = (TextView) findViewById(R.id.txtNumber5);
        final TextView txtNumber6 = (TextView) findViewById(R.id.txtNumber6);

        final ImageView imgDiceNumber1 = (ImageView) findViewById(R.id.imgDiceNumber1);
        final ImageView imgDiceNumber2 = (ImageView) findViewById(R.id.imgDiceNumber2);
        final ImageView imgDiceNumber3 = (ImageView) findViewById(R.id.imgDiceNumber3);
        final ImageView imgDiceNumber4 = (ImageView) findViewById(R.id.imgDiceNumber4);
        final ImageView imgDiceNumber5 = (ImageView) findViewById(R.id.imgDiceNumber5);
        final ImageView imgDiceNumber6 = (ImageView) findViewById(R.id.imgDiceNumber6);

        ImageView imgDice = (ImageView) findViewById(R.id.imgDice);

        Button btnRoll = (Button) findViewById(R.id.btnRoll);

        btnRoll.setOnClickListener(new View.OnClickListener()
        {



            @Override
            public void onClick(View v)
            {
                number1 = 0;
                number2 = 0;
                number3 = 0;
                number4 = 0;
                number5 = 0;
                number6 = 0;

                for (int rollTimes = 0; rollTimes <= numberOfDices; ++rollTimes)
                {
                    int faceNumber = 1 + secureRanomNumbers.nextInt(6);
                    switch (faceNumber) {

                        case 1:
                            ++number1;
                            break;
                        case 2:
                            ++number2;
                            break;
                        case 3:
                            ++number3;
                            break;
                        case 4:
                            ++number4;
                            break;
                        case 5:
                            ++number5;
                            break;
                        case 6:
                            ++number6;
                            break;
                    }

                }

                txtNumber1.setText(number1 + " (" + (float)number1/numberOfDices*100 + "%)" );
                txtNumber2.setText(number2 + " (" + (float)number2/numberOfDices*100 + "%)" );
                txtNumber3.setText(number3 + " (" + (float)number3/numberOfDices*100 + "%)" );
                txtNumber4.setText(number4 + " (" + (float)number4/numberOfDices*100 + "%)" );
                txtNumber5.setText(number5 + " (" + (float)number5/numberOfDices*100 + "%)" );
                txtNumber6.setText(number6 + " (" + (float)number6/numberOfDices*100 + "%)" );


                imgDiceNumber1.setImageResource(R.drawable.dice_num1);
                imgDiceNumber2.setImageResource(R.drawable.dice_num2);
                imgDiceNumber3.setImageResource(R.drawable.dice_num3);
                imgDiceNumber4.setImageResource(R.drawable.dice_num4);
                imgDiceNumber5.setImageResource(R.drawable.dice_num5);
                imgDiceNumber6.setImageResource(R.drawable.dice_num6);
            }
        });




    }

}
