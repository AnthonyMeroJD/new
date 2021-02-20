package com.example.navigationfragments;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.navigationfragments.fragments.AboutFragment;
import com.example.navigationfragments.fragments.RegistroFragment;
import com.example.navigationfragments.fragments.UsuariosFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityAdmin extends AppCompatActivity {
    RegistroFragment registroFragment=new RegistroFragment();
    UsuariosFragment usuariosFragment=new UsuariosFragment();
    AboutFragment aboutFragment = new AboutFragment();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_admin);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_admin);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_admin, registroFragment).commit();
    }



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_regClientes:
                            selectedFragment = registroFragment;
                            break;
                        case R.id.nav_busClientes:
                            selectedFragment = usuariosFragment;
                            break;

                        case R.id.nav_editClientes:
                            selectedFragment = aboutFragment;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_admin, selectedFragment).commit();

                    return true;
                }
            };



}

