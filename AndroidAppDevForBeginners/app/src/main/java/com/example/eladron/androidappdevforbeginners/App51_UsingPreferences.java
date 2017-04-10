package com.example.eladron.androidappdevforbeginners;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class App51_UsingPreferences extends AppCompatActivity {

    TextView txtView1;
    TextView txtView2;
    TextView txtView3;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app51_using_preferences);

        txtView1 = (TextView) findViewById(R.id.txtTextNumber1_app51);
        txtView2 = (TextView) findViewById(R.id.txtTextNumber2_app51);
        txtView3 = (TextView) findViewById(R.id.txtTextNumber3_app51);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(App51_UsingPreferences.this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.app51_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.app51_settings:
                Intent intent = new Intent(App51_UsingPreferences.this, App51_PreferencesActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(App51_UsingPreferences.this, "This onResume Method is Called", Toast.LENGTH_SHORT).show();

        MD_Font font = MD_Font.getInstance();
        font.Init(this, getFontPathPreference("CAT_1"), getFontSizePreference("CAT_1"));
        txtView1.setTypeface(font.getTypeface());
        txtView1.setTextSize(font.getFontSize());

        font.Init(this, getFontPathPreference("CAT_2"), getFontSizePreference("CAT_2"));
        txtView2.setTypeface(font.getTypeface());
        txtView2.setTextSize(font.getFontSize());

        font.Init(this, getFontPathPreference("CAT_3"), getFontSizePreference("CAT_3"));
        txtView3.setTypeface(font.getTypeface());
        txtView3.setTextSize(font.getFontSize());

    }

    private String getFontPathPreference(String categoryKey) {

        String strDefault = "fonts/Beyond Wonderland.ttf";
        String fontPath   = "";

        switch (categoryKey) {
            case "CAT_1":
                fontPath =  sharedPreferences.getString("FONT_PATHS_1", strDefault);
                break;
            case "CAT_2":
                fontPath = sharedPreferences.getString("FONT_PATHS_2", strDefault);
                break;
            case "CAT_3":
                fontPath = sharedPreferences.getString("FONT_PATHS_3", strDefault);
                break;
            default:
                fontPath = strDefault;
        }

        return fontPath;
     }

    private float getFontSizePreference(String categoryKey) {

        String flDefault = "14";
        float fontSize = -1;

        switch (categoryKey) {
            case "CAT_1":
                fontSize =  Float.parseFloat(sharedPreferences.getString("FONT_SIZE_1", flDefault));
                break;
            case "CAT_2":
                fontSize = Float.parseFloat(sharedPreferences.getString("FONT_SIZE_2", flDefault));
                break;
            case "CAT_3":
                fontSize = Float.parseFloat(sharedPreferences.getString("FONT_SIZE_3", flDefault));
                break;
            default:
                fontSize = Float.parseFloat(flDefault);
        }

        return fontSize;
    }
}
