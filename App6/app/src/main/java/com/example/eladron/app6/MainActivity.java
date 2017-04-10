package com.example.eladron.app6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView txtEnter = (TextView) findViewById(R.id.txtEnter);
        final TextView txtResult = (TextView) findViewById(R.id.txtResult);
        final EditText edtNumber = (EditText) findViewById(R.id.edtNumber);
        Button btnResult = (Button) findViewById(R.id.btnResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textFieldValue = edtNumber.getText().toString();

                try {

                    if (Integer.parseInt(textFieldValue) == 51)
                        txtResult.setText(textFieldValue + "Great");
                    else
                        txtResult.setText(("Not 51"));
                }
                catch (NumberFormatException ex) {
                    txtResult.setText("Not a number, please try again");
                }

            }
        });


    }

}
