package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

/**
 * Created by eladron on 09/01/2017.
 */

public class App34_CustomizedListViewActivity extends AppCompatActivity {

    ListView lstView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app34_customized_list_view_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstView = (ListView) findViewById(R.id.lstView);

        App34_CustomizedListViewAdapter adapter = new App34_CustomizedListViewAdapter(App34_CustomizedListViewActivity.this);

        lstView.setAdapter(adapter);

    }

    @Override
    public String toString() {
        return "Customized ListView";
    }
}
