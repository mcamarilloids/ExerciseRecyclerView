package com.mariocamarillo.unammascotas.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.basedatos.BaseDatos;
import com.mariocamarillo.unammascotas.data.Mascotas;
import java.util.List;

public class ListaMascotasAdapter extends RecyclerView.Adapter<ListaMascotasAdapter.ViewHolderP>  {

    List<Mascotas> listMascotas;
    boolean esCalificable;
    boolean esGrid;
    Activity activity;

    public ListaMascotasAdapter(Activity activity, List<Mascotas> listMascotas, boolean esCalificable, boolean esGrid) {
        this.listMascotas = listMascotas;
        this.esCalificable = esCalificable;
        this.esGrid = esGrid;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ListaMascotasAdapter.ViewHolderP onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.element_recycler_view_mascota, viewGroup, false);
        if(esGrid){
            v.getLayoutParams().height = (int) viewGroup.getResources().getDimension(R.dimen.height_card_view_grid);
        }
        ViewHolderP vh = new ViewHolderP(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderP viewHolder, int i) {
        final Mascotas mascota = listMascotas.get(i);
        viewHolder.imgImagenGeneral.setImageResource(mascota.getFoto());
        viewHolder.txtNombre.setText(mascota.getNombre());
        if (esCalificable) {
            viewHolder.imgHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BaseDatos bd = new BaseDatos(activity);
                    boolean likesEditados= bd.editarLike(mascota.getId(), mascota.getLikes());
                    if(likesEditados){
                        mascota.setLikes(mascota.getLikes() + 1);
                        viewHolder.txtLikes.setText(String.valueOf(mascota.getLikes()));
                    }
                    
                }
            });
        }
        if(esGrid){
            viewHolder.txtNombre.setVisibility(View.GONE);
            viewHolder.imgHuesoBlanco.setVisibility(View.GONE);
        }
        viewHolder.txtLikes.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
       return listMascotas.size();
    }

    public static class ViewHolderP extends RecyclerView.ViewHolder {

        public ImageView imgImagenGeneral;
        public TextView txtNombre;
        public ImageView imgHuesoBlanco;
        public ImageView imgHuesoAmarillo;
        public TextView txtLikes;

        public ViewHolderP(View item) {
            super(item);
            imgImagenGeneral = item.findViewById(R.id.general_image);
            txtNombre = item.findViewById(R.id.txt_name);
            imgHuesoBlanco = item.findViewById(R.id.img_hueso_blanco);
            imgHuesoAmarillo = item.findViewById(R.id.img_hueso_amarillo);
            txtLikes = item.findViewById(R.id.txt_likes);
        }
    }

}
