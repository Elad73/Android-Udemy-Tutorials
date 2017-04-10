package com.example.eladron.androidappdevforbeginners;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by eladron on 15/01/2017.
 */

public class App35_ExpandableListViewAdapter extends BaseExpandableListAdapter{

    String[] groupNames = { "Sport", "Computer", "Food", "Car", "TV"};
    String[][] groupChildNames = { {"Boxing", "Kick Boxing", "Judo", "Football", "Basketball"},
                              {"Desktop Computer", "Laptop Computer", "Smartphone Computer"},
                              {"Ice Cream", "Banana"},
                              {"Mercedes Benz"},
                              {"Samsung TV", "LG TV"}};

    Context context;

    //Constructors
    public App35_ExpandableListViewAdapter(Context context) {
        this.context = context;
    }

    //Abstract Methods Implementation
    @Override
    public int getGroupCount() {
        return groupNames.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupChildNames[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupChildNames[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupChildNames[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        TextView txtView = new TextView(context);
        txtView.setText(groupNames[groupPosition]);
        txtView.setPadding(100,0,0,0);
        txtView.setTextColor(Color.BLUE);
        txtView.setTextSize(40);

        return txtView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final TextView txtView = new TextView(context);
        txtView.setText(groupChildNames[groupPosition][childPosition]);
        txtView.setPadding(100,0,0,0);
        txtView.setTextColor(Color.RED);
        txtView.setTextSize(25);

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, txtView.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        return txtView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
