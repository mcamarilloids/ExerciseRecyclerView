package com.mariocamarillo.unammascotas.utils;

public final class ConstantsBD {

    public static final int DATABASE_VERSION = 1;

    public static final String DATABASE_NAME = "mascotas.db";

    public static final String TABLA_NOMBRES = "mascota";

    public static final String COLUMNA_ID = "id";

    public static final String COLUMNA_NOMBRE = "nombre";

    public static final String COLUMNA_LIKES = "likes";

    public static final String COLUMNA_FOTO = "foto";

    public static final String[] COLUMNAS = {"id","nombre","likes","foto"};

    public static final String SQL_CREAR_TABLA = "create table "
            + TABLA_NOMBRES + "(" + COLUMNA_ID
            + " integer primary key autoincrement, " + COLUMNA_NOMBRE
            + " text, " + COLUMNA_LIKES
            + " integer, " + COLUMNA_FOTO
            + " integer);";
}
