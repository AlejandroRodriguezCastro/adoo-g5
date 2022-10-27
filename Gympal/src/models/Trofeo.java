package models;

import models.Interfaces.IObservable;
import models.Interfaces.IObserver;

public class Trofeo implements IObserver {
    private String nombre;
    private String descripcion;

    public Trofeo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void serNotificadoPor(IObservable observable) {
        return;
    }
}
