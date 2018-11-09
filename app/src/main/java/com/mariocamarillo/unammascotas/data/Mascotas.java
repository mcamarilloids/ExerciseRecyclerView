package com.mariocamarillo.unammascotas.data;

public class Mascotas {

    private int id;
    private int foto;
    private String nombre;
    private int likes;

    public Mascotas(int id, int foto, String nombre, int likes) {
        this.id = id;
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
