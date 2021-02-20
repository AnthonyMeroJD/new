package com.example.navigationfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.fragments.UsuariosFragment;
import com.example.navigationfragments.repo.Usuarios;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class DialogEditar extends BottomSheetDialogFragment {
    private EditText cedula;
    private EditText pass;
    private EditText ciudad;
    private EditText telefono;
    private EditText direccion;
    private EditText nombre;
    private Button btn;
    private Button btnCancelar;
    private String ci;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_registro, container, false);
        cedula=root.findViewById(R.id.ediTextCedulaActualizacion);
        pass=root.findViewById(R.id.editTextContrasenaActualizacion);
        ciudad=root.findViewById(R.id.editTextCiudadActualizacion);
        telefono=root.findViewById(R.id.editTextTelefonoRegistroActualizacion);
        direccion=root.findViewById(R.id.editTextDireccionActualizacion);
        nombre=root.findViewById(R.id.editTextNombreActualizacion);
        btn=root.findViewById(R.id.buttonGuardarDatosActualizacion);
        return  root;

    }


    @Override
    public void onStart() {
        super.onStart();


         ci= null;
        if (getArguments() != null) {

            ci = getArguments().getString("cedula");
            try {

                Usuario user= Usuarios.getUserByCi(getContext(),ci);
                System.out.println(user.getTelefono());
                cedula.setText(ci, TextView.BufferType.EDITABLE);
                pass.setText(user.getPassword(), TextView.BufferType.EDITABLE);
                ciudad.setText(user.getCiudad(), TextView.BufferType.EDITABLE);
                telefono.setText(user.getTelefono(), TextView.BufferType.EDITABLE);
                direccion.setText(user.getDireccion(), TextView.BufferType.EDITABLE);
                nombre.setText(user.getNombre(), TextView.BufferType.EDITABLE);
            }catch (Exception e){
                Toasty.error(getContext(), "algo inesperado ocurrio", Toast.LENGTH_LONG).show();
            }

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Usuario userA= Usuarios.getUserByCi(getContext(),ci);
                    Usuario user=new Usuario(cedula.getText().toString(),nombre.getText().toString(),
                            pass.getText().toString(),ciudad.getText().toString(),telefono.getText().toString(),
                            direccion.getText().toString(),userA.getRol());
                    Usuarios.EditarUsuario(getContext(),ci,user);
                    Toasty.success(v.getContext(),"se actualizo los datos correctamente",Toast.LENGTH_LONG).show();
                    Intent intentAdmin = new Intent(v.getContext(), MainActivityAdmin.class);
                    startActivity(intentAdmin);



                }
            });

        }



    }
}
