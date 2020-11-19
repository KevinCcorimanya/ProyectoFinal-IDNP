package com.example.laboratorio6.entidades;

public class Usuario {

    private String correo;
    private String nombre;
    private Integer password;

    public Usuario(String correo, String nombre, Integer password) {
        this.correo = correo;
        this.nombre = nombre;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
