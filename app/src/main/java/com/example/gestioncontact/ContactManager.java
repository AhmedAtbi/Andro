package com.example.gestioncontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;

public class ContactManager {

    SQLiteDatabase db=null;


    public ContactManager(Context context)
    {
        ContactDbSqlite helper = new ContactDbSqlite(context,
                ContactDbSqlite.db_version);

        db = helper.getWritableDatabase();

    }

    public void ajouterContact (Contact contact)
    {
        ContentValues cv = new ContentValues();
        cv.put(ContactDbSqlite.col_2,contact.getNom());
        cv.put(ContactDbSqlite.col_3,contact.getPrenom());
        cv.put(ContactDbSqlite.col_4,contact.getNum());
        db.insert(ContactDbSqlite.table_name,
                null,
                cv);


    }



    public ArrayList<Contact> RechercheContact (String rech)
    {
        ArrayList<Contact> c = new ArrayList<>();
        String sql_getAll = "SELECT * FROM "+ ContactDbSqlite.table_name +" where "+ContactDbSqlite.col_2 +" like '"+rech+"%'";
        Cursor cursor = db.rawQuery(sql_getAll,null);
        if (cursor.moveToFirst())
        {
            do
            {
                int id = cursor.getInt(0);
                String nom = cursor.getString(1);
                String prenom = cursor.getString(2);
                String numero = cursor.getString(3);
                //String sex = cursor.getString(3);

                    c.add(new Contact (id,nom,prenom,numero));

            }while (cursor.moveToNext());

        }
        return c;

    }

    public ArrayList<Contact> getAllContact()
    {
        ArrayList<Contact> data_contact = new ArrayList<Contact>();

        Cursor myCursor = db.query(ContactDbSqlite.table_name,
                new String[]{ContactDbSqlite.col_1,
                        ContactDbSqlite.col_2,
                        ContactDbSqlite.col_3,
                        ContactDbSqlite.col_4,
                        ContactDbSqlite.col_5},
                null,
                null,
                null,
                null,
                null);

        myCursor.moveToFirst();

        while (! myCursor.isAfterLast()) {
            int i = myCursor.getInt(0);
            String nom = myCursor.getString(1);
            String prenom = myCursor.getString(1);
            String numero = myCursor.getString(2);
            String sex = myCursor.getString(3);

            data_contact.add(new Contact(nom, prenom, numero));
            myCursor.moveToNext();
        }

        return data_contact;

    }

    public void UpdateContact (Contact c)
    {
        ContentValues data = new ContentValues();
        data.put(ContactDbSqlite.col_2,c.getNom());
        data.put(ContactDbSqlite.col_3,c.getPrenom());
        data.put(ContactDbSqlite.col_4,  c.getNum());
        db.update("contacts",data,"id = ?",new String[]{String.valueOf(c.getId())});
    }

    public void removePosition (int id)
    {
        ContentValues data = new ContentValues();
        db.delete(ContactDbSqlite.table_name,ContactDbSqlite.col_1+" = ?",new String[]{String.valueOf(id)});

    }



}
