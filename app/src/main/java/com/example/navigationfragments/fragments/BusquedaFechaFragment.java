package com.example.navigationfragments.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationfragments.R;
import com.example.navigationfragments.adapters.UsersAdapter;
import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.repo.Usuarios;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class BusquedaFechaFragment extends Fragment {

    private UsersAdapter myAdapter;
    private TextInputEditText fecha1;
    private TextInputEditText fecha2;
    private MaterialButton btn;
    private RecyclerView listView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_busqueda, container, false);
        fecha1=root.findViewById(R.id.txtInputBusquedaFecha1);
        fecha2=root.findViewById(R.id.txtInputBusquedaFecha2);
        btn=root.findViewById(R.id.btnBuscarFecha);
     listView=root.findViewById(R.id.rVListaConsulta);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        fecha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        final String selectedDate;
                        if (month<10 && day>10){
                            selectedDate = year + "-0" + (month + 1) + "-" + day;
                        }else if(month<10 && day<10){
                            selectedDate = year + "-0" + (month + 1) + "-0" + day;
                        }
                        else {
                            selectedDate = year + "-" + (month + 1) + "-" + day;
                        }
                        fecha1.setText(selectedDate);

                    }
                });

                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });
        fecha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        final String selectedDate;
                        if (month<10 && day>10){
                            selectedDate = year + "-0" + (month + 1) + "-" + day;
                        }else if(month<10 && day<10){
                            selectedDate = year + "-0" + (month + 1) + "-0" + day;
                        }
                        else {
                            selectedDate = year + "-" + (month + 1) + "-" + day;
                        }
                        fecha2.setText(selectedDate);
                    }
                });

                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f1=fecha1.getText().toString();
                String f2=fecha2.getText().toString();
                if (f1.length()>0&&f2.length()>0){
                    try {
                        System.out.println(f1+""+f2);
                        List<Usuario> usuarios=  Usuarios.getUsersByRank(getContext(),f1,f2);
                        if (usuarios.size()>0){
                            fillListView(v.getContext(),usuarios);
                        }

                    }catch (Exception e){

                        Toasty.error(v.getContext(),"sin resultados",Toasty.LENGTH_SHORT).show();
                    }

                }else {
                    Toasty.warning(v.getContext(),"ingrese los rangos de la fecha",Toasty.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void fillListView(Context context,List <Usuario> usuarios){
        listView.setLayoutManager(new LinearLayoutManager(context));
        myAdapter = new UsersAdapter(this, context ,usuarios);
        listView.setAdapter(myAdapter);
    }



}
