package controllers;

import java.util.List;

import models.Ejercicio;
import models.Entrenamiento;
import models.Medicion;
import models.Rutina;
import models.objetivos.Objetivo;
import valueObject.RutinaDto;
import valueObject.SocioDto;

public class RutinaController {

	private static Rutina rutina = new Rutina();

	public static Rutina crearRutina(Objetivo objetivo, SocioDto socioDto) {
		return objetivo.CrearRutina(socioDto);
	}

	public static Rutina nuevaRutina(RutinaDto rutinaDto) {
		rutina = new Rutina();
		rutina.setDiasCompletados(rutinaDto.getDiasCompletados());
		rutina.setEntrenamientos(rutinaDto.getEntrenamientos());
		rutina.setDuracion(rutinaDto.getDuracion());
		return rutina;
	}

	public static List<Ejercicio> ejerciciosBajarPeso() {
		return rutina.ejerciciosBajarPeso();
	}

	public static List<Ejercicio> ejerciciosTonificar() {
		return rutina.ejerciciosTonificar();
	}

	public static List<Ejercicio> ejerciciosMantenerFigura() {
		return rutina.ejerciciosMantenerFigura();
	}

}
