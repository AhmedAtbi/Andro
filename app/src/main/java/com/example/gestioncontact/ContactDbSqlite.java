package com.example.gestioncontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactDbSqlite extends SQLiteOpenHelper {

    public static String db_name = "contact_db";
    public static String table_name = "user";
    public static String col_1 = "id";
    public static String col_2 = "nom";
    public static String col_3 = "prenom";
    public static String col_4 = "num";
    public static String col_5 = "sex";
    public static int db_version = 1;
    public String req = null;




    public ContactDbSqlite(@Nullable Context context,  int version) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        req = "CREATE TABLE "+ table_name +" (" +
                col_1+" integer PRIMARY KEY, "+
                col_2+" varchar(255), "+
                col_3+" varchar(255), "+
                col_4+" varchar(255), "+
                col_5+" varchar(255))";
        db.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String deleteDb = "DROP TABLE IF EXISTS "+table_name;
        db.execSQL(deleteDb);
        onCreate(db);

    }




}
