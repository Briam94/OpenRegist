package com.example.usuario.openregist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.usuario.openregist.Conn.Connect;
import com.example.usuario.openregist.Entidades.ruta;
import com.example.usuario.openregist.Utilidades.Utilidades;

import java.util.ArrayList;

public class listarRutas extends AppCompatActivity {

    ListView listViewRutas;
    ArrayList<String> listaInformacion;
    ArrayList<ruta> listaRutas;
    Connect conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_rutas);

        listViewRutas = (ListView) findViewById(R.id.listaRutas);
        conn = new Connect(getApplicationContext(), "bd_openregist", null,1);

        consultar();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewRutas.setAdapter(adaptador);
    }

    public void consultar(){
        SQLiteDatabase db = conn.getWritableDatabase();

        ruta rut = null;
        listaRutas = new ArrayList<ruta>();

        Cursor c =  db.rawQuery("SELECT * FROM " + Utilidades.TABLA_RUTA,null);

        while (c.moveToNext()){
            rut = new ruta();
            rut.setNombreEmpresa(c.getString(0));
            rut.setDireccionEmpresa(c.getString(1));

            listaRutas.add(rut);
        }
        obtenerLista();
    }

    private void obtenerLista() {

        listaInformacion = new ArrayList<String>();

        for (int i = 0; i<listaRutas.size();i++){
            listaInformacion.add(listaRutas.get(i).getNombreEmpresa()+ " - " + listaRutas.get(i).getDireccionEmpresa());
        }
    }
}

