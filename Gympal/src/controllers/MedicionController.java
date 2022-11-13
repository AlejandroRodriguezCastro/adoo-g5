package controllers;

import java.util.Calendar;

import models.Medicion;
import valueObject.MedicionDto;

public class MedicionController {
	
	private static Medicion medicion = new Medicion();

	
	public static MedicionDto realizarMedicion() {
		MedicionDto medicionDto = new MedicionDto();
		Calendar c1 = Calendar.getInstance();
		medicionDto.setPeso(medicion.obtenerMedicion());
		medicionDto.setFecha(c1);
		return medicionDto;
	}
	
	public static Medicion nuevaMedicion(MedicionDto medicionDto) {
		medicion = new Medicion();
		medicion.setPeso(medicionDto.getPeso());
		medicion.setFecha(medicionDto.getFecha());
		return medicion;
	}
	
}
