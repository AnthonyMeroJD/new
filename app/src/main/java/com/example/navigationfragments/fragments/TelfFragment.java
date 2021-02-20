package com.example.navigationfragments.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationfragments.DetalleActivity;
import com.example.navigationfragments.adapters.ListaAdapter;
import com.example.navigationfragments.data.Marcas;
import com.example.navigationfragments.R;
import com.example.navigationfragments.entities.Telefono;

import java.util.ArrayList;
import java.util.List;

public class TelfFragment extends Fragment {

    private final String[] marcaTelefonos = {"Xiaomi", "Samsung", "Apple", "Huawei", "Nokia"};
    private String[] listaTelefonos = {};
    private ArrayAdapter<String> adapter;

    private ListaAdapter myAdapter;
    private List<Telefono> telefonos = new ArrayList<>();

    private ListView listView;
    private Spinner spinner;
    private TextView tvNoDisponible;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_telf, container, false);

        iniVistas(root);

        cargarSpinner();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Telefono telefono = telefonos.get(position);
                Intent intent = new Intent(getContext(), DetalleActivity.class);
                intent.putExtra("NOMBRE", telefono.getNombre());
                intent.putExtra("IMAGEN", telefono.getImagen());
                intent.putExtra("DESC", telefono.getDescripcion());
                intent.putExtra("PRECIO", telefono.getPrecio());
                startActivity(intent);
            }
        });
        return root;
    }

    private void iniVistas(View view){
        listView = view.findViewById(R.id.list_telfs);
        spinner = view.findViewById(R.id.spinner);
        tvNoDisponible = view.findViewById(R.id.tv_no_disponible);
    }

    private void cargarSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, marcaTelefonos);
        spinner.setAdapter(adapter);
        cargarTelefonos();
    }

    private void cargarTelefonos(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                telefonos.clear();
                if (parent.getItemAtPosition(position).equals("Xiaomi")){
                    telefonos = Marcas.Xiaomi();
                }
                if (parent.getItemAtPosition(position).equals("Samsung")){

                    telefonos = Marcas.Samsung();
                }
                if (parent.getItemAtPosition(position).equals("Apple")){

                    telefonos = Marcas.Apple();
                }
                if (parent.getItemAtPosition(position).equals("Huawei")){
                    telefonos = Marcas.Huawei();
                }
                if (parent.getItemAtPosition(position).equals("Nokia")){
                   telefonos = Marcas.Nokia();
                }

                myAdapter = new ListaAdapter(getContext(), R.layout.vista_telf, telefonos);
                listView.setAdapter(myAdapter);

                if (telefonos.size() == 0){
                    tvNoDisponible.setVisibility(View.VISIBLE);
                }else {
                    tvNoDisponible.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}
