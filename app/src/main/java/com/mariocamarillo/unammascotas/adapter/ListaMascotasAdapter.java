package com.mariocamarillo.unammascotas.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.data.Mascotas;
import java.util.List;

public class ListaMascotasAdapter extends RecyclerView.Adapter<ListaMascotasAdapter.ViewHolder>  {

    List<Mascotas> listMascotas;

    public ListaMascotasAdapter(List<Mascotas> listMascotas) {
        this.listMascotas = listMascotas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.element_recycler_view_mascota, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final Mascotas mascota = listMascotas.get(i);
        viewHolder.imgImagenGeneral.setImageResource(mascota.getImage());
        viewHolder.txtNombre.setText(mascota.getName());
        viewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setLikes(mascota.getLikes()+1);
                viewHolder.txtLikes.setText(mascota.getLikes());
            }
        });
        //viewHolder.imgHuesoAmarillo.setImageResource(mascota.getImage());
        viewHolder.txtLikes.setText(mascota.getLikes());
    }

    @Override
    public int getItemCount() {
        return listMascotas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgImagenGeneral;
        public TextView txtNombre;
        public ImageView imgHuesoBlanco;
        public ImageView imgHuesoAmarillo;
        public TextView txtLikes;

        public ViewHolder(View item) {
            super(item);
            imgImagenGeneral = item.findViewById(R.id.general_image);
            txtNombre = item.findViewById(R.id.txt_name);
            imgHuesoBlanco = item.findViewById(R.id.img_hueso_blanco);
            imgHuesoAmarillo = item.findViewById(R.id.img_hueso_amarillo);
            txtLikes = item.findViewById(R.id.txt_likes);
        }
    }

}
