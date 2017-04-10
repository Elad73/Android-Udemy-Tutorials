package com.example.eladron.androidappdevforbeginners;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by eladron on 09/01/2017.
 */

public class AppsMenuActivity extends ListActivity implements AdapterView.OnItemClickListener{
    int numberOfApps = 60;
    ArrayAdapter<String> adapter;
    Class[] appsArray = {UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,UnderConstruction.class,
            UnderConstruction.class,UnderConstruction.class,App34_CustomizedListViewActivity.class,App35_ExpandableListViewActivity.class,
            App36_GridViewActivity.class,App37_GalleryAndScrollViewActivity.class, App38_ImageSwitcherActivity.class, App39_FlipImageActivity.class,
            App40_TextSwitcher.class, App41_CheckboxRadiobuttonRatingbarSeekbar.class, App42_Contacts.class, App43_SDCard_Permissions.class,
            App44_InfoFrom1ActivityToOther.class, App45_AccessPhoneServices.class, App46_UsingTabHost.class, App47_Fonts.class,
            App48_UsingMenu.class, App49_DownloadImageFromInternet.class, App50_SharedPrefences.class, App51_UsingPreferences.class,
            App52_Json.class, App53_DeviceNetwork.class, App54_LocalNotifications.class, App55_LandscapeUI.class,
            App56_SaveAndRestoreInfo.class, App57_PassDataFrom2To1Activity.class, App58_Sqlite.class, App59_BiggerScreensAndLocalization.class,
            App60_TipAndSavingCalculator.class};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] appsNames = new String[numberOfApps];
        for(int i=0; i<numberOfApps; i++) {
            int strIndex = appsArray[i].toString().indexOf("_");
            if (strIndex >=0 )
                strIndex += 1;
            else
                strIndex = appsArray[i].toString().indexOf("beginners") + 10; //the beginners index + 10 chars

            String seperatedWords = seperateWord(appsArray[i].toString().substring(strIndex));
            //appsNames[i] = "App" + (i+1) + " - " + appsArray[i].toString().substring(strIndex);
            appsNames[i] = "App" + (i+1) + " - " + seperatedWords;
        }
        adapter = new ArrayAdapter<String>(AppsMenuActivity.this, R.layout.content_apps_menu, appsNames);

        setListAdapter(adapter);

        ListView lstView = getListView();

        FrameLayout.LayoutParams lay = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        lay.gravity = Gravity.CENTER_HORIZONTAL;
        lstView.setLayoutParams(lay);
        lstView.setOnItemClickListener(AppsMenuActivity.this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String itemValue = parent.getItemAtPosition(position).toString();
        Intent intent = new Intent();

        try {

            intent.setClass(this, appsArray[position]);
            startActivity(intent);
        }
        catch(Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG);
        }
    }

    private String seperateWord(String str) {

        String seperatedWords = "";
        short beginIndex = 0;
        boolean firstCapital = true;
        boolean multipleWords = false;
        for (short i=0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                if (!firstCapital) {
                    seperatedWords += " " + str.substring(beginIndex, i);
                    beginIndex = i;
                    multipleWords = true;
                }
                else {
                    firstCapital = false;
                }
            }
        }

        return seperatedWords += " " + str.substring(beginIndex);

    }
}
