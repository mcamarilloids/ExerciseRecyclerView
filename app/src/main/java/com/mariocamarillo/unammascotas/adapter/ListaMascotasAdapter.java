package com.mariocamarillo.unammascotas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaMascotasAdapter extends RecyclerView.Adapter<ListaMascotasAdapter.ViewHolder>  {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgImagenGeneral;
        public TextView txtNombre;
        public ImageView imgHuesoBlanco;
        public ImageView imgHuesoAmarillo;
        public TextView txtLikes;

        public ViewHolder(View item) {
            super(item);
            imgImagenGeneral = item.findViewById(R.id.);
        }
    }

}
