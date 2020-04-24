package com.example.android.fingerprintdialog;

import android.util.Log;

public class Utilidades {

    public static final String errorAdq = "Error en la lectura";
    public static final String rechazo = "Huella no reconocida";
    public static final String autenticacion = "Huella reconocida. Bienvenido!";
    public static final long NOTIFICATION_TIMEOUT_MILLIS = 2500;

    public static void log(String s){
        Log.d("PRACTICA_ID", s);
    }
}
