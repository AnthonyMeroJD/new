package com.example.navigationfragments.entities;

public class Telefono {
    private String nombre;
    private String marca;
    private int imagen;
    private String precio;
    private String descripcion;

    public Telefono(String nombre, String marca, int imagen, String precio, String descripcion) {
        this.nombre = nombre;
        this.marca = marca;
        this.imagen = imagen;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
