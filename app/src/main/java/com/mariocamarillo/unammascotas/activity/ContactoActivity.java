package com.mariocamarillo.unammascotas.activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.utils.AsynTaskMail;

/**
 * Created by erick.chaparro on 15,octubre,2018
 */
public class ContactoActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputEditText nombre, mail, mensaje;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        findViews();
    }

    private void findViews() {
        nombre = findViewById(R.id.edtNombre);
        mail = findViewById(R.id.edtMail);
        mensaje = findViewById(R.id.edtMensaje);
        enviar = findViewById(R.id.btnEnviar);
        enviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEnviar:
                if(nombre.getText() == null || mail.getText() == null || mensaje.getText() == null ){
                    Toast.makeText(this, "Llenar todos los campos", Toast.LENGTH_LONG).show();
                }else {
                    new AsynTaskMail(this, mail.getText().toString(), nombre.getText().toString(), mensaje.getText().toString()).execute();
                }
                break;
            default:
                break;
        }
    }
}
