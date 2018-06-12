package com.example.usuario.openregist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.usuario.openregist.Conn.Connect;
import com.example.usuario.openregist.Utilidades.Utilidades;

public class consultarAsegurado extends AppCompatActivity {

    EditText cedulaAseguradoBuscar, nombreAseguradoResultado, edadAseguradoResultado, fechaNacimientoAseguradoResultado, parentescoAseguradoResultado, campotitular;
    String cedulatitular;

    Connect conn;

    Button buscarAsegurado, finalizarBusquedaAsegurado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_asegurado);

        conn = new Connect(getApplicationContext(),"bd_openregist",null,1);

        cedulaAseguradoBuscar = (EditText) findViewById(R.id.campocedulaaseguradobuscar);
        nombreAseguradoResultado = (EditText) findViewById(R.id.camponombreaseguradoresultado);
        edadAseguradoResultado = (EditText) findViewById(R.id.campoedadaseguradoresultado);
        fechaNacimientoAseguradoResultado = (EditText) findViewById(R.id.campofechanacimientoaseguradoresultadoresultado);
        parentescoAseguradoResultado = (EditText) findViewById(R.id.campoparentescoaseguradoresultado);
        campotitular = findViewById(R.id.campo);

        buscarAsegurado = findViewById(R.id.botonbuscarasegurado);
        finalizarBusquedaAsegurado = findViewById(R.id.botonatrasbuscarasegurado);

        finalizarBusquedaAsegurado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buscarAsegurado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });

    }


    public void buscar(){
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {cedulaAseguradoBuscar.getText().toString()};
        String[] campos = {Utilidades.ASEGURADO_NOMBRE, Utilidades.ASEGURADO_EDAD, Utilidades.ASEGURADO_FECHANACIMIENTO, Utilidades.ASEGURADO_PARENTESCO, Utilidades.ASEGURADO_ID};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_ASEGURADO,campos,Utilidades.ASEGURADO_CEDULA + "=?",
                    parametros,null,null,null);
            cursor.moveToFirst();
            nombreAseguradoResultado.setText(cursor.getString(0));
            edadAseguradoResultado.setText(cursor.getString(1));
            fechaNacimientoAseguradoResultado.setText(cursor.getString(2));
            parentescoAseguradoResultado.setText(cursor.getString(3));
            cedulatitular = cursor.getString(4);

            buscarTiular();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Numero de cedula es erroneo o el cliente no existe",Toast.LENGTH_SHORT).show();

        }

    }

    private void buscarTiular() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {cedulatitular};
        String[] campos = {Utilidades.TITULAR_NOMBRE};

        try {

            Cursor cursor = db.query(Utilidades.TABLA_TITULAR,campos,Utilidades.TITULAR_CEDULA + "=?",
                    parametros,null,null,null);
            cursor.moveToFirst();
            campotitular.setText(cursor.getString(0));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El Numero de cedula es erroneo o el cliente no existe",Toast.LENGTH_SHORT).show();

        }
    }
}
