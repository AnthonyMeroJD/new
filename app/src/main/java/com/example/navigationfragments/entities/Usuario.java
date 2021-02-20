package com.example.navigationfragments.entities;

import java.util.Date;

public class Usuario {
    private String cedula;
    private String nombre;
    private String password;
    private String ciudad;
    private String telefono;
    private String direccion;
    private String rol;
    private Date fecha_creacion;

    public Usuario(String cedula, String nombre, String password, String ciudad, String telefono, String direccion,String rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.password = password;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol=rol;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
