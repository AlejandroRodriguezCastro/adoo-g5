package valueObject;

import java.util.Calendar;

import models.Trofeo;

public class TrofeoDTO {

	private String nombre;
	private String descripcion;
	private Calendar fecha;

	public TrofeoDTO(Trofeo trofeo) {
		this.nombre = trofeo.getNombre();
		this.descripcion = trofeo.getDescripcion();
		this.fecha = trofeo.getFecha();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
