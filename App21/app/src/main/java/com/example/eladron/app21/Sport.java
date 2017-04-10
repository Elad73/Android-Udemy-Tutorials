package com.example.eladron.app21;

import android.widget.TextView;

/**
 * Created by eladron on 03/01/2017.
 */

public class Sport {

    private String sportName;
    private int[] scores;

    public Sport(String sportName, int[] scores) {
        this.sportName = sportName;
        this.scores    = scores;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public int getTheMinValue() {

        int lowestScore = scores[0];

        for (int score: scores) {
            if (score < lowestScore )
                lowestScore = score;
        }

        return lowestScore;
    }

    public int getTheMaxValue() {

        int maxScore = scores[0];

        for (int score: scores) {
            if (score > maxScore )
                maxScore = score;
        }

        return maxScore;
    }

    public double getTheAvgValue() {

        int sumScores = 0;

        for (int score: scores) {
            sumScores += score;
        }

        return (float)sumScores / scores.length;
    }

    public void setViewWithScores(TextView textView) {

        String oldTextViewValue;

        for (int index = 0; index < scores.length; index++) {
            oldTextViewValue = textView.getText().toString();

            textView.setText(String.format(oldTextViewValue + "Athlete Number: %2d: %3d\n", index, scores[index]));
        }
    }

}
