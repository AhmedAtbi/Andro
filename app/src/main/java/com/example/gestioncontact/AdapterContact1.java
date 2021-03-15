package com.example.gestioncontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

//afficher et creer les vu pour chaque donnée
public class AdapterContact1 extends ArrayAdapter
{

    public AdapterContact1(@NonNull Context context,  @NonNull List objects) {
        super(context, R.layout.view_contact, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TextView t = new TextView(con);
        //  t.setText(data.get(position).toString());
        //  return t;
        LayoutInflater inf = LayoutInflater.from(getContext());
        LinearLayout l = (LinearLayout) inf.inflate(R.layout.view_contact, null);
        //recuperation des composants
        TextView tvnom =l.findViewById(R.id.tv_nom);
        TextView tvprenom =l.findViewById(R.id.tv_prenom);
        TextView tvnum =l.findViewById(R.id.tv_num);
        Contact c = (Contact) getItem(position);
        tvnom.setText(c.nom);
        tvprenom.setText(c.prenom);
        tvnum.setText(c.num);

        return l;
    }

}

