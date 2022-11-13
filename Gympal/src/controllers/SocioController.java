package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import adapter.LoginAdapter;
import dataSets.DataSets;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.Medicion;
import models.Socio;
import models.objetivos.Objetivo;
import valueObject.MedicionDto;
import valueObject.SocioDto;

public class SocioController{

	private static final DataSets dataSets = DataSets.getDataSet();
	private static Socio socio = new Socio();
	private static final IAdapterAutenticator autenticador = new LoginAdapter();

	public static boolean login(SocioDto socioDto) {
		 if (autenticador.login(socioDto.getNroSocio(), socioDto.getPasswd())){
			 socio = dataSets.getSocioByNroSocio(socioDto.getNroSocio());
			 socioDto.setNombre(socio.getNombre());
			 socioDto.setApellido(socio.getApellido());
			 socioDto.setTieneObjetivo(socio.getObjetivo() != null);
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

	public static void setearObjetivo(Objetivo objetivo) {
		socio.setearObjetvo(objetivo);
	}

}
