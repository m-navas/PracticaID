package com.example.android.fingerprintdialog;

import android.util.Log;

public class Utilidades {

    public static final String errorAdq = "Error en la lectura";
    public static final String rechazo = "Huella no reconocida";
    public static final String autenticacion = "Huella reconocida. Bienvenido!";
    public static final long NOTIFICATION_TIMEOUT_MILLIS = 3000;

    public static void log(String s){
        Log.d("PRACTICA_ID", s);
    }

    // BD SQLite
    public static final String TABLA_REGISTROS="registros";
    public static final String CAMPO_USUARIO="usuario";
    public static final String CAMPO_FN="fn";
    public static final String CAMPO_FP="fp";
    public static final String CAMPO_ERROR="error";
    public static final String CAMPO_TIMESTAMP="timestamp";
    public static final String CREAR_TABLA_REGISTROS="CREATE TABLE "+TABLA_REGISTROS+" ( "+CAMPO_USUARIO+" TEXT, "
                                                                               +CAMPO_FN+" BOOLEAN, "
                                                                               +CAMPO_FP+" BOOLEAN, "
                                                                               +CAMPO_ERROR+" BOOLEAN, "
                                                                               +CAMPO_TIMESTAMP+" INTEGER )";

}
