package com.example.eladron.app22;

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

        TextView txtArray1 = (TextView) findViewById(R.id.txtArray1);
        TextView txtArray2 = (TextView) findViewById(R.id.txtArray2);

        int[][] multiArr = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12},
                            {13,14,15},};


    }


}
