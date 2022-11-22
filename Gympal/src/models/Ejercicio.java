package models;

import models.enums.ExigenciaMuscular;
import models.enums.GrupoMuscular;
import valueObject.EjercicioDto;

public class Ejercicio {

	private Integer series;
	private Integer repeticiones;
	private String descripcion;
	private Float pesoAsignado;
	private Integer nivelAerobico;
	private ExigenciaMuscular exigenciaMuscular;
	private GrupoMuscular grupoMuscular;
	private String videoUrl;

	public Ejercicio(String descripcion, Integer series, Integer repeticiones, Float pesoAsignado,
			Integer nivelAerobico, ExigenciaMuscular exigenciaMuscular, GrupoMuscular grupoMuscular, String videoUrl) {
		this.descripcion = descripcion;
		this.series = series;
		this.repeticiones = repeticiones;
		this.pesoAsignado = pesoAsignado;
		this.nivelAerobico = nivelAerobico;
		this.exigenciaMuscular = exigenciaMuscular;
		this.grupoMuscular = grupoMuscular;
		this.videoUrl = videoUrl;
	}

	public Ejercicio() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSeries() {
		return series;
	}

	public Integer getRepeticiones() {
		return repeticiones;
	}

	public Float getPesoAsignado() {
		return pesoAsignado;
	}

	public Integer getNivelAerobico() {
		return nivelAerobico;
	}

	public ExigenciaMuscular getExigenciaMuscular() {
		return exigenciaMuscular;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "\nEjercicio [descripcion=" + descripcion + ", \ngrupoMuscular=" + grupoMuscular + ", \nexigenciaMuscular="
				+ exigenciaMuscular + ", \nnivelAerobico=" + nivelAerobico + ", \npesoAsignado=" + pesoAsignado
				+ ", series=" + series + ", repeticiones=" + repeticiones + ", videoUrl=" + videoUrl + "]";
	}

	public void reforzarEjercicio(EjercicioDto ejercicioDto) {
		this.series = ejercicioDto.getSeries();
		this.repeticiones = ejercicioDto.getRepeticiones();
		this.pesoAsignado = ejercicioDto.getPesoAsignado();		
	}


	
	
}
