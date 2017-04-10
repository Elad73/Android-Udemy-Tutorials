package com.example.eladron.app33_listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    String[] coursesNames = {"Android Developer Course", "iOS Developer Course", "Java Developer Course"};
    ArrayAdapter<String> adapter;
    ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.content_main, coursesNames);
        setListAdapter(adapter);

        ListView lstView = getListView();
        lstView.setOnItemClickListener(MainActivity.this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String itemValue = parent.getItemAtPosition(position).toString();
        Toast.makeText(MainActivity.this, itemValue, Toast.LENGTH_SHORT).show();
    }
}
