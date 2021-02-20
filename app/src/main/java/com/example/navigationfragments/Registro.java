package com.example.navigationfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.repo.Usuarios;

import es.dmoral.toasty.Toasty;

public class Registro extends AppCompatActivity {
    private EditText cedula;
    private EditText pass;
    private EditText ciudad;
    private EditText telefono;
    private EditText direccion;
    private EditText nombre;
    private Button btn;
    private ImageView back;
    private Spinner spinner;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);
        back=findViewById(R.id.imgAtras);
        cedula=(EditText) findViewById(R.id.ediTextCedula);
        pass=findViewById(R.id.editTextContrasena);
        ciudad=findViewById(R.id.editTextCiudad);
        telefono=findViewById(R.id.editTextTelefonoRegistro);
        direccion=findViewById(R.id.editTextDireccion);
        nombre=findViewById(R.id.editTextNombre);
        btn=(Button) findViewById(R.id.buttonCrearCuentaRegistro);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }
    @Override
    protected void onStart() {
        super.onStart();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Registro.this,Login.class);
                startActivity(i);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String ci,pw,cid,tef,dic,name,rol;
               ci=cedula.getText().toString();
               pw=pass.getText().toString();
               cid=ciudad.getText().toString();
               tef=telefono.getText().toString();
               dic=direccion.getText().toString();
               name=nombre.getText().toString();
               rol=spinner.getSelectedItem().toString();
                Usuario usuario=new Usuario(ci,name,pw,cid,tef,dic,rol);
               Usuarios.registrar(usuario,v.getContext()
               );

                Toasty.success(v.getContext(), "Usuario crado correctamente", Toast.LENGTH_LONG).show();
               Intent i=new Intent(Registro.this,Login.class);
               startActivity(i);

            }
        });

    }
}
