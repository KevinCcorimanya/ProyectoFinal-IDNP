package com.example.laboratorio6.utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static String TABLA_USUARIO="usuario";
    public static String CAMPO_CORREO="correo";
    public static String CAMPO_NOMBRE="nombre";
    public static String CAMPO_PASSWORD="password";


    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_CORREO+" " +
            "TEXT, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_PASSWORD+" INTEGER)";

}
