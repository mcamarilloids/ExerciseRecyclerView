package com.mariocamarillo.unammascotas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.adapter.ListaMascotasAdapter;
import com.mariocamarillo.unammascotas.data.Mascotas;

import java.util.ArrayList;
import java.util.List;

public class ListaMascotasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Mascotas> listMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);
        setToolbar();
        llenarLista();
        setVistas();
        setAdaptador();
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.action_bar);
        setSupportActionBar(toolbar);
        ImageView top = toolbar.findViewById(R.id.top);
        TextView title = toolbar.findViewById(R.id.title);
        title.setText(getString(R.string.titulo_pantalla));
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MascotaActivity.class);
                startActivity(i);
            }
        });
    }

    private void llenarLista() {
        listMascotas = new ArrayList<>();
        listMascotas.add(new Mascotas(R.drawable.perros1, "titi", 0));
        listMascotas.add(new Mascotas(R.drawable.perros2, "nunu", 2));
        listMascotas.add(new Mascotas(R.drawable.perros3, "lolo", 4));
        listMascotas.add(new Mascotas(R.drawable.perros4, "sasa", 1));
        listMascotas.add(new Mascotas(R.drawable.perros5, "wiwiwi", 3));
        listMascotas.add(new Mascotas(R.drawable.perros6, "rino", 6));
        listMascotas.add(new Mascotas(R.drawable.perros7, "xoxo", 7));
    }

    private void setVistas() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

    }

    private void setAdaptador() {
        ListaMascotasAdapter adapter = new ListaMascotasAdapter(listMascotas, true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contacto:
                Intent c = new Intent(this, ContactoActivity.class);
                startActivity(c);
                return true;
            case R.id.acerca:
                Intent a = new Intent(this, AcercaDeActivity.class);
                startActivity(a);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
