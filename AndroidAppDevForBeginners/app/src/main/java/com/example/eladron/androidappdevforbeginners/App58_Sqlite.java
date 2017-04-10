package com.example.eladron.androidappdevforbeginners;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.eladron.androidappdevforbeginners.Model.Computer;

import java.util.ArrayList;
import java.util.List;

public class App58_Sqlite extends AppCompatActivity implements View.OnClickListener {

    EditText edtComputerNAme, edtComputerType;
    Button   btnAdd, btnDelete;
    ListView lstView;
    int      computerIndex = 0;

    List<Computer>        allComputers;
    ArrayList<String>     computerNames;
    App58_MySqliteHandler databaseHandler;
    ArrayAdapter          adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app58_sqlite);

        edtComputerNAme = (EditText) findViewById(R.id.editComputerName_app58);
        edtComputerType = (EditText) findViewById(R.id.editComputerType_app58);

        btnAdd    = (Button) findViewById(R.id.btnAdd_app58);
        btnDelete = (Button) findViewById(R.id.btnDel_app58);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        lstView = (ListView) findViewById(R.id.lstView_app58);

        databaseHandler = new App58_MySqliteHandler(this);
        allComputers = databaseHandler.getAllComputers();
        computerNames = new ArrayList<>();

        if (allComputers.size() > 0) {

            for (int i=0; i < allComputers.size(); i++) {
                Computer computer = allComputers.get(i);
                computerNames.add(computer.getComputerName() + " - " + computer.getComputerType());
            }
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, computerNames);
        lstView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnAdd_app58:
                if (!isValidEditTexts()) return;
                Computer computer = new Computer(edtComputerNAme.getText().toString(), edtComputerType.getText().toString());
                allComputers.add(computer);
                databaseHandler.addComputer(computer);
                computerNames.add(computer.getComputerName() + " - " + computer.getComputerType());
                cleanEditTexts();
                break;
            case R.id.btnDel_app58:
                if (allComputers.size() > 0) {
                    computerNames.remove(0);
                    databaseHandler.deleteComputer(allComputers.get(0));
                    allComputers.remove(0);
                }
                else return;
                break;
        }

        adapter.notifyDataSetChanged();
    }

    private boolean cleanEditTexts() {

        edtComputerNAme.setText("");
        edtComputerType.setText("");

        return true;
    }

    private boolean isValidEditTexts() {

        if (edtComputerNAme.getText().toString().matches("") || edtComputerType.getText().toString().matches("")) {
            return false;
        }
        else {
            return true;
        }
    }
}
