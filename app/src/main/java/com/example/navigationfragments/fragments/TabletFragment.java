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
import com.example.navigationfragments.R;
import com.example.navigationfragments.adapters.ListaAdapter;
import com.example.navigationfragments.data.Marcas;
import com.example.navigationfragments.entities.Telefono;

import java.util.ArrayList;
import java.util.List;

public class TabletFragment extends Fragment {

    private final String[] marcaTablets = {"Xiaomi", "Samsung", "Apple", "Huawei"};
    private String[] listaTablets = {};
    private ArrayAdapter<String> adapter;
    private ListaAdapter myAdapter;
    private List<Telefono> tablets = new ArrayList<>();
    private ListView listView;
    private Spinner spinner;
    private TextView tvNoDisponible;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.fragment_tablet, container, false);

        iniVistas(root);

        cargarSpinner();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Telefono telefono = tablets.get(position);
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
        listView = view.findViewById(R.id.list_tablets);
        spinner = view.findViewById(R.id.spinnerTablets);
        tvNoDisponible = view.findViewById(R.id.tb_no_disponible);
    }

    private void cargarSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, marcaTablets);
        spinner.setAdapter(adapter);
        cargarTelefonos();
    }

    private void cargarTelefonos(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tablets.clear();
                if (parent.getItemAtPosition(position).equals("Xiaomi")){
                    tablets = Marcas.XiaomiTablets();
                }
                if (parent.getItemAtPosition(position).equals("Samsung")){

                    tablets = Marcas.SamsungTablets();
                }
                if (parent.getItemAtPosition(position).equals("Apple")){

                    tablets = Marcas.Apple();
                }
                if (parent.getItemAtPosition(position).equals("Huawei")){
                    tablets = Marcas.HuaweiTablets();
                }

                myAdapter = new ListaAdapter(getContext(), R.layout.vista_telf, tablets);
                listView.setAdapter(myAdapter);

                if (tablets.size() == 0){
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
