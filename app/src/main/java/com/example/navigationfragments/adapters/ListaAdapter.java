package com.example.navigationfragments.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationfragments.R;
import com.example.navigationfragments.entities.Telefono;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Telefono> {

    private int resourceLayout;
    private Context mContext;

    public ListaAdapter(Context context, int resource, List<Telefono> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Telefono p = getItem(position);

        if (p != null) {
            TextView nombre = (TextView) v.findViewById(R.id.tv_telf_nombre);
            TextView precio = (TextView) v.findViewById(R.id.tv_telf_precio);
            ImageView imagen = (ImageView) v.findViewById(R.id.iv_img_telf);

            if (nombre != null) {
                nombre.setText(p.getNombre());
            }

            if (precio != null) {
                precio.setText(p.getPrecio());
            }

            if (imagen != null) {
                imagen.setImageResource(p.getImagen());
            }
        }

        return v;
    }
}
