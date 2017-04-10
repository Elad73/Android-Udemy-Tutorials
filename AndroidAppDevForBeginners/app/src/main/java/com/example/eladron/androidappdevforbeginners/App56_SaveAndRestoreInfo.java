package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class App56_SaveAndRestoreInfo extends AppCompatActivity {

    TextView txtHi;
    Button btnHi;

    String stringValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app56_save_and_restore_info);

        letsCreateAToast("The onCreate method is Called");

        txtHi = (TextView) findViewById(R.id.txtHi_app56);
        btnHi = (Button) findViewById(R.id.btnHi_app56);

        btnHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stringValue = "Hi";
                txtHi.setText(stringValue);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        letsCreateAToast("The onStart method is Called");
    }

    @Override
    protected void onResume() {
        super.onResume();

        letsCreateAToast("The onResume method is Called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        letsCreateAToast("The onStop method is Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        letsCreateAToast("The onDestroy method is Called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        letsCreateAToast("onSavedInstanceState method is Called");

        outState.putString("STRING_VALUE", stringValue);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        letsCreateAToast("onRestoreInstanceState method is Called");

        stringValue = savedInstanceState.getString("STRING_VALUE");
        txtHi.setText(stringValue);
    }

    private void letsCreateAToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
