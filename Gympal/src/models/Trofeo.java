package models;

import java.util.Calendar;

public class Trofeo {
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


	public Calendar getFecha() {
		return fecha;
	}
}
