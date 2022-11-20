package valueObject;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import models.Ejercicio;
import models.enums.Dias;

public class EntrenamientoDto {
	
	private List<Ejercicio> Ejercicios;
    private int dia;
    private int cantidadEjercicios;
    private int ejerciciosCompletados;
    private Calendar fechaAsignada;
    private Calendar fechaEjecucion;
    
    public EntrenamientoDto(){
        Calendar calendario = Calendar.getInstance();
		calendario.set(1901, 1,1);
		this.setFechaEjecucion(calendario);
    }
    
	public List<Ejercicio> getEjercicios() {
		return Ejercicios;
	}
	public void setEjercicios(List<Ejercicio> ejercicios) {
		Ejercicios = ejercicios;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia2) {
		this.dia = dia2;
	}
	public Calendar getFechaAsignada() {
		return fechaAsignada;
	}
	public void setFechaAsignada(Calendar fechaAsignada) {
		this.fechaAsignada = fechaAsignada;
	}

	public Calendar getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Calendar fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public int getCantidadEjercicios() {
		return cantidadEjercicios;
	}

	public void setCantidadEjercicios(int cantidadEjercicios) {
		this.cantidadEjercicios = cantidadEjercicios;
	}

	public int getEjerciciosCompletados() {
		return ejerciciosCompletados;
	}

	public void setEjerciciosCompletados(int ejerciciosCompletados) {
		this.ejerciciosCompletados = ejerciciosCompletados;
	}

}
