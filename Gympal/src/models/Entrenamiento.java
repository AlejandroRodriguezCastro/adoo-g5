package models;

import java.util.Calendar;
import java.util.List;

import models.enums.Dias;

public class Entrenamiento {
	
    private List<Ejercicio> Ejercicios;
    private int dia;
    private Calendar fechaAsignada;
    private Calendar fechaEjecucion;
    

    public Entrenamiento(List<Ejercicio> ejercicios) {
        Ejercicios = ejercicios;
    }

    public Entrenamiento() {
		// TODO Auto-generated constructor stub
	}

	public List<Ejercicio> getEjercicios() {
        return Ejercicios;
    }

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
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

	public void setEjercicios(List<Ejercicio> ejercicios) {
		Ejercicios = ejercicios;
	}

	@Override
	public String toString() {
		return "\nEntrenamiento [dia=" + dia + ", fechaAsignada=" + fechaAsignada.get(Calendar.DATE) + "/" + fechaAsignada.get(Calendar.MONTH)
		+ "/" + fechaAsignada.get(Calendar.YEAR)
				+ ", fechaEjecucion=" + fechaEjecucion.get(Calendar.DATE) + "/" + fechaEjecucion.get(Calendar.MONTH)
				+ "/" + fechaEjecucion.get(Calendar.YEAR) + Ejercicios + "]";
	}


    
    
}
