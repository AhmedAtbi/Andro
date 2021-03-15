/*package com.example.gestioncontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserManager {
    SQLiteDatabase db;
    public static ArrayList<User> data = new ArrayList<User>();

    public UserManager(Context con) {
        BaseContactSql helper = new BaseContactSql(con,
                BaseContactSql.file_name,
                null,
                BaseContactSql.version);
        db = helper.getWritableDatabase();

    }

    public long ajoutUser(String login, String mdp) {
        ContentValues cv = new ContentValues();
        cv.put(BaseContactSql.col_login, login);
        cv.put(BaseContactSql.col_pwd, mdp);

        long a = db.insert(BaseContactSql.table_user, null, cv);
        return a;
    }

    public ArrayList<User> getAllContact() {

        Cursor cr = db.query(BaseContactSql.table_user, //table
                new String[]{BaseContactSql.col_id,
                        BaseContactSql.col_login,
                        BaseContactSql.col_pwd
                },//projection
                null,
                null,
                null,
                null,
                null
        );
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            int i = cr.getInt(0);
            String login = cr.getString(1);
            String pwd = cr.getString(2);

            data.add(new User(i, login, pwd));
            cr.moveToNext();
        }
        return data;

    }

    public void supprimerSelonId(int id) {

        db.delete(BaseContactSql.table_user, "id=?", new String[]{String.valueOf(id)});
    }



}*/
