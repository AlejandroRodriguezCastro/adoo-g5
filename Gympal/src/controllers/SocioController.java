package controllers;

import java.util.ArrayList;
import java.util.List;
import adapter.LoginAdapter;
import dataSets.DataSets;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.Medicion;
import models.Socio;
import models.objetivos.Objetivo;
import valueObject.EntrenamientoDto;
import valueObject.MedicionDto;
import valueObject.SocioDto;

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
			return true;
		}
		return false;
	}
	
	public static boolean exists(SocioDto socioDto) {
		if (dataSets.getSocioByDocumento(socioDto.getDocumento()) != null){
			return true;
		}
		return false;
	}

	public static void listar() {
		System.out.println(socio);
	}

	public static void pesarSocio() {
		List<Medicion> mediciones = new ArrayList<>();
		mediciones = socio.getMediciones();
		mediciones.add(MedicionController.nuevaMedicion(socio.realizarMedicion()));
		socio.setMediciones(mediciones);
		dataSets.guardarSocio(socio);
	}
	
	public static void registrarPesaje(MedicionDto medicionDto) {
		List<Medicion> mediciones = new ArrayList<>();
		mediciones = socio.getMediciones();
		mediciones.add(MedicionController.nuevaMedicion(medicionDto));
		socio.setMediciones(mediciones);
		dataSets.guardarSocio(socio);
	}

	public static void setearObjetivo(Objetivo objetivo) {
		socio.setearObjetvo(objetivo);
	}
	
	public static EntrenamientoDto comenzarEntrenamiento() {
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		entrenamientoDto = socio.comenzarEntrenamiento();
		dataSets.guardarSocio(socio);
		return entrenamientoDto;
	}

	public static String nuevoSocio(SocioDto socioDto) {
		socio = new Socio(socioDto);
		dataSets.guardarSocio(socio);
		autenticador.register(socio.getNroSocio(),socioDto.getPasswd());
		return socio.getNroSocio();
	}

}
