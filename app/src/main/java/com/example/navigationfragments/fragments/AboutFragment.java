package com.example.navigationfragments.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationfragments.Login;
import com.example.navigationfragments.MainActivity;
import com.example.navigationfragments.R;
import com.example.navigationfragments.Registro;

import es.dmoral.toasty.Toasty;

public class AboutFragment extends Fragment {
    private Button btnSalir;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about, container, false);

        btnSalir=root.findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.info(v.getContext(),"Hasta la proxima!", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(v.getContext(), Login.class);
                startActivity(i);
            }
        });
        return  root;
    }
}
