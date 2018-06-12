package com.example.usuario.openregist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.usuario.openregist.Conn.Connect;
import com.example.usuario.openregist.Entidades.ruta;
import com.example.usuario.openregist.Entidades.titular;
import com.example.usuario.openregist.Utilidades.Utilidades;

import java.util.ArrayList;

public class listarAsegurados extends AppCompatActivity {


    ListView listViewTitulares;
    ArrayList<String> listaInformacion;
    ArrayList<titular> listaTitular;
    Connect conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_asegurados);


        listViewTitulares = (ListView) findViewById(R.id.listViewTitularesmostrar);
        conn = new Connect(getApplicationContext(), "bd_openregist", null,1);

        consultar();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);
        listViewTitulares.setAdapter(adaptador);
    }

    public void consultar(){
        SQLiteDatabase db = conn.getWritableDatabase();

        titular rut = null;
        listaTitular = new ArrayList<titular>();

        Cursor c =  db.rawQuery("SELECT * FROM " + Utilidades.TABLA_TITULAR,null);

        while (c.moveToNext()){
            rut = new titular();
            rut.setCedulaTitular(c.getString(0));
            rut.setNombreTitular(c.getString(1));
            rut.setPlan(c.getString(2));

            listaTitular.add(rut);
        }
        obtenerLista();
    }

    private void obtenerLista() {

        listaInformacion = new ArrayList<String>();

        for (int i = 0; i<listaTitular.size();i++){
            listaInformacion.add(listaTitular.get(i).getCedulaTitular()+ " - " + listaTitular.get(i).getNombreTitular() + " - " + listaTitular.get(i).getPlan());
        }
    }

}
