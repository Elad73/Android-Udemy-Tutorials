package com.example.eladron.app19;

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

        TextView txtCountryNames = (TextView) findViewById(R.id.txtCountryNames);

        String[] countries = {"Afghanistan\n", "Albania\n", "Algeria\n", "Angola\n", "Aruba\n", "Australia\n", "Bahamas\n",
                              "Banglasesh\n", "Bhutan\n", "Bolivia\n", "Bosina\n",
                              "Afghanistan\n", "Albania\n", "Algeria\n", "Angola\n", "Aruba\n", "Australia\n", "Bahamas\n",
                              "Banglasesh\n", "Bhutan\n", "Bolivia\n", "Bosina\n",
                              "Afghanistan\n", "Albania\n", "Algeria\n", "Angola\n", "Aruba\n", "Australia\n", "Bahamas\n",
                              "Banglasesh\n", "Bhutan\n", "Bolivia\n", "Bosina\n",
                              "Afghanistan\n", "Albania\n", "Algeria\n", "Angola\n", "Aruba\n", "Australia\n", "Bahamas\n",
                              "Banglasesh\n", "Bhutan\n", "Bolivia\n", "Bosina\n",
                              "Afghanistan\n", "Albania\n", "Algeria\n", "Angola\n", "Aruba\n", "Australia\n", "Bahamas\n",
                              "Banglasesh\n", "Bhutan\n", "Bolivia\n", "Bosina\n"};
        String allCountrynames = "";

        for (String country : countries) {
            allCountrynames += country;
        }

        txtCountryNames.setText(allCountrynames);


    }


}
