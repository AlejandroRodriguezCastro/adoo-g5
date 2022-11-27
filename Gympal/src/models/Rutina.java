package models;

import main.Main;
import menu.Menu;
import models.enums.Dias;
import models.enums.ExigenciaMuscular;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dataSets.DataSets;

public class Rutina {
	private Calendar comienzo;
	private List<Entrenamiento> entrenamientos;
	private int diasCompletados;

	public Rutina() {
		this.comienzo = Main.fechaDeHoy;
	}

	public int getDiasCompletados() {
		return diasCompletados;
	}

	public void setDiasCompletados(int diasCompletados) {
		this.diasCompletados = diasCompletados;
	}

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}

	public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public List<Ejercicio> ejerciciosBajarPeso() {
		List<Ejercicio> ejercicios = new ArrayList<>();
		for (Ejercicio e : DataSets.getEjercicios()) {
			if (e.getNivelAerobico() >= 3)
				ejercicios.add(e);
		}
		return ejercicios;
	}

	public List<Ejercicio> ejerciciosTonificar() {
		List<Ejercicio> ejercicios = new ArrayList<>();
		for (Ejercicio e : DataSets.getEjercicios()) {
			if (e.getNivelAerobico() <= 4 && e.getExigenciaMuscular() == ExigenciaMuscular.ALTA)
				ejercicios.add(e);
		}
		return ejercicios;
	}

	public List<Ejercicio> ejerciciosMantenerFigura() {
		List<Ejercicio> ejercicios = new ArrayList<>();
		for (Ejercicio e : DataSets.getEjercicios()) {
			if ((e.getNivelAerobico() >= 2 && e.getNivelAerobico() <= 4)
					&& ((e.getExigenciaMuscular() == ExigenciaMuscular.MEDIA)
							|| (e.getExigenciaMuscular() == ExigenciaMuscular.BAJA))) 
				ejercicios.add(e);
		}
		return ejercicios;
	}

	@Override
	public String toString() {
		return "\nRutina [diasCompletados="
				+ diasCompletados + "]";
	}
	
	public void diaCompletado() {
		this.diasCompletados += 1;
	}
	
	

}
