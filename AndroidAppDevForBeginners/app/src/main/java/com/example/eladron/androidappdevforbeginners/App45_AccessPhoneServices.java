package com.example.eladron.androidappdevforbeginners;

import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class App45_AccessPhoneServices extends AppCompatActivity implements View.OnClickListener, ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int CALL_REQUEST_CODE = 1;
    private static String[] PERMISSIONS =  {
            Manifest.permission.CALL_PHONE
    };

    Button btnOpenUdemy;
    Button btnCall;
    Button btnAccessDialPad;
    Button btnSearchGoogle;
    EditText edtPhoneNumber;

    Button btnJump;

    String phoneNumer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app45_access_phone_services);

        verifyThatWeCanCallSomeone(App45_AccessPhoneServices.this);

        btnOpenUdemy =  (Button) findViewById(R.id.btnOpenUdemy_45);
        btnCall = (Button) findViewById(R.id.btnCall_45);
        btnAccessDialPad = (Button) findViewById(R.id.btnAccessDialPad_45);
        btnSearchGoogle = (Button) findViewById(R.id.btnSearchGoogle_45);
        edtPhoneNumber = (EditText) findViewById(R.id.edtPhoneNumber_45);

        btnOpenUdemy.setOnClickListener(App45_AccessPhoneServices.this);
        btnCall.setOnClickListener(App45_AccessPhoneServices.this);
        btnAccessDialPad.setOnClickListener(App45_AccessPhoneServices.this);
        btnSearchGoogle.setOnClickListener(App45_AccessPhoneServices.this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.btnOpenUdemy_45:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.udemy.com"));
                startActivity(intent);
                break;

            case R.id.btnSearchGoogle_45:
                Intent intntGoogleSearch = new Intent(Intent.ACTION_WEB_SEARCH);
                intntGoogleSearch.putExtra(SearchManager.QUERY, "http://www.google.com");
                //intntGoogleSearch.setData(Uri.parse("http://www.google.com"));
                startActivity(intntGoogleSearch);
                break;

            case R.id.btnCall_45:
                if(ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, CALL_REQUEST_CODE);
                }
                else {
                    phoneNumer = edtPhoneNumber.getText().toString();
                    if (TextUtils.isEmpty(phoneNumer)) {
                        Toast.makeText(App45_AccessPhoneServices.this, "Please Enter phone number.", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Intent intentCall = new Intent(Intent.ACTION_CALL);
                        intentCall.setData(Uri.parse("tel:" + phoneNumer));
                        startActivity(intentCall);
                    }
                }
                break;

            case R.id.btnAccessDialPad_45:
                Intent intentDialPad = new Intent(Intent.ACTION_DIAL);
                startActivity(intentDialPad);
                break;
        }
    }

    public static void verifyThatWeCanCallSomeone(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);

        if(permission != PackageManager.PERMISSION_GRANTED) {
            //we don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS, CALL_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(App45_AccessPhoneServices.this, "This is the callback of requestPermissions - Permissions Granted!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(App45_AccessPhoneServices.this, "This is the callback of requestPermissions - Permissions Denied!", Toast.LENGTH_SHORT).show();
        }

    }
}
