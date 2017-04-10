package com.example.eladron.androidappdevforbeginners;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class App50_SharedPrefences extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    CheckBox ckbNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app50_shared_prefences);


        ckbNew = (CheckBox) findViewById(R.id.ckbNew_app50);
        ckbNew.setOnCheckedChangeListener(App50_SharedPrefences.this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked) {
            ckbNew.setText("The CheckBox is Checked");
        }
        else {
            ckbNew.setText("The CheckBox is NOT Checked");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(App50_SharedPrefences.this, "The onPause Method is called", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getPreferences(0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("CHECKBOX_TEXT_VALUE", ckbNew.getText().toString());
        editor.putBoolean("CHECKBOX_VALUE", ckbNew.isChecked());
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(App50_SharedPrefences.this, "The onResume Method is called", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPreferences = getPreferences(0);
        boolean checkBoxValue = sharedPreferences.getBoolean("CHECKBOX_VALUE", false);
        String txtValue = sharedPreferences.getString("CHECKBOX_TEXT_VALUE", "This is my Checkbox value");
        ckbNew.setChecked(checkBoxValue);
        ckbNew.setText(txtValue);
    }
}
