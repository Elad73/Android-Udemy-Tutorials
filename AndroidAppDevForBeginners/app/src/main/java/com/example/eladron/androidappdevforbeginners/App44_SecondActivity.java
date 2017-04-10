package com.example.eladron.androidappdevforbeginners;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class App44_SecondActivity extends AppCompatActivity {

    TextView txtName;
    TextView txtEmail;
    TextView txtUserName;
    TextView txtPassword;
    TextView txtGenderType;
    ImageView imgReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app44_second_activity);

        txtName = (TextView) findViewById(R.id.txtName44b);
        txtEmail = (TextView) findViewById(R.id.txtEmail44b);
        txtUserName =  (TextView) findViewById(R.id.txtUsername44b);
        txtPassword =  (TextView) findViewById(R.id.txtPassword44b);
        txtGenderType = (TextView) findViewById(R.id.txtGenderType44b);
        imgReceived = (ImageView) findViewById(R.id.imgReceive44b);

        Bundle extras = getIntent().getExtras();
        txtName.setText(extras.getString("Name"));
        txtEmail.setText(extras.getString("Email"));
        txtUserName.setText(extras.getString("User_Name"));
        txtPassword.setText(extras.getString("Password"));
        txtGenderType.setText(extras.getString("Gender_Type"));

        byte[] byteArray = extras.getByteArray("Picture");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imgReceived.setImageBitmap(bitmap);
    }
}
