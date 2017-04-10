package com.example.eladron.androidappdevforbeginners;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

/**
 * Created by eladron on 15/01/2017.
 */

public class App36_GridViewActivity extends AppCompatActivity {

    GridView grdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app36_grid_view_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        grdView = (GridView) findViewById(R.id.grdView);
        App36_GridViewAdapter adapter = new App36_GridViewAdapter(App36_GridViewActivity.this);
        grdView.setAdapter(adapter);

    }

}
