package com.example.eladron.app9;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
        final EditText edtNum3 = (EditText) findViewById(R.id.edtNum3);
        Button btnMaxValue = (Button) findViewById(R.id.btnMaxValue);
        final TextView txtResult = (TextView) findViewById(R.id.txtResult);
        final Button btnSecureRand = (Button) findViewById(R.id.btnSecureRand);
        final TextView txtSecureRand = (TextView) findViewById(R.id.txtSecureRand);


        btnMaxValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    double num1 = Double.parseDouble(edtNum1.getText().toString());
                    double num2 = Double.parseDouble(edtNum2.getText().toString());
                    double num3 = Double.parseDouble(edtNum3.getText().toString());

                    double result = getMaxValu(num1, num2, num3);

                    txtResult.setText(result + "");
                } catch (Exception e) {

                    txtResult.setText(e.getMessage());

                }


            }
        });

        btnSecureRand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SecureRandom secureRandomNumber = new SecureRandom();
                String oldTxtSecureRandomNumbersValue = txtSecureRand.getText().toString();
                int randNumber = 25 + secureRandomNumber.nextInt(25);
                txtSecureRand.setText(randNumber + "");

                if (txtSecureRand.getText().toString().length() >= 9) {
                    btnSecureRand.setVisibility(View.INVISIBLE);
                }


                Log.i("LOG", randNumber + "");

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public double getMaxValu(double num1, double num2, double num3) {

        double result = (num1 > num2 ? num1 : num2);
        result = (result > num3 ? result : num3);

        return result;
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
