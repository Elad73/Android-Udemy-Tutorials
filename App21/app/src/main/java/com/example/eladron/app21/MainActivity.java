package com.example.eladron.app21;

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

        TextView txtSportName     = (TextView) findViewById(R.id.txtSportName);
        TextView txtScores        = (TextView) findViewById(R.id.txtScores);
        TextView txtScoresAverage = (TextView) findViewById(R.id.txtScoresAverage);
        TextView txtHighestScore  = (TextView) findViewById(R.id.txtHighestScore);
        TextView txtLowestScore   = (TextView) findViewById(R.id.txtLowestScore);

        Sport mySport = new Sport("Triathlon", new int[] {20, 30, 40, 50, 10, 60, 70, 98, 97, 76, 33});

        txtSportName.setText(mySport.getSportName());
        mySport.setViewWithScores(txtScores);
        txtHighestScore.setText(mySport.getTheMaxValue() + "");
        txtLowestScore.setText(mySport.getTheMinValue() + "");
        txtScoresAverage.setText(mySport.getTheAvgValue() + "");

    }


}
