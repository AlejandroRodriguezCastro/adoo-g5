package models.objetivos;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import adapter.AdapterPesoIdeal;
import controllers.EntrenamientoController;
import controllers.RutinaController;
import models.Ejercicio;
import models.Entrenamiento;
import models.Rutina;
import models.Interfaces.adapters.IAdapterPesoIdeal;
import models.enums.GrupoMuscular;
import valueObject.EntrenamientoDto;
import valueObject.RutinaDto;
import valueObject.SocioDto;

public class ObjetivoBajarDePeso extends Objetivo {

	private IAdapterPesoIdeal pesoIdeal = new AdapterPesoIdeal();
	private float pesoIdealMin;
	private float pesoIdealMax;

	public float calcularPesoIdealMin(float altura) {
		return this.pesoIdeal.obtenerPesoIdealMin(altura);
	}

	public float calcularPesoIdealMax(float altura) {
		return this.pesoIdeal.obtenerPesoIdealMax(altura);
	}

	@Override
	public Rutina CrearRutina(SocioDto socioDto) {

		if (this.getPesoInicial() >= calcularPesoIdealMin(socioDto.getAltura())
				&& this.getPesoInicial() <= calcularPesoIdealMax(socioDto.getAltura())) {
			return null;
		}

		RutinaDto rutinaDto = new RutinaDto();
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		List<Entrenamiento> entrenamientos = new ArrayList<>();
		// int ejerciciosPorEntrenamiento = 4;
		rutinaDto.setDiasCompletados(0);
		rutinaDto.setDuracion(28);
		this.setPesoIdealMin(calcularPesoIdealMin(socioDto.getAltura()));
		this.setPesoIdealMax(calcularPesoIdealMax(socioDto.getAltura()));

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

			for (Ejercicio e : RutinaController.ejerciciosBajarPeso()) {

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

	public float getPesoIdealMin() {
		return pesoIdealMin;
	}

	public void setPesoIdealMin(float pesoIdealMin) {
		this.pesoIdealMin = pesoIdealMin;
	}

	public float getPesoIdealMax() {
		return pesoIdealMax;
	}

	public void setPesoIdealMax(float pesoIdealMax) {
		this.pesoIdealMax = pesoIdealMax;
	}

	@Override
	public boolean objetivoAlcanzado(SocioDto socioDto) {
		if(socioDto.getPeso() != null) {
			if (socioDto.getPeso() >= this.pesoIdealMin && this.getPesoInicial() <= this.pesoIdealMax) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void indicarObjetivo() {
		System.out.println("\n*************META***********");
		System.out.println("Peso entre: " + this.pesoIdealMin + "kg - " + this.pesoIdealMax + "kg");
		System.out.println("****************************");
	}
	
	@Override
	public String toString() {
		return "Objetivo: Bajar de Peso"
				+ "\nPeso Ideal = " + pesoIdealMin + " - " + pesoIdealMax
				+ "\nProgreso Rutina=" + rutina + "";
	}
}
