package com.tcit.sqlitesample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    SQLiteDatabase readdata;
    SyncDBAdapter syncDBAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(getApplicationContext(), DatabaseHelper.DATABASE_NAME, null, DatabaseHelper.DATABASE_VERSION);
        readdata = dbHelper.getReadableDatabase();
        readdata = dbHelper.getWritableDatabase();
        syncDBAdapter = new SyncDBAdapter(this);
        syncDBAdapter.open();

        syncDBAdapter.insertRecords("Sample 1");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        readdata.close();
        syncDBAdapter.close();
    }
}