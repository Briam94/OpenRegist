package com.example.usuario.openregist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.openregist.Conn.Connect;
import com.example.usuario.openregist.Utilidades.Utilidades;

public class registroRutas extends AppCompatActivity {

    EditText nombreruta, direccionruta;

    Button btnregistrarruta, btncancelarruta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_rutas);

        nombreruta = (EditText) findViewById(R.id.camponombreruta);
        direccionruta = (EditText) findViewById(R.id.campodireccionruta);

        btnregistrarruta = (Button) findViewById(R.id.botonregistrarruta);
        btncancelarruta = (Button) findViewById(R.id.botoncancelarruta);

        btncancelarruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnregistrarruta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarRuta();
            }
        });
    }

    public void registrarRuta(){

        Connect conn = new Connect(this, "bd_openregist", null,1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.RUTA_NOMBRE, nombreruta.getText().toString());
        values.put(Utilidades.RUTA_DIRECCION, direccionruta.getText().toString());

        Long resultado = db.insert(Utilidades.TABLA_RUTA, Utilidades.RUTA_NOMBRE, values);

        Toast.makeText(getApplicationContext(), "Ruta de: " + resultado + " Registrado exitosamente",Toast.LENGTH_SHORT).show();
        db.close();

        limpiar();
    }

    public void limpiar(){
        nombreruta.setText("");
        direccionruta.setText("");
    }
}
