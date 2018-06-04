package com.example.usuario.openregist.Conn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.openregist.Utilidades.Utilidades;

public class Connect extends SQLiteOpenHelper {

    public Connect(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_TITULAR);
        db.execSQL(Utilidades.CREAR_TABLA_ASEGURADO);
        db.execSQL(Utilidades.CREAR_TABLA_RUTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS titulares");
        db.execSQL("DROP TABLE IF EXISTS asegurado");
        db.execSQL("DROP TABLE IF EXISTS ruta");
        onCreate(db);
    }
}
