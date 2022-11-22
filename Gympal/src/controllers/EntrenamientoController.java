package controllers;

import models.Ejercicio;
import models.Entrenamiento;
import valueObject.EntrenamientoDto;

public class EntrenamientoController {
	
	private static Entrenamiento entrenamiento = new Entrenamiento();
	
	public static Entrenamiento nuevoEntrenamiento(EntrenamientoDto entrenamientoDto) {
		entrenamiento = new Entrenamiento();
		entrenamiento.setDia(entrenamientoDto.getDia());
		entrenamiento.setFechaAsignada(entrenamientoDto.getFechaAsignada());
		entrenamiento.setEjercicios(entrenamientoDto.getEjercicios());
		entrenamiento.setFechaEjecucion(entrenamientoDto.getFechaEjecucion());
		entrenamiento.setCantidadEjercicios(entrenamientoDto.getCantidadEjercicios());
		entrenamiento.setEjerciciosCompletados(entrenamientoDto.getEjerciciosCompletados());
		return entrenamiento;
	}
	
	public static int terminarEjercicio(Entrenamiento entrenamiento, int ejercicio) {
		return entrenamiento.terminarEjercicio(ejercicio);
	}
	
	public static void terminarEntrenamiento(Entrenamiento entrenamiento) {
		entrenamiento.terminarEntrenamiento();
	}

}
