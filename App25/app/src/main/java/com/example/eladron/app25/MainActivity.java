package com.example.eladron.app25;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txtArrayDoubleValue     = (TextView) findViewById(R.id.txtArrayDoubleValue);
        TextView txtArrayIntegerNumbers  = (TextView) findViewById(R.id.txtArrayIntegerNumbers);
        TextView txtArray1               = (TextView) findViewById(R.id.txtArray1);
        TextView txtIntArray1Copy        = (TextView) findViewById(R.id.txtIntArray1Copy);
        TextView txtLocationArrayElement = (TextView) findViewById(R.id.txtLocationArrayElement);
        Switch   swtEqual                = (Switch) findViewById(R.id.swtEqual);
        String   oldTxtArayDoubleValues  = "";

        //using the Arrays.sort method
        double[] doubleValuesArray = {6.3, 1.2, 3.8, 2.7, 9.1, 4.3, 56.4, 34.2, 90.1, 12.4, 54.2, 79.1, 10.2};
        Arrays.sort(doubleValuesArray);  //sorting the arrayin an ascending order

        for(int index = 0; index < doubleValuesArray.length; index++) {
            oldTxtArayDoubleValues = txtArrayDoubleValue.getText().toString();
            txtArrayDoubleValue.setText(oldTxtArayDoubleValues + doubleValuesArray[index] + "   ");
        }

        //using the Arrays.fill method
        int[] intNumbersarray = new int[20];
        Arrays.fill(intNumbersarray, 1);

        outputTheArrayToTheScreen(intNumbersarray, txtArrayIntegerNumbers);

        //using System.arraycopy
        int[] integersArray1 = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
        int[] integerArray1Copy = new int[integersArray1.length];

        System.arraycopy(integersArray1, 0, integerArray1Copy, 0, integersArray1.length);
        outputTheArrayToTheScreen(integersArray1, txtArray1);
        outputTheArrayToTheScreen(integerArray1Copy, txtIntArray1Copy);

        //using Arrays.equals
        boolean isEqual = Arrays.equals(integersArray1, integerArray1Copy);
        swtEqual.setChecked(isEqual ? true : false);
        swtEqual.setText((isEqual ? " The Values of these arays are Equal" : " not Equal"));



    }

    public void outputTheArrayToTheScreen(int[] array, TextView textView) {
        String oldTextViewValue;
        for (int number: array) {
            oldTextViewValue = textView.getText().toString();
            textView.setText(oldTextViewValue + number + "   ");
        }
    }

}
