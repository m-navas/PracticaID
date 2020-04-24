package com.example.android.fingerprintdialog.entidades;

/*
*  Clase que representa un registro almacenado en la base de datos
* */
public class Registro {

    private String usuario; // "propietario" o "externo"
    private Boolean fn; // Falso Negativo
    private Boolean fp; // Falso Positivo
    private Boolean error; // error adquisición
    private Long timestamp; // marca temporal para conocer cuando se realizó el acceso

    public Registro(String tipoUsuario, Boolean fn, Boolean fp, Boolean errorAdq, Long timestamp) {
        this.usuario = tipoUsuario;
        this.fn = fn;
        this.fp = fp;
        this.error = errorAdq;
        this.timestamp = timestamp;
    }

    public Registro (){
        usuario = null;
        fn = null;
        fp = null;
        error = null;
        timestamp = null;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getFn() {
        return fn;
    }

    public void setFn(Boolean fn) {
        this.fn = fn;
    }

    public Boolean getFp() {
        return fp;
    }

    public void setFp(Boolean fp) {
        this.fp = fp;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
