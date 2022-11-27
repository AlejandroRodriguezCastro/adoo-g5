package controllers;

import java.util.List;

import models.Ejercicio;
import models.Entrenamiento;
import models.Rutina;
import valueObject.EjercicioDto;
import valueObject.EntrenamientoDto;

public class EntrenamientoController {
	
	private static Entrenamiento entrenamiento = new Entrenamiento();
	
	public static Entrenamiento nuevoEntrenamiento(EntrenamientoDto entrenamientoDto) {
		entrenamiento = new Entrenamiento();
		entrenamiento.setDia(entrenamientoDto.getDia());
		entrenamiento.setFechaAsignada(entrenamientoDto.getFechaAsignada());
		entrenamiento.setEjercicios(entrenamientoDto.getEjercicios());
		entrenamiento.setFechaEjecucion(entrenamientoDto.getFechaEjecucion());
		return entrenamiento;
	}
	
	public static int terminarEjercicio(Entrenamiento entrenamiento, int ejercicio) {
		return entrenamiento.terminarEjercicio(ejercicio);
	}
	
	public static void terminarEntrenamiento(Entrenamiento entrenamiento) {
		entrenamiento.terminarEntrenamiento();
	}

	public static void reforzarEjercicio(Ejercicio ejercicio, EjercicioDto ejercicioDto) {
		ejercicio.reforzarEjercicio(ejercicioDto);
	}
	
	public static List<EntrenamientoDto> registroEntrenamiento(Rutina rutina) {
		return entrenamiento.registroEntrenamiento(rutina);
	}

}
