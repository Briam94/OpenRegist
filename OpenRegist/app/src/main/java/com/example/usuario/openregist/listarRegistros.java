package com.example.usuario.openregist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.usuario.openregist.Conn.Connect;
import com.example.usuario.openregist.Entidades.asegurado;
import com.example.usuario.openregist.Entidades.ruta;
import com.example.usuario.openregist.Utilidades.Utilidades;

import java.util.ArrayList;

public class listarRegistros extends AppCompatActivity {

    EditText cedulaTitularBusqueda, nombreTitularResultado, planResultado, edadtitularResultado, fehcanacimientoTitularResultado;

    Button btnBuscarTitular, atras;

    Connect conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_registros);

        conn = new Connect(getApplicationContext(),"bd_openregist",null,1);

        cedulaTitularBusqueda = (EditText) findViewById(R.id.campocedulabusqueda);
        nombreTitularResultado = (EditText) findViewById(R.id.camponombretitularmostrar);
        planResultado = (EditText) findViewById(R.id.campoplantitularmostrar);
        edadtitularResultado = (EditText) findViewById(R.id.campoedadtitularmostrar);
        fehcanacimientoTitularResultado = (EditText) findViewById(R.id.fechanacimientotitularmostrar);

        nombreTitularResultado.setEnabled(false);
        planResultado.setEnabled(false);
        edadtitularResultado.setEnabled(false);
        fehcanacimientoTitularResultado.setEnabled(false);

        btnBuscarTitular = (Button) findViewById(R.id.botonbuscarasegurado);
        atras = findViewById(R.id.botonatras);
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBuscarTitular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });


    }

    public void buscar(){
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {cedulaTitularBusqueda.getText().toString()};
        String[] campos = {Utilidades.TITULAR_NOMBRE, Utilidades.TITULAR_PLAN, Utilidades.TITULAR_EDAD, Utilidades.TITULAR_FECHANACIMIENTO};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_TITULAR,campos,Utilidades.TITULAR_CEDULA + "=?",
                    parametros,null,null,null);
            cursor.moveToFirst();
            nombreTitularResultado.setText(cursor.getString(0));
            planResultado.setText(cursor.getString(1));
            edadtitularResultado.setText(cursor.getString(2));
            fehcanacimientoTitularResultado.setText(cursor.getString(3));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Numero de cedula es erroneo o el cliente no existe",Toast.LENGTH_SHORT).show();

        }
    }
}
