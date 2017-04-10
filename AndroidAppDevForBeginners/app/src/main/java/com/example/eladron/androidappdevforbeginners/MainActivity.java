package com.example.eladron.androidappdevforbeginners;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String font_file = "fonts/give_me_some_sugar_2.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView txtMainTitle = (TextView) findViewById(R.id.txtMainTitle);
        Button btnApplications = (Button) findViewById(R.id.btnApplications);
        Button btnTopics = (Button) findViewById(R.id.btnTopics);
        Button btnAbout = (Button) findViewById(R.id.btnAbout);

        //Assigning custom font to Textable objects
        Typeface custom_font = Typeface.createFromAsset(getAssets(), font_file);

        txtMainTitle.setTypeface(custom_font);
        btnApplications.setTypeface(custom_font);
        btnTopics.setTypeface(custom_font);
        btnAbout.setTypeface(custom_font);

        btnApplications.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        intent.setClass(this, AppsMenuActivity.class);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.action_settings) {
            Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}


