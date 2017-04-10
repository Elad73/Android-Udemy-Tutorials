package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by eladron on 06/02/2017.
 */

public class App51_PreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.app51_preferences_file);

    }
}
