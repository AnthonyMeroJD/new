package com.example.navigationfragments.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigationfragments.DetalleActivity;
import com.example.navigationfragments.Login;
import com.example.navigationfragments.MainActivityAdmin;
import com.example.navigationfragments.R;
import com.example.navigationfragments.Registro;
import com.example.navigationfragments.entities.Telefono;
import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.repo.Usuarios;

import es.dmoral.toasty.Toasty;

public class RegistroFragment extends Fragment {
    private EditText cedula;
    private EditText pass;
    private EditText ciudad;
    private EditText telefono;
    private EditText direccion;
    private EditText nombre;
    private Button btn;
    private Button btnCancelar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_registro, container, false);
        cedula=root.findViewById(R.id.ediTextCedulaActualizacion);
        pass=root.findViewById(R.id.editTextContrasenaActualizacion);
        ciudad=root.findViewById(R.id.editTextCiudadActualizacion);
        telefono=root.findViewById(R.id.editTextTelefonoRegistroActualizacion);
        direccion=root.findViewById(R.id.editTextDireccionActualizacion);
        nombre=root.findViewById(R.id.editTextNombreActualizacion);
        btn=root.findViewById(R.id.buttonGuardarDatosActualizacion);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario user=new Usuario(cedula.getText().toString(),nombre.getText().toString(),
                        pass.getText().toString(),ciudad.getText().toString(),telefono.getText().toString(),
                        direccion.getText().toString(),"Cliente");
                Usuarios.registrar(user, v.getContext());

                Toasty.success(v.getContext(),"Se creo el cliente correctamente",Toast.LENGTH_LONG).show();

                Intent intentAdmin = new Intent(v.getContext(), MainActivityAdmin.class);
                startActivity(intentAdmin);



            }
        });
        return root;
    }




}
