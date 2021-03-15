package com.example.gestioncontact;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.gestioncontact.ui.dashboard.DashboardFragment;
import com.example.gestioncontact.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
TextView login;
TextInputLayout mdp;
Button btn_quit, btn_val;
    SharedPreferences share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.edt_name_auth);
        mdp = findViewById(R.id.edt_mdp_auth);
        btn_quit = findViewById(R.id.btn_qt);
        btn_val = findViewById(R.id.btn_val);

            btn_val.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
            });
        share = getSharedPreferences("shared", Context.MODE_PRIVATE);
        shared();
    }
public void shared ()
{
    if(share.contains("login"))
    {
        if (share.getBoolean("login",true))
        {
            Intent i = new Intent(Login.this, MainActivity.class )  ;
            startActivity(i);
        }

    }
    else
    {
        share.edit().putBoolean("login",false).apply();

    } }

}
