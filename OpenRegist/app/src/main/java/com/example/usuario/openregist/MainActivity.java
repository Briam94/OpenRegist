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
import com.example.usuario.openregist.Entidades.Usuario;

public class MainActivity extends AppCompatActivity {

    Button ingresar, registrar;

    EditText correo, contrasena;

    Connect conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conn = new Connect(this, "bd_openregist", null,1);

        correo = (EditText) findViewById(R.id.campousuario);
        contrasena = (EditText) findViewById(R.id.campocontraseña);

        ingresar = findViewById(R.id.btnIngresar);
        registrar = findViewById(R.id.btnRegistrar);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
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

    public void ingresar(){

        SQLiteDatabase db = conn.getWritableDatabase();

        String usuario = correo.getText().toString();
        String password = contrasena.getText().toString();

        Cursor fila=db.rawQuery("select correousuario,contrasenausuario from usuario where correousuario='" + usuario
                + "' and contrasenausuario='" + password + "'",null);

        if (fila.moveToNext()){
            String usua = fila.getString(0);
            String pas = fila.getString(1);
            if (usuario.equals(usua) && password.equals(pas)){

                Intent intent = new Intent(getApplicationContext(),dashBoard.class);
                startActivity(intent);
                correo.setText("");
                contrasena.setText("");

            }


        }else {
            Toast.makeText(getApplicationContext(),"Usuario o Contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
