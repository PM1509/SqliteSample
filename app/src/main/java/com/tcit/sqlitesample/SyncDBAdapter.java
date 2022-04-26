package com.tcit.sqlitesample;
import static com.tcit.sqlitesample.DatabaseHelper.DATABASE_TABLE_SYNC;

import com.tcit.sqlitesample.DatabaseHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class SyncDBAdapter {

    DatabaseHelper dbHelper;
    SQLiteDatabase sqliteDB;
    Context context;

    public SyncDBAdapter(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context, DatabaseHelper.DATABASE_NAME, null, DatabaseHelper.DATABASE_VERSION);
    }

    public SyncDBAdapter open() throws SQLiteException {

        sqliteDB = dbHelper.getWritableDatabase();
        sqliteDB = dbHelper.getReadableDatabase();
        return this;

    }

    public SQLiteDatabase getDatabaseInstance() {
        return sqliteDB;

    }

    public void insertRecords(String Valuedata) {

        sqliteDB.execSQL("INSERT OR REPLACE INTO " + DATABASE_TABLE_SYNC + "(Value)VALUES('" + Valuedata + "')");

        String countQuery = "SELECT  * FROM " + DATABASE_TABLE_SYNC;
		sqliteDB = dbHelper.getReadableDatabase();
		Cursor cursor = sqliteDB.rawQuery(countQuery, null);
		cursor.moveToFirst();
		@SuppressLint("Range") String vals = cursor.getString(cursor.getColumnIndex("Value"));
		int count = cursor.getCount();
        Log.d("DataCount","Count123="+count);
        Log.d("DataCount","CountData="+vals);

    }

    public void close() {
        sqliteDB.close();

    }
}

