package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ExpandableListView;

/**
 * Created by eladron on 10/01/2017.
 */

public class App35_ExpandableListViewActivity extends AppCompatActivity {


    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app35_expandable_list_view_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        expandableListView = (ExpandableListView) findViewById(R.id.expLstView);
        App35_ExpandableListViewAdapter adapter = new App35_ExpandableListViewAdapter(App35_ExpandableListViewActivity.this);
        expandableListView.setAdapter(adapter);

    }
}
