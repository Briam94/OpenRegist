package com.example.usuario.openregist;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.usuario.openregist.Conn.Connect;
import com.example.usuario.openregist.Utilidades.Utilidades;

public class registroTitular extends AppCompatActivity {

    EditText planTitular, nombreTitular, cedulaTitular, edadTitular, fechaNacimientoTitular;
    Spinner planes;

    public static String id;

    Button btnRegistrarTitular, btnCancelarRegistroTitular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_titular2);

        planes = (Spinner) findViewById(R.id.campoPlanes);
        nombreTitular = (EditText) findViewById(R.id.campoNombreTitular);
        cedulaTitular = (EditText) findViewById(R.id.campoCedulaTitular);
        edadTitular = (EditText) findViewById(R.id.campoEdadTitular);
        fechaNacimientoTitular = (EditText) findViewById(R.id.campoFechaNacimientoTitular);

        btnRegistrarTitular = findViewById(R.id.botonRegistrarTitular);
        btnCancelarRegistroTitular = findViewById(R.id.botonCancelarRegistroTitular);

        btnRegistrarTitular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarTitular();
            }
        });
    }

    public void registrarTitular(){

        Connect conn = new Connect(this, "bd_openregist", null,1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.TITULAR_PLAN, planes.getSelectedItem().toString());
        values.put(Utilidades.TITULAR_NOMBRE, nombreTitular.getText().toString());
        values.put(Utilidades.TITULAR_CEDULA, cedulaTitular.getText().toString());
        values.put(Utilidades.TITULAR_EDAD, edadTitular.getText().toString());
        values.put(Utilidades.TITULAR_FECHANACIMIENTO, fechaNacimientoTitular.getText().toString());

        Long resultado = db.insert(Utilidades.TABLA_TITULAR, Utilidades.TITULAR_NOMBRE, values);

        Toast.makeText(getApplicationContext(), "TITULAR: " + resultado + " Registrado exitosamente",Toast.LENGTH_SHORT).show();
        db.close();

        id = cedulaTitular.getText().toString();

        limpiar();
    }

    public void limpiar(){
        nombreTitular.setText("");
        cedulaTitular.setText("");
        edadTitular.setText("");
        fechaNacimientoTitular.setText("");

        Intent i = new Intent(getApplicationContext(), registroAsegurado.class);
        startActivity(i);
    }
}
