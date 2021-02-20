package com.example.navigationfragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationfragments.R;
import com.example.navigationfragments.adapters.UsersAdapter;
import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.repo.Usuarios;

import java.util.ArrayList;
import java.util.List;

public class UsuariosFragment  extends Fragment {

    private UsersAdapter myAdapter;
    private EditText busqueda;
    private RecyclerView listView;
    private List<Usuario> usuarios = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_usuarios, container, false);
        listView = root.findViewById(R.id.rVListaConsulta);
        usuarios=Usuarios.getAllUsers(root.getContext());
        busqueda = root.findViewById(R.id.txtInputBusqueda);
        fillListView(root.getContext());
        busqueda.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (s.length()>0){
                    try {
                        usuarios=Usuarios.getUsersByLikeCedula(root.getContext(),s.toString());

                        if (usuarios.size()>0){
                            fillListView(root.getContext());
                        }}catch (Exception e){

                    }
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()>0){
                    try {
                        usuarios=Usuarios.getUsersByLikeCedula(root.getContext(),s.toString());

                        if (usuarios.size()>0){
                            fillListView(root.getContext());
                        }}catch (Exception e){

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length()>0){
                    try {
                        usuarios=Usuarios.getUsersByLikeCedula(root.getContext(),s.toString());

                        if (usuarios.size()>0){
                            fillListView(root.getContext());
                        }}catch (Exception e){

                    }
                }
            }
        });


        return root;
    }


    public void fillListView(Context context){
        listView.setLayoutManager(new LinearLayoutManager(context));
        myAdapter = new UsersAdapter(this, context ,usuarios);
        listView.setAdapter(myAdapter);
    }


}
