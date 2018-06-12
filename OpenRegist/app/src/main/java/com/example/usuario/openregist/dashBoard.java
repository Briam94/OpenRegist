package com.example.usuario.openregist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashBoard extends AppCompatActivity {

    Button botonventa, btnconsultar, btnenrutar, btnconsultarruta, btncerrarsesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        botonventa = findViewById(R.id.botonventaplan);

        btnconsultar = findViewById(R.id.botonconsultar);

        btnenrutar = findViewById(R.id.botonenrutar);

        btnconsultarruta = findViewById(R.id.botonhubicarme);

        btncerrarsesion = findViewById(R.id.button5);

        btnenrutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), registroRutas.class);
                startActivity(i);
            }
        });

        botonventa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), registroTitular.class);
                startActivity(i);
            }
        });

        btnconsultarruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(i);
            }
        });

        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), consultar.class);
                startActivity(i);
            }
        });

        btncerrarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
                System.exit(0);
            }
        });
    }
}
