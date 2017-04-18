package com.animalquiz.moondragon.animalquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    public static final String GEUSSES = "settings_numberOfGuesses";
    public static final String ANIMALS_TYPES = "settings_animalsType";
    public static final String QUIZ_BACKGROUND_COLOR = "settings_quizBackgroundColor";
    public static final String QUIZ_FONT = "settings_quizFont";

    private boolean isSettingsChanged = false;

    static Typeface chinkfive;
    static Typeface fontleroybrown;
    static Typeface wonderbarDemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        chinkfive = Typeface.createFromAsset(getAssets(), "fonts/Chunkfive.otf");
        fontleroybrown = Typeface.createFromAsset(getAssets(), "fonts/FontleroyBrown.ttf");
        wonderbarDemo = Typeface.createFromAsset(getAssets(), "fonts/Wonderbar Demo.otf");

        PreferenceManager.setDefaultValues(MainActivity.this, R.xml.quiz_prefereces, false);

        PreferenceManager.getDefaultSharedPreferences(MainActivity.this).registerOnSharedPreferenceChangeListener(settingsChangeListener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Intent preferenceIntent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(preferenceIntent);
        return super.onOptionsItemSelected(item);
    }

    private SharedPreferences.OnSharedPreferenceChangeListener settingsChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {



        }
    };
}
