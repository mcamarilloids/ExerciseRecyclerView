package com.mariocamarillo.unammascotas.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.adapter.ListaMascotasAdapter;
import com.mariocamarillo.unammascotas.basedatos.BaseDatos;
import com.mariocamarillo.unammascotas.data.Mascotas;

import java.util.ArrayList;
import java.util.List;

public class MascotaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Mascotas> listMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);
        setToolbar();
        llenarLista();
        setVistas();
        setAdaptador();
    }

    private void setToolbar() {
        CoordinatorLayout linearLayout = findViewById(R.id.action_bar);
        Toolbar toolbar = linearLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView title = toolbar.findViewById(R.id.title);
        title.setText(getString(R.string.titulo_pantalla));
        ImageView top = toolbar.findViewById(R.id.top);
        top.setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setVisibility(View.GONE);
    }

    private void llenarLista() {
        listMascotas = new ArrayList<>();
        BaseDatos bd = new BaseDatos(this);
        boolean datosInsertados = checarPreferencias();
        if(!datosInsertados){
            bd.agregarMascotas();
        }
        listMascotas.addAll(bd.getMascotas());
    }

    private boolean checarPreferencias() {
        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        boolean datosInsertados = prefs.getBoolean("insertados", false);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("insertados", true);
        editor.apply();
        return datosInsertados;
    }

    private void setVistas() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

    }

    private void setAdaptador() {
        ListaMascotasAdapter adapter = new ListaMascotasAdapter(this, listMascotas, false, false);
        recyclerView.setAdapter(adapter);
    }
}
