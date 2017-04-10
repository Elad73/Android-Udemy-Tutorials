package com.example.eladron.androidappdevforbeginners;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by eladron on 29/01/2017.
 */

public class App44_InfoFrom1ActivityToOther extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    EditText edtName;
    EditText edtEmail;
    EditText edtUsername;
    EditText edtPassword;
    ImageView imgAnimal;
    RadioGroup radioGroup;
    Button btnAdd;
    String genderType = "";
    final int IMAGE_REQUEST_CODE = 1000;
    String photoPath = "";
    Bitmap bitmap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app44_info_from_1_activity_to_other);

        edtName = (EditText) findViewById(R.id.edtName44);
        edtEmail = (EditText) findViewById(R.id.edtEmail44);
        edtPassword = (EditText) findViewById(R.id.edtPassword44);
        edtUsername = (EditText) findViewById(R.id.edtUserName44);
        imgAnimal = (ImageView) findViewById(R.id.imgAnimal44);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup44);
        btnAdd = (Button) findViewById(R.id.btnAdd44);

        btnAdd.setOnClickListener(App44_InfoFrom1ActivityToOther.this);

        radioGroup.setOnCheckedChangeListener(App44_InfoFrom1ActivityToOther.this);

        imgAnimal.setOnClickListener(App44_InfoFrom1ActivityToOther.this);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tiger_face);
        imgAnimal.setImageBitmap(bitmap);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode) {
            case IMAGE_REQUEST_CODE:
                if(resultCode == RESULT_OK) {
                    Log.i("LOG", "Inside onActivityResult - Got ok request code");
                    Uri chosenImage = data.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), chosenImage);
                        imgAnimal.setImageBitmap(bitmap);
                    }
                    catch(IOException ioEx) {
                        //TODO Auto-generated catch block
                        ioEx.printStackTrace();
                    }
                }
                else {
                    Log.i("LOG", "Inside onActivityResult - did not get ok request code");
                }
                break;

        }
    }



    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.btnAdd44:
                Intent intent = new Intent(App44_InfoFrom1ActivityToOther.this, App44_SecondActivity.class);
                intent.putExtra("Name", edtName.getText().toString());
                intent.putExtra("Email", edtEmail.getText().toString());
                intent.putExtra("User_Name", edtUsername.getText().toString());
                intent.putExtra("Password", edtPassword.getText().toString());
                intent.putExtra("Gender_Type", genderType);

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                intent.putExtra("Picture", byteArray);

                startActivity(intent);

                //finish(); //remove the activity from the memory
                break;
            case R.id.imgAnimal44:

                Intent intentImage = new Intent(Intent.ACTION_GET_CONTENT);
                intentImage.setType("image/*");
                startActivityForResult(intentImage, IMAGE_REQUEST_CODE);
                break;

        }

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.radioMale:
                genderType = "Male";
                break;
            case R.id.radioFemale:
                genderType = "Female";
                break;
        }

    }
}
