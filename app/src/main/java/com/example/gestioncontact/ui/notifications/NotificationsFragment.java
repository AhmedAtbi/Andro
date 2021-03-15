package com.example.gestioncontact.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gestioncontact.Contact;
import com.example.gestioncontact.ContactManager;
import com.example.gestioncontact.R;

public class NotificationsFragment extends Fragment {

    private TextView nom,prenom,num;
    private Button btn_quit,btn_val;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        nom= root.findViewById(R.id.modif_nom);
        prenom = root.findViewById(R.id.modif_prenom);
        num=root.findViewById(R.id.modif_num);
        btn_quit=root.findViewById(R.id.btn_qt);
        btn_val=root.findViewById(R.id.btn_val);

        Contact c = new Contact(nom.getText().toString() , prenom.getText().toString(), num.getText().toString());
        ContactManager cm = new ContactManager(getActivity());
        cm.ajoutContact(nom.getText().toString() , prenom.getText().toString(), num.getText().toString());

        return root;
    }
}