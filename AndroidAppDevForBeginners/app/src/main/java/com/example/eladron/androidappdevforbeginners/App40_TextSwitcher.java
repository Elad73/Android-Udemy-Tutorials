package com.example.eladron.androidappdevforbeginners;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;

/**
 * Created by eladron on 18/01/2017.
 */

public class App40_TextSwitcher extends AppCompatActivity implements View.OnClickListener{


    TextSwitcher txtSwitcher1;
    ImageButton btnNext1;
    ImageButton btnPrev1;

    TextSwitcher txtSwitcher2;
    ImageButton btnNext2;
    ImageButton btnPrev2;

    TextSwitcher txtSwitcher3;
    ImageButton btnNext3;
    ImageButton btnPrev3;

    String[] strValues1 = {"Complete Android Devleoper Course", "Complete iOS Developer Course"};
    String[] strValues2 = {"Complete Java Devleoper Course", "Complete Swift Developer Course"};
    String[] strValues3 = {"Complete Objective-C Devleoper Course", "Complete JSP Developer Course"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app40_text_switcher);


        txtSwitcher1 = (TextSwitcher) findViewById(R.id.txtSwitcher1);
        txtSwitcher2 = (TextSwitcher) findViewById(R.id.txtSwitcher2);
        txtSwitcher3 = (TextSwitcher) findViewById(R.id.txtSwitcher3);

        btnNext1 = (ImageButton) findViewById(R.id.btnNext1);
        btnNext2 = (ImageButton) findViewById(R.id.btnNext2);
        btnNext3 = (ImageButton) findViewById(R.id.btnNext3);

        btnPrev1 = (ImageButton) findViewById(R.id.btnPrev1);
        btnPrev2 = (ImageButton) findViewById(R.id.btnPrev2);
        btnPrev3 = (ImageButton) findViewById(R.id.btnPrev3);

        createTextViewIteratingOverTheValuesOfTheArrayForTextSwitcher(strValues1, txtSwitcher1);
        createTextViewIteratingOverTheValuesOfTheArrayForTextSwitcher(strValues2, txtSwitcher2);
        createTextViewIteratingOverTheValuesOfTheArrayForTextSwitcher(strValues3, txtSwitcher3);

        useTheAnimationForTextSwitcher(txtSwitcher1);
        useTheAnimationForTextSwitcher(txtSwitcher2);
        useTheAnimationForTextSwitcher(txtSwitcher3);

        btnNext1.setOnClickListener(App40_TextSwitcher.this);
        btnNext2.setOnClickListener(App40_TextSwitcher.this);
        btnNext3.setOnClickListener(App40_TextSwitcher.this);

        btnPrev1.setOnClickListener(App40_TextSwitcher.this);
        btnPrev2.setOnClickListener(App40_TextSwitcher.this);
        btnPrev3.setOnClickListener(App40_TextSwitcher.this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.btnNext1:
                txtSwitcher1.showNext();
                break;
            case R.id.btnNext2:
                txtSwitcher2.showNext();
                break;
            case R.id.btnNext3:
                txtSwitcher3.showNext();
                break;
            case R.id.btnPrev1:
                txtSwitcher1.showPrevious();
                break;
            case R.id.btnPrev2:
                txtSwitcher2.showPrevious();
                break;
            case R.id.btnPrev3:
                txtSwitcher3.showPrevious();
                break;
        }

    }

    private void useTheAnimationForTextSwitcher(TextSwitcher txtSwitcher) {

        txtSwitcher.setInAnimation(AnimationUtils.loadAnimation(App40_TextSwitcher.this, android.R.anim.fade_in));
        txtSwitcher.setOutAnimation(AnimationUtils.loadAnimation(App40_TextSwitcher.this, android.R.anim.fade_out));
    }

    private void createTextViewIteratingOverTheValuesOfTheArrayForTextSwitcher(String[] strValues, TextSwitcher txtSwitcher) {

        for (int index = 0; index < strValues.length; index++) {
            TextView txtView = new TextView(App40_TextSwitcher.this);
            txtView.setText(strValues[index]);
            txtView.setTextColor(Color.BLUE);
            txtView.setTextSize(40);
            txtSwitcher.addView(txtView);
        }
    }
}
