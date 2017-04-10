package com.example.eladron.androidappdevforbeginners;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class App57_PassDataFrom2To1Activity extends AppCompatActivity {

    TextView txtName, txtEmail, txtUsername, txtPass;
    Button btnMove;

    private final int REQUEST_CODE_MOVE = 1556;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app57_pass_data_from2_to1);

        txtName     = (TextView) findViewById(R.id.textName_app57);
        txtEmail    = (TextView) findViewById(R.id.textEmail_app57);
        txtUsername = (TextView) findViewById(R.id.textUsername_app57);
        txtPass     = (TextView) findViewById(R.id.textPassword_app57);
        btnMove     = (Button) findViewById(R.id.btnMove_app57);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(App57_PassDataFrom2To1Activity.this, App57_SecondActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MOVE);
                //startActivityForResult(); //we want to send the data from the second to the First again on back button - so "Start for result"

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MOVE && resultCode == RESULT_OK) {

            txtName.setText(data.getStringExtra(App57_SecondActivity.REQUEST_TEXT_FIELD_NAME));
            txtEmail.setText(data.getStringExtra(App57_SecondActivity.REQUEST_TEXT_FIELD_EMAIL));
            txtUsername.setText(data.getStringExtra(App57_SecondActivity.REQUEST_TEXT_FIELD_USERNAME));
            txtPass.setText(data.getStringExtra(App57_SecondActivity.REQUEST_TEXT_FIELD_PASSWORD));

        }

    }
}
