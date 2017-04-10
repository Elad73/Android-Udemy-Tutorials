package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

/**
 * Created by eladron on 31/01/2017.
 */

public class App46_AnotherTypeHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app46_another_type_host);

        TabHost host = (TabHost) findViewById(R.id.tabHost2_46);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab one");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab One");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Tab Two");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Tab Three");
        host.addTab(spec);

    }
}
