package models;

import java.util.Calendar;

import models.Interfaces.IObservable;
import models.Interfaces.IObserver;

public class Trofeo implements IObserver {
    private String nombre;
    private String descripcion;
    private Calendar fecha;

    public Trofeo(String nombre, String descripcion,Calendar fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
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

	public Calendar getFecha() {
		return fecha;
	}
}
