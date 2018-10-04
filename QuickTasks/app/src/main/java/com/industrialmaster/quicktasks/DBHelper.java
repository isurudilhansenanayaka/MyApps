package com.industrialmaster.quicktasks;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nadun Shyn on 9/30/2018.
 */

public class DBHelper extends SQLiteOpenHelper{

    public static final
    String TASK_CREATE_SQL = "CREATE TABLE tasks "+
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    " name TEXT, date TEXT, complete BOOLEAN)";

    public DBHelper(Context context) {
        super(context, "dbtasks", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TASK_CREATE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
