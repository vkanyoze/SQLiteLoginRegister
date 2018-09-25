package com.mrkanyoze.sqliteloginregister.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Victor Kanyoze on 9/25/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    private static String DBNAME = "login.db";
    private static int VERSION = 1;
    static final String USER_TABLE = "user_table";

    private SQLiteDatabase db;
    public DBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,EMAIL TEXT, PASSWORD TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        onCreate(db);

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+USER_TABLE, null);
        return res;
    }

    public void registerUser(String name, String email, String password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues newValues = new ContentValues();
        newValues.put("NAME", name);
        newValues.put("EMAIL", email);
        newValues.put("PASSWORD", password);
        db.insert(USER_TABLE, null, newValues);

    }
}
