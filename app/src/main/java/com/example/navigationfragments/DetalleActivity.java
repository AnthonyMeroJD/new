package com.example.navigationfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity {
    private String nombre = "", descripcion = "", precio = "";
    private int imagen = 0;
    private TextView nombreTel;
    private TextView descripcionTel;
    private TextView precioTel;
    private ImageView imgTel;

    private RadioGroup radioGroup;
    private RadioButton radioColor;
    private CheckBox check128, check64, check32;
    private Button btnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        obtenerDatos();

        iniVistas();

        cargarDatos();

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radio = radioGroup.getCheckedRadioButtonId();
                if (radio == R.id.radio_color_1){
                    radioColor = findViewById(radio);
                    comprar();
                }else if(radio == R.id.radio_color_2){
                    comprar();
                }else if(radio == R.id.radio_color_3){
                    comprar();
                }else{
                    Toast.makeText(DetalleActivity.this, "Debe seleccionar un color.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void iniVistas(){
        nombreTel = findViewById(R.id.detalle_telefono_nombre);
        imgTel = findViewById(R.id.detalle_telefono_imagen);
        descripcionTel = findViewById(R.id.detalle_telefono_descripcion);
        precioTel = findViewById(R.id.detalle_telefono_precio);

        radioGroup = findViewById(R.id.radio_color);
        radioGroup.check(R.id.radio_color_1);
        check128 = findViewById(R.id.memoria_128);
        check64 = findViewById(R.id.memoria_64);
        check32 = findViewById(R.id.memoria_32);

        btnComprar = findViewById(R.id.btn_comprar);
    }

    private void obtenerDatos(){
        Intent intent = getIntent();
        nombre = intent.getStringExtra("NOMBRE");
        imagen = intent.getIntExtra("IMAGEN", 0);
        precio = intent.getStringExtra("PRECIO");
        descripcion = intent.getStringExtra("DESC");
    }

    private void cargarDatos(){
        nombreTel.setText(nombre);
        imgTel.setImageResource(imagen);
        precioTel.setText(precio);
        descripcionTel.setText(descripcion);
    }

    private void comprar(){
        String color = radioColor.getText().toString();
        String ram = "";
        if (check32.isChecked()){
            ram = check32.getText().toString();
            Toast.makeText(DetalleActivity.this, "Gracias por comprar un "+nombre+ "\nMemoria interna: " + color + "\nMemoria RAM: " + ram + "\nTOTAL: " + precio, Toast.LENGTH_LONG).show();
            Toast.makeText(DetalleActivity.this, "Su pedido está en camino", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else if (check64.isChecked()){
            ram = check64.getText().toString();
            Toast.makeText(DetalleActivity.this, "Gracias por comprar un "+nombre+ "\nMemoria interna: " + color + "\nMemoria RAM: " + ram + "\nTOTAL: " + precio, Toast.LENGTH_LONG).show();
            Toast.makeText(DetalleActivity.this, "Su pedido está en camino", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else if (check128.isChecked()){
            ram = check128.getText().toString();
            Toast.makeText(DetalleActivity.this, "Gracias por comprar un "+nombre+ "\nMemoria interna: " + color + "\nMemoria RAM: " + ram + "\nTOTAL: " + precio, Toast.LENGTH_LONG).show();
            Toast.makeText(DetalleActivity.this, "Su pedido está en camino", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else {
            Toast.makeText(DetalleActivity.this, "Debe seleccionar una memoria ram.", Toast.LENGTH_SHORT).show();
        }
    }

}