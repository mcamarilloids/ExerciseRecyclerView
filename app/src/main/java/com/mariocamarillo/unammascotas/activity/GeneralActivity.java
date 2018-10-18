package com.mariocamarillo.unammascotas.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.adapter.ViewPagerAdapter;
import com.mariocamarillo.unammascotas.fragment.ListaMascotasFragment;
import com.mariocamarillo.unammascotas.fragment.PerfilMascotasFragment;

import java.util.ArrayList;
import java.util.List;

public class GeneralActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        setToolbar();
        //llenarLista();
        //setVistas();
        //setAdaptador();
        crearViewPager();
    }

    private void setToolbar() {
        CoordinatorLayout linearLayout = findViewById(R.id.coordinator);
        toolbar = linearLayout.findViewById(R.id.toolbar);
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
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }



    private void crearViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListaMascotasFragment());
        fragments.add(new PerfilMascotasFragment());
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.perro);
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
