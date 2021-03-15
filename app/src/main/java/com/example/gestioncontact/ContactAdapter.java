package com.example.gestioncontact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    Context con;
    ArrayList<Contact>data ;

    public ContactAdapter(Context con, ArrayList<Contact> data) {
        this.con = con;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creation de vue
        LayoutInflater inf = LayoutInflater.from(con);
        View v = inf.inflate(R.layout.view_contact,parent, false);


        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //affectation des valeurs dans les holders
        Contact c =data.get(position);
        holder.tvnom.setText(c.getNom());
        holder.tvprenom.setText(c.getPrenom());
        holder.tvnum.setText(c.getNum());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvnom,tvprenom,tvnum;
        ImageButton btnCall , btnSms,btnMAp;
        public MyViewHolder(@NonNull View v) {
            super(v);
            //recuperation des composants
             tvnom = v.findViewById(R.id.tv_nom);
             tvprenom = v.findViewById(R.id.tv_prenom);
            tvnum = v.findViewById(R.id.tv_num);
            btnCall = v.findViewById(R.id.imgbtn_call_view);
            btnSms = v.findViewById(R.id.imgbtn_sms_view);


        }

        }
    }


