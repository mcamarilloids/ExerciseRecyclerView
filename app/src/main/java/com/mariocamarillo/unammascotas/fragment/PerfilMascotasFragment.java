package com.mariocamarillo.unammascotas.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.adapter.ListaMascotasAdapter;
import com.mariocamarillo.unammascotas.data.Mascotas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erick.chaparro on 16,octubre,2018
 */
public class PerfilMascotasFragment extends Fragment  {

    private List<Mascotas> listFotos;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil_mascotas, container, false);
        llenarLista();
        setVistas(view);
        setAdaptador();
        return view;
    }

    private void llenarLista() {
        listFotos = new ArrayList<>();
        listFotos.add(new Mascotas(2, R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));
        listFotos.add(new Mascotas(2,R.drawable.perros2, "nunu", 2));


    }

    private void setVistas(final View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(glm);

    }

    private void setAdaptador() {
        ListaMascotasAdapter adapter = new ListaMascotasAdapter(getActivity(), listFotos, false, true);
        recyclerView.setAdapter(adapter);
    }
}
