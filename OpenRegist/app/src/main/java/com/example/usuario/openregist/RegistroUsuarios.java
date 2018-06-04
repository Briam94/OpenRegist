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

public class RegistroUsuarios extends AppCompatActivity {

    EditText campoNombre, campoCedula, campoCorreo, campoTelefono, campoContrasena;

    Button btnRegistrarUsuaio, btnCancelarRegistroUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        btnRegistrarUsuaio = (Button) findViewById(R.id.botonregistrarUsuario);
        btnCancelarRegistroUsuario = (Button) findViewById(R.id.botoncancelaregistrousuario);

        campoNombre = (EditText)findViewById(R.id.camponombreusuario);
        campoCedula = (EditText) findViewById(R.id.campocedulausuario);
        campoCorreo = (EditText) findViewById(R.id.campocorreousuario);
        campoTelefono = (EditText) findViewById(R.id.campotelefonousuario);
        campoContrasena = (EditText) findViewById(R.id.campocontrasenausuario);

        btnRegistrarUsuaio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });
    }

    public void registrarUsuarios(){

        Connect conn = new Connect(this, "bd_openregist", null,1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.USUARIO_NOMBRE, campoNombre.getText().toString());
        values.put(Utilidades.USUARIO_CEDULA, campoCedula.getText().toString());
        values.put(Utilidades.USUARIO_CORREO, campoCorreo.getText().toString());
        values.put(Utilidades.USUARIO_TELEFONO, campoTelefono.getText().toString());
        values.put(Utilidades.USUARIO_CONTRASENA, campoContrasena.getText().toString());

        Long resultado = db.insert(Utilidades.TABLA_USUARIO, Utilidades.USUARIO_NOMBRE, values);

        Toast.makeText(getApplicationContext(), "Usuario " + resultado + " Registrado exitosamente",Toast.LENGTH_SHORT).show();
        db.close();

        limpiar();
    }

    public void limpiar(){
        campoNombre.setText("");
        campoCedula.setText("");
        campoCorreo.setText("");
        campoTelefono.setText("");
        campoContrasena.setText("");

        finish();
    }
}
