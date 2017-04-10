package com.example.eladron.androidappdevforbeginners;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class App54_LocalNotifications extends AppCompatActivity implements View.OnClickListener {

    EditText edtTitle;
    EditText edtText;
    Button   btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app54_local_notifications);


        edtTitle  = (EditText) findViewById(R.id.edtContentTitle_app54);
        edtText   = (EditText) findViewById(R.id.edtContentText_app54);
        btnNotify = (Button) findViewById(R.id.btnNewButton_app54);

        btnNotify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if ( !(edtTitle.getText().toString().matches("") || edtText.getText().toString().matches("")) ) {
            showNotification();
        }
    }

    private void showNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.app54_image);
        builder.setContentText(edtText.getText().toString());
        builder.setContentTitle(edtTitle.getText().toString());

        //User Click on notification
        Intent intent = new Intent(this, this.getClass());

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify("MyNotify", 123, builder.build());

    }
}
