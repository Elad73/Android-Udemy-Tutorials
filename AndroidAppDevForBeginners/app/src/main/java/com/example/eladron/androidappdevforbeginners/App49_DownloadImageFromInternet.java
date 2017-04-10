package com.example.eladron.androidappdevforbeginners;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class App49_DownloadImageFromInternet extends AppCompatActivity implements View.OnClickListener {

    ImageView imgView;
    Button btnDownload;
    String urlToDownload = "https://crackberry.com/sites/crackberry.com/files/styles/large/public/topic_images/2013/ANDROID.png?itok=xhm7jaxS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app49_download_image_from_internet);


        imgView = (ImageView) findViewById(R.id.imgView_app49);
        btnDownload = (Button) findViewById(R.id.btnDownloadImage_app49);

        btnDownload.setOnClickListener(App49_DownloadImageFromInternet.this);
    }

    @Override
    public void onClick(View v) {

        DownloadImageTask dwnImgTask = new DownloadImageTask(App49_DownloadImageFromInternet.this);
        dwnImgTask.execute(urlToDownload);

    }

    //Inner class
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        ProgressDialog progressDialog;
        Context context;

        public DownloadImageTask(Context context) {

            this.context = context;
            progressDialog = new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("Downloading Image.... Please Wait");
            progressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            String stringUrl = params[0];
            Bitmap bitmap = null;

            try {

                URL url = new URL(stringUrl);
                InputStream inputStream = url.openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            }
            catch (Exception ex) {

            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            imgView.setImageBitmap(bitmap);

            if(progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }
}
