package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entrenamiento {

	//private List<Ejercicio> Ejercicios;
	private Map<Integer, Ejercicio> Ejercicios = new HashMap<Integer, Ejercicio>();
	private int dia;
	private int cantidadEjercicios;
	private int ejerciciosCompletados;
	private List<Integer> ejerciciosFinalizados = new ArrayList<>();
	private Calendar fechaAsignada;
	private Calendar fechaEjecucion;

	public Entrenamiento(Map<Integer, Ejercicio> ejercicios) {
		super();
		Ejercicios = ejercicios;
	}

	public Entrenamiento() {
		// TODO Auto-generated constructor stub
	}

	/*public List<Ejercicio> getEjercicios() {
		return Ejercicios;
	}*/

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

	/*public void setEjercicios(List<Ejercicio> ejercicios) {
		Ejercicios = ejercicios;
	}*/

	@Override
	public String toString() {
		return "\nEntrenamiento [dia=" + dia + ", cantidadEjercicios=" + cantidadEjercicios + ", ejerciciosCompletados="
				+ ejerciciosCompletados + " fechaAsignada=" + fechaAsignada.get(Calendar.DATE) + "/"
				+ fechaAsignada.get(Calendar.MONTH) + "/" + fechaAsignada.get(Calendar.YEAR) + ", fechaEjecucion="
				+ fechaEjecucion.get(Calendar.DATE) + "/" + fechaEjecucion.get(Calendar.MONTH) + "/"
				+ fechaEjecucion.get(Calendar.YEAR) + "\nEjercicios=" + Ejercicios + "]";
	}

	public int getEjerciciosCompletados() {
		return ejerciciosCompletados;
	}

	public void setEjerciciosCompletados(int ejerciciosCompletados) {
		this.ejerciciosCompletados = ejerciciosCompletados;
	}

	public int getCantidadEjercicios() {
		return cantidadEjercicios;
	}

	public void setCantidadEjercicios(int cantidadEjercicios) {
		this.cantidadEjercicios = cantidadEjercicios;
	}

	public Map<Integer, Ejercicio> getEjercicios() {
		return Ejercicios;
	}

	public void setEjercicios(Map<Integer, Ejercicio> ejercicios) {
		Ejercicios = ejercicios;
	}

	public List<Integer> getEjerciciosFinalizados() {
		return ejerciciosFinalizados;
	}

	public void setEjerciciosFinalizados(List<Integer> ejerciciosFinalizados) {
		this.ejerciciosFinalizados = ejerciciosFinalizados;
	}
	
	public int terminarEjercicio(int ejercicio) {
		this.ejerciciosFinalizados.add(ejercicio);
		this.ejerciciosCompletados += 1;
		return this.cantidadEjercicios - this.ejerciciosCompletados;
	}
	
	public void terminarEntrenamiento() {
		Calendar c1 = Calendar.getInstance();
		this.fechaEjecucion = c1;
	}

}
