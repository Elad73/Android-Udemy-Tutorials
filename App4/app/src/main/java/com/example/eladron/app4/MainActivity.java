package com.example.eladron.app4;

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

        Animal animal = new Animal("Elad", "Purple", 100, 200);

        TextView txtAnimal = (TextView) findViewById(R.id.txtAnimal);
        txtAnimal.setText(animal.toString());

    }


}
