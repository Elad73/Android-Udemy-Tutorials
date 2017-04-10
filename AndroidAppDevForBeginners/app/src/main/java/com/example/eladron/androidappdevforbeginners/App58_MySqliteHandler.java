package com.example.eladron.androidappdevforbeginners;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.eladron.androidappdevforbeginners.Model.Computer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eladron on 19/02/2017.
 */

public class App58_MySqliteHandler extends SQLiteOpenHelper{

    //database version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "computer.db";

    //Computer table name
    private static final String TABLE_COMPUTER = "computers";

    //Computer Table Columns
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_COMPUTER_NAME = "computerName";
    private static final String COLUMN_COMPUTER_TYPE = "computerType";

    String CREATE_COMPUTER_TABLE = "CREATE TABLE " + TABLE_COMPUTER + "(" + COLUMN_ID +
            " INTEGER PRIMARY KEY, " + COLUMN_COMPUTER_NAME + " TEXT, " +
            COLUMN_COMPUTER_TYPE + " TEXT" + ")";

    //Constructors
    public App58_MySqliteHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_COMPUTER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPUTER);

        onCreate(db);
    }

    //All Database Operations: create, read, update, delete

    //create
    public void addComputer (Computer computer) {

        SQLiteDatabase db = this.getWritableDatabase(); //used whenever we want to write something to the database
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPUTER_NAME, computer.getComputerName());
        values.put(COLUMN_COMPUTER_TYPE, computer.getComputerType());

        db.insert(TABLE_COMPUTER, null, values);
        db.close();
    }

    //Getting a single computer
    public Computer getComputer (int id) {

        SQLiteDatabase db = this.getReadableDatabase(); //used whenever we want to read something from the database
        Cursor cursor = db.query(TABLE_COMPUTER, new String[] {COLUMN_ID, COLUMN_COMPUTER_NAME, COLUMN_COMPUTER_TYPE},
                COLUMN_ID + "=?", new String[] {String.valueOf(id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Computer computer = new Computer(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return computer;
    }

    //Getting all computer Objects
    public List<Computer> getAllComputers() {
        List<Computer> computerList = new ArrayList<>();

        String selectAllQuery = "SELECT * FROM " + TABLE_COMPUTER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAllQuery, null);
        if (cursor.moveToFirst()) {

            do {

                Computer computer = new Computer();
                computer.setId(Integer.parseInt(cursor.getString(0)));
                computer.setComputerName(cursor.getString(1));
                computer.setComputerType(cursor.getString(2));

                computerList.add(computer);
            }
            while (cursor.moveToNext());
        }

        return computerList;
    }

    //Updating a single computer
    public int updateComputer(Computer computer) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_COMPUTER_NAME, computer.getComputerName());
        values.put(COLUMN_COMPUTER_TYPE, computer.getComputerType());

        return db.update(TABLE_COMPUTER, values, COLUMN_ID + "=?", new String[] {String.valueOf(computer.getId())});
    }

    //Deleting a single computer
    public void deleteComputer(Computer computer) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COMPUTER, COLUMN_ID + "=?", new String[] {String.valueOf(computer.getId())});
        db.close();
    }

    //Getting the number of computers
    public int getComputersCount() {

        String computersCountQuery = "SELECT * FROM " + TABLE_COMPUTER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(computersCountQuery, null);
        cursor.close();

        return cursor.getCount();
    }

}
