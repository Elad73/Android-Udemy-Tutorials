package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.QuickContactBadge;

/**
 * Created by eladron on 23/01/2017.
 */

public class App42_Contacts extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app42_contacts);

        QuickContactBadge quickContactBadge = (QuickContactBadge) findViewById(R.id.quickContactBadge);
        quickContactBadge.assignContactFromPhone("321654987", true); //true for the lazy lookup
    }
}
