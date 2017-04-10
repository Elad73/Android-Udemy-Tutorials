package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import static com.example.eladron.androidappdevforbeginners.R.id.radioButton2;
import static com.example.eladron.androidappdevforbeginners.R.id.radioButton3;

/**
 * Created by eladron on 18/01/2017.
 */

public class App41_CheckboxRadiobuttonRatingbarSeekbar extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, RatingBar.OnRatingBarChangeListener, RadioGroup.OnCheckedChangeListener {

    CheckBox chkBox1;
    CheckBox chkBox2;
    CheckBox chkBox3;
    CheckBox chkBox4;
    CheckBox chkBox5;
    CheckBox chkBox6;
    CheckBox chkBox7;
    CheckBox chkBox8;

    SeekBar skbar;
    RatingBar ratingBar;

    RadioGroup radioGroup;
    RadioButton radioBtn1;
    RadioButton radioBtn2;
    RadioButton radioBtn3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app41_check_radio_rating_seek);

        chkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        chkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        chkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        chkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        chkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        chkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        chkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        chkBox8 = (CheckBox) findViewById(R.id.checkBox8);

        skbar = (SeekBar) findViewById(R.id.seekBar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioBtn1 = (RadioButton) findViewById(R.id.radioButton1);
        radioBtn2 = (RadioButton) findViewById(radioButton2);
        radioBtn3 = (RadioButton) findViewById(radioButton3);


        chkBox1.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        chkBox2.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        chkBox3.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        chkBox4.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        chkBox5.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        chkBox6.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        chkBox7.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        chkBox8.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);

        skbar.setOnSeekBarChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);

        ratingBar.setOnRatingBarChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);

        radioGroup.setOnCheckedChangeListener(App41_CheckboxRadiobuttonRatingbarSeekbar.this);
        
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            switch (buttonView.getId()) {
                case R.id.checkBox1:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox1.getText() + " Checked!" , Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox2:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox2.getText() + " Checked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox3:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox3.getText() + " Checked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox4:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox4.getText() + " Checked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox5:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox5.getText() + " Checked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox6:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox6.getText() + " Checked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox7:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox7.getText() + " Checked!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.checkBox8:
                    Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, chkBox8.getText() + " Checked!", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, "The value is " + progress, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, "Thank you for Starting Seeking", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, "Thank you for Stopping Seeking", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, "Thank you for #" + rating + " Stars!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId) {
            case R.id.radioButton1:
                Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, radioBtn1.getText() + " Checked!" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, radioBtn2.getText() + " Checked!" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                Toast.makeText(App41_CheckboxRadiobuttonRatingbarSeekbar.this, radioBtn3.getText() + " Checked!" , Toast.LENGTH_SHORT).show();
                break;

        }
    }

    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml
       int id = item.getItemId();

        // noInspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
