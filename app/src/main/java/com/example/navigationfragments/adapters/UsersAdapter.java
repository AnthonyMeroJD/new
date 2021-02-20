package com.example.navigationfragments.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationfragments.DialogEditar;
import com.example.navigationfragments.R;
import com.example.navigationfragments.Registro;
import com.example.navigationfragments.entities.Telefono;
import com.example.navigationfragments.entities.Usuario;
import com.example.navigationfragments.fragments.RegistroFragment;
import com.example.navigationfragments.fragments.UsuariosFragment;
import com.example.navigationfragments.repo.Usuarios;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder>{
    private  static Fragment fragment;

    private Context mContext;

    private  static List<Usuario> usuarios;
    public UsersAdapter(Fragment f,Context context, List<Usuario> items){
        usuarios=items;
        this.mContext = context;
        fragment=f;
    }



    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView nombre ;
        TextView cedula ;
        ImageView editar;
        ImageView delete;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
             nombre =  itemView.findViewById(R.id.txtNombre);
             cedula =  itemView.findViewById(R.id.txtCedula);
             editar=    itemView.findViewById(R.id.imgEditar);
             delete=    itemView.findViewById(R.id.imgEliminar);
        }

        public void delete(Usuario user,int position){
            Usuarios.eliminarUsuario(fragment.getContext(),user.getCedula());
            usuarios.remove(user);
            Toasty.success(fragment.getContext(),"Usuario eliminado ", Toast.LENGTH_SHORT).show();
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, usuarios.size());


        }

        public void bind(Usuario user,int position){
            nombre.setText(user.getNombre());
            cedula.setText(user.getCedula());
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delete(user,position);
                }
            });

            editar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    DialogEditar registroFragment=new DialogEditar();
                    System.out.println(position);
                    Bundle result = new Bundle();
                    result.putString("cedula",user.getCedula());
                    registroFragment.setArguments(result);

                    if (fragment.getFragmentManager() != null) {
                        Toasty.info(fragment.getContext(),"Edita la informacion ",Toast.LENGTH_SHORT).show();
                        registroFragment.show(fragment.getFragmentManager(), "editar");
                    }

                }
            });

        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.consulta, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(usuarios.get(position),position);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

}
