package models.objetivos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import controllers.EntrenamientoController;
import controllers.RutinaController;
import models.Ejercicio;
import models.Entrenamiento;
import models.Rutina;
import models.Interfaces.IObservable;
import models.enums.GrupoMuscular;
import valueObject.EntrenamientoDto;
import valueObject.RutinaDto;

public class ObjetivoMantenerFigura extends Objetivo {
	@Override
	public void serNotificadoPor(IObservable observable) {
		return;
	}

	@Override
	public Rutina CrearRutina() {

		RutinaDto rutinaDto = new RutinaDto();
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		Calendar c1 = Calendar.getInstance();
		List<Entrenamiento> entrenamientos = new ArrayList<>();
		// int ejerciciosPorEntrenamiento = 4;
		rutinaDto.setDiasCompletados(0);
		rutinaDto.setDuracion(28);

		for (int dia = 1; dia <= rutinaDto.getDuracion(); dia++) {

			Map<Integer, Ejercicio> ejercicios = new HashMap<Integer, Ejercicio>();

			if (dia == 1) {
				Date dt = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime(dt);
				entrenamientoDto.setFechaAsignada(c);
			}

			else {
				Date dt = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime(dt);
				c.add(Calendar.DAY_OF_YEAR, dia - 1);
				entrenamientoDto.setFechaAsignada(c);
			}
			entrenamientoDto.setDia(dia);
			entrenamientoDto.setEjerciciosCompletados(0);
			entrenamientoDto.setCantidadEjercicios(4);

			List<Ejercicio> ejerciciosAuxiliares = new ArrayList<>();

			for (Ejercicio e : RutinaController.ejerciciosMantenerFigura()) {

				if (dia == 1 || dia == 6 || dia == 11 || dia == 16 || dia == 21 || dia == 26 || dia == 25) {
					// BRAZOS
					if (e.getGrupoMuscular() == GrupoMuscular.BRAZOS) {
						ejerciciosAuxiliares.add(e);
					}

				}
				if (dia == 2 || dia == 7 || dia == 12 || dia == 17 || dia == 22 || dia == 27 || dia == 25) {
					// PECHO
					if (e.getGrupoMuscular() == GrupoMuscular.PECHO) {
						ejerciciosAuxiliares.add(e);
					}

				}
				if (dia == 3 || dia == 8 || dia == 13 || dia == 18 || dia == 23 || dia == 28) {
					// HOMBROS
					if (e.getGrupoMuscular() == GrupoMuscular.HOMBROS) {
						ejerciciosAuxiliares.add(e);
					}
				}
				if (dia == 4 || dia == 9 || dia == 14 || dia == 19 || dia == 24 || dia == 21) {
					// ESPALDA
					if (e.getGrupoMuscular() == GrupoMuscular.ESPALDA) {
						ejerciciosAuxiliares.add(e);
					}
				}
				if (dia == 5 || dia == 10 || dia == 15 || dia == 20 || dia == 25 || dia == 21) {
					// PIERNAS
					if (e.getGrupoMuscular() == GrupoMuscular.PIERNAS) {
						ejerciciosAuxiliares.add(e);
					}
				}
			}

			List<Integer> ejerciciosDisponibles = new ArrayList<>();
			int ejerciciosAgregados = 0;

			if (ejerciciosAuxiliares.size() < 4) {
				entrenamientoDto.setCantidadEjercicios(ejerciciosAuxiliares.size());
			}

			for (int i = 0; i <= 999; i++) {
				int indiceAleatorio;
				boolean repetido = false;

				indiceAleatorio = numeroAleatorioEnRango(0, ejerciciosAuxiliares.size() - 1);

				for (int j : ejerciciosDisponibles) {
					if (j == indiceAleatorio)
						repetido = true;
				}

				if (!repetido) {
					ejerciciosDisponibles.add(indiceAleatorio);
					ejercicios.put(ejerciciosAgregados + 1, ejerciciosAuxiliares.get(indiceAleatorio));
					ejerciciosAgregados++;
				}

				if (ejerciciosAgregados == entrenamientoDto.getCantidadEjercicios())
					break;
			}

			entrenamientoDto.setEjercicios(ejercicios);
			entrenamientos.add(EntrenamientoController.nuevoEntrenamiento(entrenamientoDto));

		}

		rutinaDto.setEntrenamientos(entrenamientos);

		return RutinaController.nuevaRutina(rutinaDto);

	}

	public static int numeroAleatorioEnRango(int minimo, int maximo) {
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}
}
