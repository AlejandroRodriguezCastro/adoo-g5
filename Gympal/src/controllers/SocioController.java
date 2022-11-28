package controllers;

import java.util.ArrayList;
import java.util.List;
import adapter.LoginAdapter;
import dataSets.DataSets;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.Medicion;
import models.Socio;
import models.objetivos.ObjetivoBajarDePeso;
import models.objetivos.ObjetivoMantenerFigura;
import models.objetivos.ObjetivoTonificarCuerpo;
import valueObject.EjercicioDto;
import valueObject.EntrenamientoDto;
import valueObject.MedicionDto;
import valueObject.SocioDto;
import valueObject.TrofeoDTO;

public class SocioController {

	private static final DataSets dataSets = DataSets.getDataSet();
	private static Socio socio = new Socio();
	private static final IAdapterAutenticator autenticador = new LoginAdapter();

	public static boolean login(SocioDto socioDto) {
		if (autenticador.login(socioDto.getNroSocio(), socioDto.getPasswd())) {
			socio = dataSets.getSocioByNroSocio(socioDto.getNroSocio());
			socioDto.setNombre(socio.getNombre());
			socioDto.setApellido(socio.getApellido());
			socioDto.setTieneObjetivo(socio.getObjetivo() != null);
			socioDto.setObjetivo(socio.getObjetivo());
			return true;
		}
		return false;
	}

	public static boolean exists(SocioDto socioDto) {
		if (dataSets.getSocioByDocumento(socioDto.getDocumento()) != null) {
			return true;
		}
		return false;
	}

	public static void listar() {
		System.out.println(socio);
	}

	public static void pesarSocio() {
		//medicion sistema
		List<Medicion> mediciones = new ArrayList<>();
		mediciones = socio.getMediciones();
		mediciones.add(MedicionController.nuevaMedicion(socio.realizarMedicion()));
		socio.setMediciones(mediciones);
		dataSets.guardarSocio(socio);
	}

	public static void registrarPesaje(MedicionDto medicionDto) {
		//medición manual
		List<Medicion> mediciones = new ArrayList<>();
		mediciones = socio.getMediciones();
		mediciones.add(MedicionController.nuevaMedicion(medicionDto));
		socio.setMediciones(mediciones);
		dataSets.guardarSocio(socio);
	}

	public static void setearObjetivo(int objetivo) {
		switch (objetivo) {
		case 1:
			socio.setearObjetivo(new ObjetivoBajarDePeso());
			break;
		case 2:
			socio.setearObjetivo(new ObjetivoMantenerFigura());
			break;
		case 3:
			socio.setearObjetivo(new ObjetivoTonificarCuerpo());
			break;
		}
	}

	public static EntrenamientoDto comenzarEntrenamiento() {
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		entrenamientoDto = socio.comenzarEntrenamiento();
		if (entrenamientoDto != null) {
			dataSets.guardarSocio(socio);
			return entrenamientoDto;
		} else
			return null;
	}

	public static String nuevoSocio(SocioDto socioDto) {
		socio = new Socio(socioDto);
		dataSets.guardarSocio(socio);
		autenticador.register(socio.getNroSocio(), socioDto.getPasswd());
		return socio.getNroSocio();
	}

	public static void terminarEjercicio(int ejercicio) {
		socio.terminarEjercicio(ejercicio);
		dataSets.guardarSocio(socio);
	}

	public static void reforzarEjercicio(EjercicioDto ejercicioDto) {
		socio.reforzarEjercicio(ejercicioDto);
		dataSets.guardarSocio(socio);

	}
	
	public static void terminarEntrenamiento() {
		socio.terminarEntrenamiento();
		dataSets.guardarSocio(socio);
	}

	public static List<EntrenamientoDto> registroEntrenamiento() {
		SocioDto socioDto = new SocioDto();
		socioDto.setObjetivo(socio.getObjetivo());

		if (socioDto.getObjetivo().getRutina() != null)
			return EntrenamientoController.registroEntrenamiento(socioDto);
		else
			return null;
	}

	public static List<TrofeoDTO> registroTrofeos() {
		SocioDto socioDto = new SocioDto();
		socioDto.setTrofeos(socio.getTrofeos());
		return socioDto.getTrofeos();
	}

}
