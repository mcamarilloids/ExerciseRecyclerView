package com.mariocamarillo.unammascotas.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.mariocamarillo.unammascotas.R;

public class MascotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);
        setToolbar();
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.action_bar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.titulo_pantalla);
        ImageView top = toolbar.findViewById(R.id.top);
        top.setVisibility(View.INVISIBLE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
