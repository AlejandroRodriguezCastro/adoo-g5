package models;

import adapter.LoginAdapter;
import controllers.MedicionController;
import controllers.RutinaController;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.enums.Sexo;
import models.objetivos.Objetivo;
import valueObject.EntrenamientoDto;
import valueObject.MedicionDto;
import valueObject.SocioDto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Socio {
	private static int Socios = 123456;
	private String nombre;
	private String apellido;
	private String nroSocio;
	private String documento;
	private Integer edad;
	private Sexo sexo;
	private Float altura;
	private List<Medicion> mediciones;
	private Objetivo objetivo;
	private List<Trofeo> trofeos;
	private IAdapterAutenticator autenticador;

	public Socio() {
		this.autenticador = new LoginAdapter();
	}

	public Socio(String nombre, String apellido, String nroSocio, String documento, Integer edad, Sexo sexo,
			Float altura) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroSocio = nroSocio;
		this.documento = documento;
		this.edad = edad;
		this.sexo = sexo;
		this.altura = altura;
		this.mediciones = new ArrayList<>();
	}

	public Socio(String nombre, String apellido, String documento, Integer edad, Sexo sexo, Float altura) {
		Socios += 1;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroSocio = Integer.toString(Socios);
		this.documento = documento;
		this.edad = edad;
		this.sexo = sexo;
		this.altura = altura;
		this.mediciones = new ArrayList<>();
	}

	public Socio(SocioDto socioDto) {
		Socios += 1;
		this.nombre = socioDto.getNombre();
		this.apellido = socioDto.getApellido();
		this.nroSocio = Integer.toString(Socios);
		this.documento = socioDto.getDocumento();
		this.edad = socioDto.getEdad();
		this.sexo = socioDto.getSexo();
		this.altura = socioDto.getAltura();
		this.mediciones = new ArrayList<>();
	}

	public void setearObjetvo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public void setMediciones(List<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	public MedicionDto realizarMedicion() {

		SocioDto socioDto = new SocioDto();
		socioDto.setAltura(this.altura);
		socioDto.setEdad(this.edad);
		socioDto.setSexo(this.sexo);

		return MedicionController.realizarMedicion(socioDto);

		/*
		 * System.out.println( "Fecha: " + c1.get(Calendar.DATE) + "/" +
		 * c1.get(Calendar.MONTH) + "/" + c1.get(Calendar.YEAR));
		 * medicion.setFecha(Calendar.getInstance()); System.out.println("Tu peso es: "
		 * + medicion.getPeso()); mediciones.add(medicion);
		 * socio.setMediciones(mediciones); return null;
		 */
	}

	public EntrenamientoDto comenzarEntrenamiento() {
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		if (this.objetivo.getRutina() == null) {
			this.objetivo.setRutina(RutinaController.crearRutina(this.objetivo));

			System.out.println(this.objetivo.getRutina().toString());

			for (Entrenamiento e : this.objetivo.getRutina().getEntrenamientos()) {

				if (e.getDia() == this.objetivo.getRutina().getDiasCompletados() + 1) {
					entrenamientoDto.setCantidadEjercicios(e.getCantidadEjercicios());
					entrenamientoDto.setEjerciciosCompletados(e.getEjerciciosCompletados());
					entrenamientoDto.setDia(e.getDia());
					entrenamientoDto.setEjercicios(e.getEjercicios());
					entrenamientoDto.setFechaAsignada(e.getFechaAsignada());
					entrenamientoDto.setFechaEjecucion(e.getFechaEjecucion());
				}
				return entrenamientoDto;
			}
		} else {

			for (Entrenamiento e : this.objetivo.getRutina().getEntrenamientos()) {

				if (e.getDia() == this.objetivo.getRutina().getDiasCompletados() + 1) {
					entrenamientoDto.setCantidadEjercicios(e.getCantidadEjercicios());
					entrenamientoDto.setEjerciciosCompletados(e.getEjerciciosCompletados());
					entrenamientoDto.setDia(e.getDia());
					entrenamientoDto.setEjercicios(e.getEjercicios());
					entrenamientoDto.setFechaAsignada(e.getFechaAsignada());
					entrenamientoDto.setFechaEjecucion(e.getFechaEjecucion());
				}
				return entrenamientoDto;
			}

		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNroSocio() {
		return nroSocio;
	}

	public String getDocumento() {
		return documento;
	}

	public Integer getEdad() {
		return edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Float getAltura() {
		return altura;
	}

	public List<Medicion> getMediciones() {
		return mediciones;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public List<Trofeo> getTrofeos() {
		return trofeos;
	}

	public IAdapterAutenticator getAutenticador() {
		return autenticador;
	}

	public void setNroSocio(String nroSocio) {
		this.nroSocio = nroSocio;
	}

	@Override
	public String toString() {
		return "\nSocio [nombre=" + nombre + ", apellido=" + apellido + ", nroSocio=" + nroSocio + ", documento="
				+ documento + ", edad=" + edad + ", sexo=" + sexo + ", altura=" + altura + ", \n mediciones="
				+ mediciones + "]";
	}

	public SocioDto getSocioDto() {
		SocioDto socio = new SocioDto(nombre, apellido, nroSocio, documento, edad, sexo, altura);
		return socio;
	}

}
