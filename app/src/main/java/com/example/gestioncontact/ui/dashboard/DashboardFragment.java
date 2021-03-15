package com.example.gestioncontact.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestioncontact.AdapterContact1;
import com.example.gestioncontact.Contact;
import com.example.gestioncontact.ContactAdapter;
import com.example.gestioncontact.ContactManager;
import com.example.gestioncontact.R;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    SearchView rech ;
    ArrayList<Contact> data_rech ;
    ArrayList<Contact> data;
    ContactManager cm;
    RecyclerView rc;
    ContactAdapter ad;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        rech = root.findViewById(R.id.sv_rech);
        rc = root.findViewById(R.id.recycler_contact);
         cm = new ContactManager (getContext());
         data =cm.getAllContact();
         ad = new ContactAdapter(getActivity(),data);
        GridLayoutManager l_manager = new GridLayoutManager(getContext(),2);
        rc.setLayoutManager(l_manager);
        //AdapterContact1 ad = new AdapterContact1(getActivity() , data);
        rc.setAdapter(ad);

        rech.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                data_rech= cm.RechercheContact(newText);
                //AdapterContact1 ad1 = new AdapterContact1(getContext(), data_rech);
                ContactAdapter ad = new ContactAdapter(getActivity(),data);
                rc.setAdapter(ad);

                return false;
            }
        });



        return root;
    }
}