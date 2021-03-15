package com.example.gestioncontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContactManager {
    SQLiteDatabase db;
    BaseContactSql helper;
    public static ArrayList<Contact> data = new ArrayList<Contact>();
    public ContactManager(Context con)
    {
       BaseContactSql helper = new BaseContactSql(con);
        db=helper.getWritableDatabase();

    }
    public void ajoutContact(String nom , String prenom , String num)
    {
        ContentValues cv = new ContentValues();
        cv.put(BaseContactSql.col_nom,nom);
        cv.put(BaseContactSql.col_pre,prenom);
        cv.put(BaseContactSql.col_num,num);
        db.insert(BaseContactSql.table_contact,null,cv);

    }
    public ArrayList<Contact> getAllContact()
    {
        String req = "select * from "+ BaseContactSql.table_contact;


        Cursor cr = db.rawQuery(req,null);
        if (cr.moveToFirst()){
        while (! cr.isAfterLast())
        {
            int i = cr.getInt(0);
            String nom = cr.getString(1);
            String pre = cr.getString(2);
            String num = cr.getString(3);
            data.add(new Contact(i,nom,pre,num));
            cr.moveToNext();
        }}
        return data;

    }
   public void   supprimerSelonId(int id)
    {

db.delete(BaseContactSql.table_contact,"id=?",new String[]{String.valueOf(id)});
    }
    public ArrayList<Contact> rechercher(String nom) {

        String req="select * from "+BaseContactSql.table_contact+" where "+BaseContactSql.col_nom + " like "+nom;
        Cursor cr = db.rawQuery(req,null);
       if ( cr.moveToFirst())
       {
        while (! cr.isAfterLast())
        {
            int i = cr.getInt(0);
            String nomC = cr.getString(1);
            String pre = cr.getString(2);
            String num = cr.getString(3);
            data.add(new Contact(i,nomC,pre,num));
            cr.moveToNext();
        }}
       return  data;
    }
}
