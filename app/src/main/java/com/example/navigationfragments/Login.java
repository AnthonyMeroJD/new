package com.example.navigationfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.repo.Usuarios;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class Login extends AppCompatActivity {
    private EditText user;
    private EditText pass;
    private Button btn;
    private  Button crearUser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        user=(EditText) findViewById(R.id.editTextNombreUsuarioInicarSesion);
        pass=findViewById(R.id.editTextPasswordInicioSesion);
        btn=(Button) findViewById(R.id.buttonIniciarSesion);

        crearUser=(Button) findViewById(R.id.buttonIrRegistro);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            List<Usuario> users = Usuarios.getUsersByRank(this,"2021-01-20","2021-02-21");
            for (Usuario u:users
            ) {
                System.out.println("name"+u.getRol());
            }
        }catch (Exception e){

        }

        crearUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registro.class);
                startActivity(intent);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isValid= Usuarios.inicarSesion(user.getText().toString(),pass.getText().toString(),v.getContext());
                System.out.println("eee "+user.getText().toString()+"   "+pass.getText().toString());
              if (isValid){
                  String rol= Usuarios.whoIsThisUser(user.getText().toString(),pass.getText().toString(),v.getContext());
                  switch (rol){
                      case "Cliente":
                          Intent intent = new Intent(Login.this, MainActivity.class);
                          Toasty.success(Login.this,"Bienvenido",Toast.LENGTH_LONG).show();
                          startActivity(intent);
                          break;
                      case "Administrador":
                          Intent intentAdmin = new Intent(Login.this, MainActivityAdmin.class);
                          startActivity(intentAdmin);
                          break;

                      case "undefined" :
                          Toasty.error(v.getContext(),"verifique los datos",Toast.LENGTH_LONG).show();
                          break;
                  }

              }else{
                  Toasty.error(v.getContext(),"Incorrecto",Toast.LENGTH_LONG).show();
              }
            }
        });

    }
}
