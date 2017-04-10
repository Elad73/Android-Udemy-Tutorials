package com.example.eladron.app15;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int fiveStarReview  = 0;
    int fourStarReview  = 0;
    int threeStarReview = 0;
    int twoStarReview   = 0;
    int oneStarReview   = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(this, "OnCreate Method is Called", Toast.LENGTH_LONG).show();

        final TextView txtFiveStarsStudent  = (TextView) findViewById(R.id.txtFiveStarsStudent);
        final TextView txtFourStarsStudent  = (TextView) findViewById(R.id.txtFourStarsStudent);
        final TextView txtThreeStarsStudent = (TextView) findViewById(R.id.txtThreeStarsStudent);
        final TextView txtTwoStarsStudent   = (TextView) findViewById(R.id.txtTwoStarsStudent);
        final TextView txtOneStarsStudent   = (TextView) findViewById(R.id.txtOneStarsStudent);

        RatingBar rtbFiveStarsStudent  = (RatingBar) findViewById(R.id.rtbFiveStarsStudent);
        RatingBar rtbFourStarsStudent  = (RatingBar) findViewById(R.id.rtbFourStarsStudent);
        RatingBar rtbThreeStarsStudent = (RatingBar) findViewById(R.id.rtbThreeStarsStudent);
        RatingBar rtbTwoStarsStudent   = (RatingBar) findViewById(R.id.rtbTwoStarsStudent);
        RatingBar rtbOneStarsStudent   = (RatingBar) findViewById(R.id.rtbOneStarsStudent);

        Button btnResults =  (Button) findViewById(R.id.btnResults);

       /* rtbFiveStarsStudent.setIsIndicator(true);
        rtbFourStarsStudent.setIsIndicator(true);
        rtbThreeStarsStudent.setIsIndicator(true);
        rtbTwoStarsStudent.setIsIndicator(true);
        rtbOneStarsStudent.setIsIndicator(true);*/

        makeThisRatingBarIndicator(rtbFiveStarsStudent);
        makeThisRatingBarIndicator(rtbFourStarsStudent);
        makeThisRatingBarIndicator(rtbThreeStarsStudent);
        makeThisRatingBarIndicator(rtbTwoStarsStudent);
        makeThisRatingBarIndicator(rtbOneStarsStudent);


        final int[] studentReviews = { 5, 3, 4, 2, 4, 5, 1, 3, 2, 5, 5, 3, 2, 3};

        for (int index = 0; index < studentReviews.length; index++) {

            switch(studentReviews[index]) {

                case 5:
                    ++fiveStarReview;
                    break;
                case 4:
                    ++fourStarReview;
                    break;
                case 3:
                    ++threeStarReview;
                    break;
                case 2:
                    ++twoStarReview;
                    break;
                case 1:
                    ++oneStarReview;
                    break;
            }

        }


        btnResults.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                txtFiveStarsStudent.setText(fiveStarReview + "");
                txtFourStarsStudent.setText(fourStarReview + "");
                txtThreeStarsStudent.setText(threeStarReview + "");
                txtTwoStarsStudent.setText(twoStarReview + "");
                txtOneStarsStudent.setText(oneStarReview + "");
            }
        });

    }

    public void makeThisRatingBarIndicator(RatingBar rtb) {

        rtb.setIsIndicator(true);
    }

}
