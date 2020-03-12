package com.fernandopaniagua.blobmanagement.model;

public class Imagen {
    private String nombre;
    private byte[] fichero;

    public Imagen(String nombre, byte[] fichero) {
        this.nombre = nombre;
        this.fichero = fichero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getFichero() {
        return fichero;
    }

    public void setFichero(byte[] fichero) {
        this.fichero = fichero;
    }
    
}
