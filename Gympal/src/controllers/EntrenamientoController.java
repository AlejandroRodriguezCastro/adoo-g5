package controllers;

import models.Entrenamiento;
import models.Rutina;
import valueObject.EntrenamientoDto;
import valueObject.RutinaDto;

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

}
