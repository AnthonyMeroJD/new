package com.example.navigationfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.navigationfragments.R;
import com.example.navigationfragments.Registro;
import com.example.navigationfragments.fragments.AboutFragment;
import com.example.navigationfragments.fragments.TelfFragment;
import com.example.navigationfragments.fragments.HomeFragment;
import com.example.navigationfragments.fragments.TabletFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    Registro registroFragment=new Registro();
    HomeFragment inicio = new HomeFragment();
    TelfFragment telefonos = new TelfFragment();
    TabletFragment tablets = new TabletFragment();
    AboutFragment about = new AboutFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, inicio).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_home:
                            selectedFragment = inicio;
                            break;
                        case R.id.nav_telfs:
                            selectedFragment = telefonos;
                            break;
                        case R.id.nav_tablets:
                            selectedFragment = tablets;
                            break;
                        case R.id.nav_cliente:
                            selectedFragment = about;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };



}