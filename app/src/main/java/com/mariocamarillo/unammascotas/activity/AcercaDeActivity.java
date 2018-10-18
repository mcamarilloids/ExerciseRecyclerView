package com.mariocamarillo.unammascotas.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mariocamarillo.unammascotas.R;

/**
 * Created by erick.chaparro on 15,octubre,2018
 */
public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        setToolbar();
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
}
