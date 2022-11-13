package controllers;

import java.util.Calendar;

import models.Medicion;
import valueObject.MedicionDto;
import valueObject.SocioDto;

public class MedicionController {

	private static Medicion medicion = new Medicion();

	public static MedicionDto realizarMedicion(SocioDto socioDto) {
		MedicionDto medicionDto = new MedicionDto();
		Calendar c1 = Calendar.getInstance();
		medicionDto.setPeso(medicion.obtenerMedicion());
		medicionDto.setFecha(c1);
		medicionDto.setMasaMuscular(medicion.obtenerMasaMuscular(medicionDto.getPeso(), socioDto.getAltura()));
		medicionDto.setPorcentajeGrasaCorporal(
				medicion.obtenerGrasaCorporal(medicionDto.getMasaMuscular(), socioDto.getEdad(), socioDto.getSexo()));
		return medicionDto;
	}

	public static Medicion nuevaMedicion(MedicionDto medicionDto) {
		medicion = new Medicion();
		medicion.setPeso(medicionDto.getPeso());
		medicion.setFecha(medicionDto.getFecha());
		medicion.setMasaMuscular(medicionDto.getMasaMuscular());
		medicion.setPorcentajeGrasaCorporal(medicionDto.getPorcentajeGrasaCorporal());
		return medicion;
	}

}
