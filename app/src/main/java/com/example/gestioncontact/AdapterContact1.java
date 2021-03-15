package com.example.gestioncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.util.ArrayList;

//afficher et creer les vu pour chaque donnée
public class AdapterContact1 extends BaseAdapter
{
    Context con;

    ArrayList<Contact> data;

    public AdapterContact1(Context con , ArrayList<Contact> data ) {
        this.con = con;
        this.data = data;
    }


    @Override
    public int getCount()
    {
        return data.size(); //nbre des vue cree
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TextView t = new TextView(con);
        //  t.setText(data.get(position).toString());
        //  return t;
        LayoutInflater inf = LayoutInflater.from(con);
        LinearLayout l = (LinearLayout) inf.inflate(R.layout.view_contact, null);
        //recuperation des composants
        TextView tvnum =l.findViewById(R.id.tv_nom);
        TextView tvlat =l.findViewById(R.id.tv_prenom);
        TextView tvlong =l.findViewById(R.id.tv_num);
        Contact c =data.get(position);
        tvnum.setText(c.nom);
        tvlong.setText(c.prenom);
        tvlat.setText(c.num);

        return l;
    }

}

