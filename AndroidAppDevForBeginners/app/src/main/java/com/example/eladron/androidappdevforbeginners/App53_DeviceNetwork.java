package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class App53_DeviceNetwork extends AppCompatActivity implements View.OnClickListener {

    ImageView imgView;
    Button btnGetNetStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app53_device_network);


        imgView       = (ImageView) findViewById(R.id.imgNetworkType_app53);
        btnGetNetStat = (Button) findViewById(R.id.btnGetNetworkStatus_app53);

        btnGetNetStat.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int statusInfo = App53_NetworkInfo.getNetworkStatus(this);

        switch (statusInfo) {
            case 0:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.app53_mobile_internet));
                Toast.makeText(this, "Mobile Intenet", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.app53_wifi_internet));
                Toast.makeText(this, "Wifi Intenet", Toast.LENGTH_SHORT).show();
                break;
            default:
                imgView.setImageDrawable(getResources().getDrawable(R.drawable.app53_no_internet));
                Toast.makeText(this, "Unknown", Toast.LENGTH_SHORT).show();
                break;

        }



    }
}
