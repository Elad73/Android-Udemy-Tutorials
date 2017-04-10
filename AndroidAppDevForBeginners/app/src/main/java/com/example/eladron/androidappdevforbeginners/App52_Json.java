package com.example.eladron.androidappdevforbeginners;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eladron.androidappdevforbeginners.Model.ItunesStuff;

public class App52_Json extends AppCompatActivity implements View.OnClickListener{


    TextView txtArtistName;
    TextView txtType;
    TextView txtKind;
    TextView txtCollectionName;
    TextView txtTrackName;
    ImageView imgArt;
    String imgURL;
    Button btnGatData;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app52_json);

        txtArtistName     = (TextView) findViewById(R.id.txtArtistName_app52);
        txtType           = (TextView) findViewById(R.id.txtType_app52);
        txtKind           = (TextView) findViewById(R.id.txtKind_app52);
        txtCollectionName = (TextView) findViewById(R.id.txtCollectionName_app52);
        txtTrackName      = (TextView) findViewById(R.id.txtTrackName_app52);
        imgArt            = (ImageView) findViewById(R.id.imgView_app52);
        btnGatData        = (Button) findViewById(R.id.btnGetJSON_app52);

        btnGatData.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        JSONItunesStuffTask jsonItunesStuffTask = new JSONItunesStuffTask(this);
        jsonItunesStuffTask.execute();
    }

    private class JSONItunesStuffTask extends AsyncTask<String, Void, ItunesStuff> {

        Context context;
        ProgressDialog progressDialog;

        public JSONItunesStuffTask(Context context) {

            this.context = context;
            progressDialog = new ProgressDialog(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setTitle("Downloading Info From Itunes....Please Wait");
            progressDialog.show();
        }

        @Override
        protected ItunesStuff doInBackground(String... params) {

            ItunesStuff itunesStuff = new ItunesStuff();
            ItunesHTTPClient itunesHTTPClient = new ItunesHTTPClient();
            String data = itunesHTTPClient.getItunesStuffData();

            try {
                itunesStuff = JsonItunesParser.getItunesStuff(data);
                imgURL = itunesStuff.getArtistViewURL();
                bitmap = itunesHTTPClient.getBitmapFromUrl(imgURL);
            }
            catch (Throwable t) {
                t.printStackTrace();
            }

            return itunesStuff;
        }

        @Override
        protected void onPostExecute(ItunesStuff itunesStuff) {
            super.onPostExecute(itunesStuff);

            txtArtistName.setText(itunesStuff.getArtistName());
            txtType.setText(itunesStuff.getType());
            txtKind.setText(itunesStuff.getKind());
            txtCollectionName.setText(itunesStuff.getCollectionName());
            txtTrackName.setText(itunesStuff.getTrackName());
            imgArt.setImageBitmap(bitmap);

            if (progressDialog.isShowing()) progressDialog.dismiss();
        }
    }


}
