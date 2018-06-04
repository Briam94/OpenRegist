package com.example.usuario.openregist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.usuario.openregist.Conn.Connect;

public class MainActivity extends AppCompatActivity {

    Button ingresar, registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Connect conn = new Connect(this, "bd_openregist", null,1);

        ingresar = findViewById(R.id.btnIngresar);
        registrar = findViewById(R.id.btnRegistrar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), dashBoard.class);
                startActivity(i);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegistroUsuarios.class);
                startActivity(i);
            }
        });
    }
}
