package com.mariocamarillo.unammascotas.basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;

import com.mariocamarillo.unammascotas.R;
import com.mariocamarillo.unammascotas.data.Mascotas;
import com.mariocamarillo.unammascotas.utils.ConstantsBD;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context) {
        super(context, ConstantsBD.DATABASE_NAME, null, ConstantsBD.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ConstantsBD.SQL_CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void agregarMascotas(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ConstantsBD.COLUMNA_NOMBRE, "titi");
        values.put(ConstantsBD.COLUMNA_LIKES, 0);
        values.put(ConstantsBD.COLUMNA_FOTO, R.drawable.perros1);
        db.insert(ConstantsBD.TABLA_NOMBRES, null,values);
        values = new ContentValues();
        values.put(ConstantsBD.COLUMNA_NOMBRE, "lolo");
        values.put(ConstantsBD.COLUMNA_LIKES, 0);
        values.put(ConstantsBD.COLUMNA_FOTO, R.drawable.perros2);
        db.insert(ConstantsBD.TABLA_NOMBRES, null,values);
        values = new ContentValues();
        values.put(ConstantsBD.COLUMNA_NOMBRE, "sasa");
        values.put(ConstantsBD.COLUMNA_LIKES, 0);
        values.put(ConstantsBD.COLUMNA_FOTO, R.drawable.perros3);
        db.insert(ConstantsBD.TABLA_NOMBRES, null,values);
        values = new ContentValues();
        values.put(ConstantsBD.COLUMNA_NOMBRE, "rino");
        values.put(ConstantsBD.COLUMNA_LIKES, 0);
        values.put(ConstantsBD.COLUMNA_FOTO, R.drawable.perros4);
        db.insert(ConstantsBD.TABLA_NOMBRES, null,values);
        values = new ContentValues();
        values.put(ConstantsBD.COLUMNA_NOMBRE, "xoxo");
        values.put(ConstantsBD.COLUMNA_LIKES, 0);
        values.put(ConstantsBD.COLUMNA_FOTO, R.drawable.perros5);
        db.insert(ConstantsBD.TABLA_NOMBRES, null,values);
        values = new ContentValues();
        values.put(ConstantsBD.COLUMNA_NOMBRE, "pepa");
        values.put(ConstantsBD.COLUMNA_LIKES, 0);
        values.put(ConstantsBD.COLUMNA_FOTO, R.drawable.perros6);
        db.insert(ConstantsBD.TABLA_NOMBRES, null,values);
        values = new ContentValues();
        values.put(ConstantsBD.COLUMNA_NOMBRE, "ñoño");
        values.put(ConstantsBD.COLUMNA_LIKES, 0);
        values.put(ConstantsBD.COLUMNA_FOTO, R.drawable.perros7);
        db.insert(ConstantsBD.TABLA_NOMBRES, null,values);
        db.close();
    }

    public List<Mascotas> getMascotas(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Mascotas> mascotas = new ArrayList<>();
        Cursor c = db.query(ConstantsBD.TABLA_NOMBRES, ConstantsBD.COLUMNAS, null, null, null, null, "id");
        //Nos aseguramos de que existe al menos un registro
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                int id= c.getInt(0);
                String nombre = c.getString(1);
                int likes= c.getInt(2);
                int fotos = c.getInt(3);
                mascotas.add(new Mascotas(id, fotos, nombre, likes));
            } while(c.moveToNext());
        }
        return mascotas;
    }

    public List<Mascotas> getMascotasLikes(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<Mascotas> mascotas = new ArrayList<>();
        Cursor c = db.query(ConstantsBD.TABLA_NOMBRES, ConstantsBD.COLUMNAS, null, null, null, null, "likes DESC");
        //Nos aseguramos de que existe al menos un registro
        int top5 = 0;
        if (c.moveToFirst()) {
            //Recorremos el cursor hasta que no haya más registros
            do {
                int id= c.getInt(0);
                String nombre = c.getString(1);
                int likes= c.getInt(2);
                int fotos = c.getInt(3);
                mascotas.add(new Mascotas(id, fotos, nombre, likes));
                top5++;
            } while(c.moveToNext() && top5 < 5);
        }
        return mascotas;
    }

    public boolean editarLike(int id, int likes){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("likes",likes+1);
        int i = db.update(ConstantsBD.TABLA_NOMBRES,
                values,
                 ConstantsBD.COLUMNA_ID + " = ?",
                new String[] { String.valueOf( id ) });
        db.close();
        return i>0;
    }
}
