package controllers;

import java.util.Calendar;
import java.util.List;

import adapter.LoginAdapter;
import dataSets.DataSets;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.Medicion;
import models.Socio;
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
			 return true;
		 }
		 return false;
	}

	public static void listar() {
		System.out.println(socio);
	}

	public static void pesarSocio() {
		Medicion medicion = new Medicion();
		List<Medicion> mediciones = socio.getMediciones();
		medicion.setPeso(medicion.obtenerMedicion());
		Calendar c1 = Calendar.getInstance();
		System.out.println(
				"Fecha: " + c1.get(Calendar.DATE) + "/" + c1.get(Calendar.MONTH) + "/" + c1.get(Calendar.YEAR));
		medicion.setFecha(Calendar.getInstance());
		System.out.println("Tu peso es: " + medicion.getPeso());
		mediciones.add(medicion);
		socio.setMediciones(mediciones);
		dataSets.guardarSocio(socio);
	}

}
