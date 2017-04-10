package com.example.eladron.app11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private static final SecureRandom secureRandNum = new SecureRandom();

    private enum Status { NOTSTARTEDYET, PROCEED, WON, LOST  };

    private static final int TIGER_CLAWS = 2;
    private static final int TREE = 3;
    private static final int CEVEN = 7;
    private static final int WE_LEVEN = 11;
    private static final int PANTHER = 12;

    TextView  txtCalc;
    ImageView imgDice;
    Button    btnRestart;

    String    oldTxtCalculationValue = "";
    boolean   firstTime = true;
    Status    gameStatus = Status.NOTSTARTEDYET;
    int       points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtCalc    = (TextView) findViewById(R.id.txtCalc);
        imgDice    = (ImageView) findViewById(R.id.imgDice);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        final TextView txtGameStat = (TextView) findViewById(R.id.txtGameStat);

        makeBtnRestartInvisible();

        txtGameStat.setText("");
        txtCalc.setText("");

        imgDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (gameStatus == Status.NOTSTARTEDYET || gameStatus == Status.PROCEED) {

                    int diceSum = letsRollTheDice();
                    oldTxtCalculationValue = txtCalc.getText().toString();
                    points = 0;

                    switch (diceSum) {

                        case CEVEN:
                        case WE_LEVEN:
                            gameStatus = Status.WON;
                            txtGameStat.setText("You Win!");
                            makeImgDiceInvisible();
                            makeBtnRestartVisible();
                            break;
                        case TIGER_CLAWS:
                        case TREE:
                        case PANTHER:
                            gameStatus = Status.LOST;
                            txtGameStat.setText("You Lost!");
                            makeImgDiceInvisible();
                            makeBtnRestartVisible();
                            break;
                        default:
                            gameStatus = Status.PROCEED;
                            points = diceSum;
                            txtCalc.setText(oldTxtCalculationValue + "Your Points are: " + points + "\n");
                            oldTxtCalculationValue = "Your previous Points were: " + points + "\n";
                            txtGameStat.setText("Continue the Game!");
                            break;

                    }

                    return;
                }



            }
        });


        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtGameStat.setText("");
                txtCalc.setText("");
                oldTxtCalculationValue = "";
                makeImgDiceVisible();
                makeBtnRestartInvisible();
                gameStatus = Status.NOTSTARTEDYET;

            }
        });



    }


    private int letsRollTheDice() {

        int randDie1 =  1 + secureRandNum.nextInt(6);
        int randDie2 =  1 + secureRandNum.nextInt(6);
        int sum = randDie1 + randDie2;

        txtCalc.setText(String.format(oldTxtCalculationValue + " You rolled %d + %d = %d%n",
                                                                    randDie1, randDie2, sum ));

        return sum;
    }

    private void makeImgDiceInvisible() {

        imgDice.setVisibility(View.INVISIBLE);
    }

    private void makeBtnRestartInvisible() {

        btnRestart.setVisibility(View.INVISIBLE);
    }

    private void makeImgDiceVisible() {

        imgDice.setVisibility(View.VISIBLE);
    }

    private void makeBtnRestartVisible() {

        btnRestart.setVisibility(View.VISIBLE);
    }


}
