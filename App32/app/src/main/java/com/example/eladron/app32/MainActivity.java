package com.example.eladron.app32;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtValue;
    EditText edtValue;
    AutoCompleteTextView      autoCompleteTextView;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    boolean toggle = false;

    String[] courseNames = {"Android developer Course", "iOS developer Course", "Java developer Course"};
    ArrayAdapter<String> myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtValue = (TextView) findViewById(R.id.txtValue);
        edtValue = (EditText) findViewById(R.id.edtValue);
        autoCompleteTextView      = (AutoCompleteTextView) findViewById(R.id. autoCompleteTextView);
        multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);


        txtValue.setText("Awesome!");
        txtValue.setBackgroundColor(Color.BLUE);

        txtValue.setOnClickListener(MainActivity.this);
        edtValue.setOnClickListener(this);

        myAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, courseNames);
        autoCompleteTextView.setAdapter(myAdapter);
        multiAutoCompleteTextView.setAdapter(myAdapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.txtValue:
            if (toggle)
                txtValue.setTextColor(Color.RED);
            else
                txtValue.setTextColor(Color.YELLOW);
            toggle = !toggle;
                break;
            case R.id.edtValue:
                txtValue.setText(edtValue.getText());
                break;
        }


    }

}
