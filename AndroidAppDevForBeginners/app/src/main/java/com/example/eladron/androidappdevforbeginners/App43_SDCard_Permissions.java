package com.example.eladron.androidappdevforbeginners;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * Created by eladron on 23/01/2017.
 */

public class App43_SDCard_Permissions extends AppCompatActivity implements View.OnClickListener, ViewSwitcher.ViewFactory{

    Button btnDownloadDir;
    Button btnMusicDir;
    Button btnDocumentsFolder;
    Button btnRingtonesFolder;
    Button btnPodcastFolderFolder;
    Button btnMoviesFolder;
    Button btnAlarmsFolder;
    Button btnPicturesFolder;
    Button btnSaveFile;
    Button btnRetrieveInfo;
    Button btnAllowAccessPictures;

    EditText edtValue;
    TextView txtValue;

    ImageView imgDragon;
    ImageSwitcher imgSwitcher;

    LinearLayout linearLayoutHorizontal;

    public static final int REQUEST_CODE = 1234;

    String sdfileName = "NiceFile.txt";

    ArrayList<String> filePathNames;
    File[] files;



    @Override
    public View makeView() {
        ImageView imgView = new ImageView(App43_SDCard_Permissions.this);
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        imgView.setLayoutParams(new ImageSwitcher.LayoutParams(1000,1000));

        return imgView;
    }


    //region @Override Methods
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app43_sdcard_permissions);

        App43_SDCardChecker.checkWeatherExternalStorageAvailableOrNot(App43_SDCard_Permissions.this);
        isStoragePermissionGranted();

        btnDownloadDir = (Button) findViewById(R.id.btnDownloadDir);
        btnMusicDir = (Button) findViewById(R.id.btnMusicDir);
        btnDocumentsFolder = (Button) findViewById(R.id.btnDocumentsFolder);
        btnRingtonesFolder = (Button) findViewById(R.id.btnRingtonesFolder);
        btnPodcastFolderFolder = (Button) findViewById(R.id.btnPodcastFolderFolder);
        btnMoviesFolder = (Button) findViewById(R.id.btnMoviesFolder);
        btnAlarmsFolder = (Button) findViewById(R.id.btnAlarmsFolder);
        btnPicturesFolder = (Button) findViewById(R.id.btnPicturesFolder);
        btnSaveFile = (Button) findViewById(R.id.btnSvaeFile);
        btnRetrieveInfo = (Button) findViewById(R.id.btnRetrieveInfo);
        btnAllowAccessPictures = (Button) findViewById(R.id.btnAllowAccessPictures);

        edtValue = (EditText) findViewById(R.id.edtValue);
        txtValue = (TextView) findViewById(R.id.txtValue);

        imgDragon = (ImageView) findViewById(R.id.imgDragon);
        imgSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);
        imgSwitcher.setFactory(App43_SDCard_Permissions.this);
        imgSwitcher.setInAnimation(AnimationUtils.loadAnimation(App43_SDCard_Permissions.this,
                        android.R.anim.slide_in_left));
        imgSwitcher.setOutAnimation(AnimationUtils.loadAnimation(App43_SDCard_Permissions.this,
                        android.R.anim.slide_out_right));

        linearLayoutHorizontal = (LinearLayout) findViewById(R.id.linearLayoutHorizontal43);

        btnAllowAccessPictures.setOnClickListener(App43_SDCard_Permissions.this);
         /*       new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isStoragePermissionGranted()) {
                    filePathNames = new ArrayList<String>();
                    File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "DragonImages");
                    if(filePath.isDirectory() && filePath != null) {
                        files = filePath.listFiles();

                        for(int index=0; index<files.length; index++) {
                            filePathNames.add(files[index].getAbsolutePath());
                        }
                    }

                    for(int index=0; index<filePathNames.size(); index++) {
                        final ImageView imageView = new ImageView(App43_SDCard_Permissions.this);
                        imageView.setImageURI(Uri.parse(filePathNames.get(index)));
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(500,500));

                        final int i = index;
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                imgSwitcher.setImageURI(Uri.parse(filePathNames.get(i)));
                            }
                        });

                        linearLayoutHorizontal.addView(imageView);
                    }
                }

            }
        });*/

        btnDownloadDir.setOnClickListener(App43_SDCard_Permissions.this);
        btnMusicDir.setOnClickListener(App43_SDCard_Permissions.this);
        btnDocumentsFolder.setOnClickListener(App43_SDCard_Permissions.this);
        btnRingtonesFolder.setOnClickListener(App43_SDCard_Permissions.this);
        btnPodcastFolderFolder.setOnClickListener(App43_SDCard_Permissions.this);
        btnMoviesFolder.setOnClickListener(App43_SDCard_Permissions.this);
        btnAlarmsFolder.setOnClickListener(App43_SDCard_Permissions.this);
        btnPicturesFolder.setOnClickListener(App43_SDCard_Permissions.this);
        btnSaveFile.setOnClickListener(App43_SDCard_Permissions.this);
        btnRetrieveInfo.setOnClickListener(App43_SDCard_Permissions.this);
        btnAllowAccessPictures.setOnClickListener(App43_SDCard_Permissions.this);
        imgDragon.setOnClickListener(App43_SDCard_Permissions.this);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.v("LOG", "Permission: " + permissions[0] + "was " +grantResults[0]);
            //resume tasks needing this permission
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnDownloadDir:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_DOWNLOADS, "Nice Downloads!!!");
                break;
            case R.id.btnMusicDir:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_MUSIC, "Nice Music!!!");
                break;
            case R.id.btnDocumentsFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_DOCUMENTS, "Nice Documents!!!");
                break;
            case R.id.btnRingtonesFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_RINGTONES, "Nice Ringtones!!!");
                break;
            case R.id.btnPodcastFolderFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_PODCASTS, "Nice Podcasts!!!");
                break; case R.id.btnMoviesFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_MOVIES, "Nice Movies!!!");
                break;
            case R.id.btnAlarmsFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_ALARMS, "Nice Alarms!!!");
                break;
            case R.id.btnPicturesFolder:
                returnStorageDirectoryForFolderName(Environment.DIRECTORY_PICTURES, "Nice Pictures!!!");
                break;
            case R.id.btnSvaeFile:
                letsSaveFileToDocumentsFolder();
                break;
            case R.id.btnRetrieveInfo:
                letsRetrieveFileDataFromDocumentsFolder();
                break;
            case R.id.imgDragon:
                letsSaveTheImagetoPicturesFolder();
                break;
            case R.id.btnAllowAccessPictures:
                if(isStoragePermissionGranted()) {
                    filePathNames = new ArrayList<String>();
                    File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "DragonImages");
                    if (filePath.isDirectory() && filePath != null) {
                        files = filePath.listFiles();

                        for (int index = 0; index < files.length; index++) {
                            filePathNames.add(files[index].getAbsolutePath());
                        }
                    }

                    for (int index = 0; index < filePathNames.size(); index++) {
                        final ImageView imageView = new ImageView(App43_SDCard_Permissions.this);
                        imageView.setImageURI(Uri.parse(filePathNames.get(index)));
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(500, 500));

                        final int i = index;
                        imageView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                imgSwitcher.setImageURI(Uri.parse(filePathNames.get(i)));
                            }
                        });

                        linearLayoutHorizontal.addView(imageView);
                    }
                }
                break;

        }

    }
    //endregion

    //region Methods
    public boolean isStoragePermissionGranted() {

        if(Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                Log.v("LOG", "Permission is granted");
                return true;
            }
            else {
                Log.v("LOG", "Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk <23 upon installation
            Log.v("LOG", "Permission is granted");
            return true;

        }
    }

    public File returnStorageDirectoryForFolderName(String directoryName, String nameOFFolder) {

        File filePath = new File(Environment.getExternalStoragePublicDirectory(directoryName), nameOFFolder);

        if (!filePath.mkdirs()) {
            letsCreateAToast("There can not be such directory - " +  nameOFFolder + " in SDCard");
        }
        else {
            letsCreateAToast("Your folder is created and its name is: " + nameOFFolder);
        }

        return filePath;
    }

    public void letsCreateAToast(String str) {
        Toast.makeText(App43_SDCard_Permissions.this, str, Toast.LENGTH_LONG).show();
    }

    public void letsSaveFileToDocumentsFolder() {

        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), sdfileName);

        try {

            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append(edtValue.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();
            letsCreateAToast("Saved");
        }
        catch (Exception e) {
            Log.i("LOG", e.toString());
            letsCreateAToast("Exception occured Check the Log for more info");
        }
    }

    public void letsRetrieveFileDataFromDocumentsFolder() {

        File filePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), sdfileName);

        try {

            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String fileData = "";
            String bufferData = "";
            while ( (fileData = bufferReader.readLine()) != null) {
                bufferData = bufferData + fileData + "\n";
            }

            txtValue.setText(bufferData);

            bufferReader.close();
        }
        catch (Exception ex) {

            Log.i("LOG", ex.getMessage());
            letsCreateAToast(ex.getMessage());
        }
    }

    public void letsSaveTheImagetoPicturesFolder() {

        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dragon6);
            File filePath = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES), "dragon_6.png");
            OutputStream outputStream = new FileOutputStream(filePath);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
            letsCreateAToast("Your image has been successfully saved");
        }
        catch (Exception ex) {
            Log.i("LOG", ex.getMessage());
            letsCreateAToast(ex.getMessage());
        }
    }
    //endregion
}
