package com.example.usuario.openregist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class consultar extends AppCompatActivity {

    Button consultarRuta, consultarTitular, consultarAsegurado, listaTirulares, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        consultarRuta = findViewById(R.id.button);
        consultarTitular = findViewById(R.id.button2);
        consultarAsegurado = findViewById(R.id.button3);
        listaTirulares = findViewById(R.id.button4);
        cancelar = findViewById(R.id.button6);

        consultarRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), listarRutas.class);
                startActivity(i);
            }
        });
        consultarTitular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), listarRegistros.class);
                startActivity(i);
            }
        });

        consultarAsegurado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), consultarAsegurado.class);
                startActivity(i);
            }
        });

        listaTirulares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), listarAsegurados.class);
                startActivity(i);
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), dashBoard.class);
                startActivity(i);
            }
        });

    }
}
