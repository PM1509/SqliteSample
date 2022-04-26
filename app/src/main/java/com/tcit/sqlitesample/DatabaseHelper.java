package com.tcit.sqlitesample;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SQLiteSample";
    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_TABLE_SYNC = "synctable";

    public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE_SYNC + "(Value TEXT)");

        } catch (SQLiteException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {

            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_SYNC);
            onCreate(db);

        } catch (SQLiteException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
