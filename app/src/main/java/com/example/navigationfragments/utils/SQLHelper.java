package com.example.navigationfragments.utils;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class SQLHelper  extends EnlaceBaseDatos{

    private static final String COMMENTS_TABLE_CREATE = "CREATE TABLE usuarios2(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " cedula TEXT, nombre TEXT, pass TEXT, numero TEXT, direccion TEXT, ciudad TEXT,rol Text," +
            "fecha_creacion DATE DEFAULT CURRENT_TIMESTAMP)";
    private static final String DB_NAME = "usuarios2.sqlite";
    private static final int DB_VERSION = 1;
    public SQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMENTS_TABLE_CREATE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(COMMENTS_TABLE_CREATE);
    }
}
