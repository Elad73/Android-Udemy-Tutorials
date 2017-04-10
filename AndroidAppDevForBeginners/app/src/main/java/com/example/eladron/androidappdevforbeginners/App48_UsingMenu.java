package com.example.eladron.androidappdevforbeginners;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class App48_UsingMenu extends AppCompatActivity {

    TextView txtUsingMenu;
    private String font_file = "fonts/Beyond Wonderland.ttf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app48_using_menu);

        txtUsingMenu = (TextView) findViewById(R.id.txtUsingMenu);

        //Assigning custom font to Textable objects
        Typeface custom_font = Typeface.createFromAsset(getAssets(), font_file);
        txtUsingMenu.setTypeface(custom_font);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.app48_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id) {
            case R.id.app48_settings:
            case R.id.app48_settings2:
            case R.id.app48_settings3:
            case R.id.app48_settings4:
                Toast.makeText(App48_UsingMenu.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
