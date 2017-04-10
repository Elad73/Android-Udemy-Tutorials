package com.example.eladron.app19;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtModifiedArrayElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txtOriginalValuesOfArray              = (TextView) findViewById(R.id.txtOriginalValuesOfArray);
        TextView txtValuesOfModifiedArray              = (TextView) findViewById(R.id.txtValuesOfModifiedArray);
        txtModifiedArrayElement                        = (TextView) findViewById(R.id.txtModifiedArrayElement);
        TextView txtOriginalArrayElement               = (TextView) findViewById(R.id.txtOriginalArrayElement);
        TextView txtArrayElementValueAfterModification = (TextView) findViewById(R.id.txtArrayElementValueAfterModification);

        String[] stringArr = {"A\n","B\n","C\n","D\n","E\n","F\n","G\n","H\n","I\n","J\n","K\n","L\n","M\n","N\n","O\n","P\n","Q\n","R\n","S\n","T\n",
                              "U\n","V\n","W\n","X\n","Y\n","Z\n"};

        // setting the original values
        txtOriginalValuesOfArray.setText(buildTotalString(stringArr));

        // now we want to modify the array
        letsModifyTheArray(stringArr);
        txtValuesOfModifiedArray.setText(buildTotalString(stringArr));

        txtOriginalArrayElement.setText(stringArr[5]);

        // now we want to modify a specific array element
        letsModifyElement(stringArr[5]);
        //txtModifiedArrayElement.setText(stringArr[5]);

        txtArrayElementValueAfterModification.setText(buildTotalString(stringArr));


    }

    public void letsModifyTheArray(String[] array) {

        for (int index = 0; index < array.length; index++) {
            array[index] = "$" + array[index];
        }

    }

    public String buildTotalString(String[] arr) {

        String tempStr = "";
        for (String value: arr) {

            tempStr += value;
        }
        return tempStr;
    }

    public void letsModifyElement(String element) {

        element = "@#" + element;
        txtModifiedArrayElement.setText(element);
    }


}
