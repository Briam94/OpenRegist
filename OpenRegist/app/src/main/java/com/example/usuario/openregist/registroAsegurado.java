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

public class registroAsegurado extends AppCompatActivity {

    EditText idAsegurado, nombreAsegurado, cedulaAsegurado, edadAsegurado, fechanacimientoAsegurado;
    Spinner parentescoAsegurado;
    Button btnRegistrarAsegurado, btnTerminarRegistroAsegurado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_asegurado);

        idAsegurado = (EditText) findViewById(R.id.campoidasegurado);
        nombreAsegurado = (EditText) findViewById(R.id.camponombreasegurado);
        cedulaAsegurado = (EditText) findViewById(R.id.campocedulaasegurado);
        edadAsegurado = (EditText) findViewById(R.id.campoedadasegurado);
        fechanacimientoAsegurado = (EditText) findViewById(R.id.campofechanacimientoasegurado);
        parentescoAsegurado = (Spinner) findViewById(R.id.spinnerparentesco);

        btnRegistrarAsegurado = (Button) findViewById(R.id.botonregistrarasegurado);
        btnTerminarRegistroAsegurado = (Button) findViewById(R.id.botonterminarasegurado);

        idAsegurado.setText(registroTitular.id);
        idAsegurado.setEnabled(false);

        btnTerminarRegistroAsegurado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), dashBoard.class);
                startActivity(i);
            }
        });

        btnRegistrarAsegurado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarAsegurado();
            }
        });
    }

    public void registrarAsegurado(){

        Connect conn = new Connect(this, "bd_openregist", null,1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.ASEGURADO_ID, idAsegurado.getText().toString());
        values.put(Utilidades.ASEGURADO_NOMBRE, nombreAsegurado.getText().toString());
        values.put(Utilidades.ASEGURADO_CEDULA, cedulaAsegurado.getText().toString());
        values.put(Utilidades.ASEGURADO_EDAD, edadAsegurado.getText().toString());
        values.put(Utilidades.ASEGURADO_FECHANACIMIENTO, fechanacimientoAsegurado.getText().toString());
        values.put(Utilidades.ASEGURADO_PARENTESCO, parentescoAsegurado.getSelectedItem().toString());

        Long resultado = db.insert(Utilidades.TABLA_ASEGURADO, Utilidades.ASEGURADO_NOMBRE, values);

        Toast.makeText(getApplicationContext(), "ASEGURADO: " + resultado + " Registrado exitosamente",Toast.LENGTH_SHORT).show();
        db.close();

        limpiar();
    }

    public void limpiar(){

        nombreAsegurado.setText("");
        cedulaAsegurado.setText("");
        edadAsegurado.setText("");
        fechanacimientoAsegurado.setText("");
    }
}
