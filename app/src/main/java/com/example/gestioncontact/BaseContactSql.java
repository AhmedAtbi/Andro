package com.example.gestioncontact;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseContactSql extends SQLiteOpenHelper {
    public static final String file_name = "contactBase.db";
    public static int version =3;
    public static final String table_user= "User";
    public static final String col_id ="id";
    public static final String col_login="login";
    public static final String col_pwd= "pwd";
    public static final String table_contact= "Contact";
    public static final String col_idCon ="id";
    public static final String col_nom="nom";
    public static final String col_pre="prenom";
    public static final String col_num= "num";
    public static final String  col_user= "user";
    String req = null;
    String req1 = null;
    public BaseContactSql(@Nullable Context context) {
        super(context, file_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*req="create table "+table_user+" (" +
                col_id+" integer primary key  autoincrement , " +
                col_login+" text not null," +
                col_pwd+" text not null)";
        //execution de req
        db.execSQL(req);*/
        req1="create table "+table_contact+" (" +
                col_idCon+" integer primary key  autoincrement , " +
                col_nom+" text ," +
                col_pre+" text ," +
                col_num+" text  )";

               // col_num+" text not null," + " foreign key ("+col_user+")  references "+table_user+ "("+col_id+"))";
        //execution de req
        db.execSQL(req1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//update
        db.execSQL("drop table " +table_contact);
        //db.execSQL("drop table " +table_user);
        onCreate(db);
    }
}
