package com.example.eladron.androidappdevforbeginners;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class App57_SecondActivity extends AppCompatActivity {

    EditText edtName, edtEmail, edtUsername, edtPass;
    Button btnDone;

    //static keys
    public static final String REQUEST_TEXT_FIELD_NAME     = "REQUEST_NAME";
    public static final String REQUEST_TEXT_FIELD_EMAIL    = "REQUEST_EMAIL";
    public static final String REQUEST_TEXT_FIELD_USERNAME = "REQUEST_USERNAME";
    public static final String REQUEST_TEXT_FIELD_PASSWORD = "REQUEST_PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app57_second);

        edtName     = (EditText) findViewById(R.id.edtName_app57b);
        edtEmail    = (EditText) findViewById(R.id.edtEmail_app57b);
        edtUsername = (EditText) findViewById(R.id.edtUsername_app57b);
        edtPass     = (EditText) findViewById(R.id.edtPassword_app57b);
        btnDone     = (Button) findViewById(R.id.btnDone_app57b);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent data = new Intent();
                data.putExtra(REQUEST_TEXT_FIELD_NAME, edtName.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_EMAIL, edtEmail.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_USERNAME, edtUsername.getText().toString());
                data.putExtra(REQUEST_TEXT_FIELD_PASSWORD, edtPass.getText().toString());
                setResult(RESULT_OK, data); //pass the "OK" data to the activity
                finish();  //this method gets rid of the second activity and go back to the first one
            }
        });

    }
}
