package com.mariocamarillo.unammascotas.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.adapter.ListaMascotasAdapter;
import com.mariocamarillo.unammascotas.basedatos.BaseDatos;
import com.mariocamarillo.unammascotas.data.Mascotas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erick.chaparro on 16,octubre,2018
 */
public class ListaMascotasFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Mascotas> listMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);
        llenarLista();
        setVistas(view);
        setAdaptador();
        return view;
    }

    private void llenarLista() {
        listMascotas = new ArrayList<>();
        BaseDatos bd = new BaseDatos(getActivity());
        boolean datosInsertados = checarPreferencias();
        if(!datosInsertados){
            bd.agregarMascotas();
        }
        listMascotas.addAll(bd.getMascotas());
    }

    private boolean checarPreferencias() {
        SharedPreferences prefs =
                getActivity().getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        boolean datosInsertados = prefs.getBoolean("insertados", false);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("insertados", true);
        editor.apply();
        return datosInsertados;
    }

    private void setVistas(final View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

    }

    private void setAdaptador() {
        ListaMascotasAdapter adapter = new ListaMascotasAdapter(getActivity(), listMascotas, true, false);
        recyclerView.setAdapter(adapter);
    }
}
