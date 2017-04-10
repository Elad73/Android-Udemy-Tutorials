package com.example.eladron.androidappdevforbeginners;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class App46_UsingTabHost extends ActivityGroup implements View.OnClickListener {

    Button btnJumpTo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app46_using_tab_host);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost_46);
        tabHost.setup(getLocalActivityManager());

        btnJumpTo2 = (Button) findViewById(R.id.btnJumpTo2_46);
        btnJumpTo2.setOnClickListener(App46_UsingTabHost.this);


        //Tab 1
        TabHost.TabSpec spec = tabHost.newTabSpec("One");
        spec.setIndicator("Tab One");
        Intent intentTab1 = new Intent(App46_UsingTabHost.this, App46_FirstTabActivity.class);
        spec.setContent(intentTab1);
        tabHost.addTab(spec);

        //Tab 2
        spec = tabHost.newTabSpec("Two");
        spec.setIndicator("", getResources().getDrawable(R.drawable.tiger_face));
        Intent intentTab2 = new Intent(App46_UsingTabHost.this, App46_SecondTabActivity.class);
        spec.setContent(intentTab2);
        tabHost.addTab(spec);

        //Tab 3
        spec = tabHost.newTabSpec("Three");
        spec.setIndicator("Tab Three");
        Intent intentTab3 = new Intent(App46_UsingTabHost.this, App46_ThirdTabActivity.class);
        spec.setContent(intentTab3);
        tabHost.addTab(spec);


    }

    @Override
    public void onClick(View v) {

        try {
            Intent intentJumpTo2 = new Intent();
            intentJumpTo2.setClass(App46_UsingTabHost.this, App46_AnotherTypeHostActivity.class);
            startActivity(intentJumpTo2);
        }
        catch(Exception ex) {
            Log.i("App46", ex.toString() );
        }
    }
}
