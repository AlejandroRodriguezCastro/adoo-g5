package models;

import adapter.LoginAdapter;
import dataSets.DataSets;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.objetivos.Objetivo;
import valueObject.SocioDto;

import java.util.List;

public class Socio {

	private String nombre;
	private String apellido;
	private String nroSocio;
	private String documento;
	private Integer edad;
	private String sexo;
	private Float altura;
	private List<Medicion> mediciones;
	private Objetivo objetivo;
	private List<Trofeo> trofeos;
	private IAdapterAutenticator autenticador;

	public Socio() {
		this.autenticador = new LoginAdapter();
	}

	public Socio(String nombre, String apellido, String nroSocio, String documento, Integer edad, String sexo,
			Float altura) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroSocio = nroSocio;
		this.documento = documento;
		this.edad = edad;
		this.sexo = sexo;
		this.altura = altura;
	}

	public void setearObjetvo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public void setMediciones(List<Medicion> mediciones) {
		this.mediciones = mediciones;
	}

	public void realziarMedicion() {
		return;
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

	public String getSexo() {
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

	public SocioDto login(String user, String passwd) {
		SocioDto s = new SocioDto();
		if (this.autenticador.loguin(user, passwd)) {
			for (Socio ss : DataSets.getUsuarios()) {
				if (ss.getNroSocio().equals(user)) {
					s.setNombre(ss.getNombre());
					s.setApellido(ss.getApellido());
					s.setNroSocio(ss.getNroSocio());
					return s;
				}
			}

		}
		return null;
	}

	@Override
	public String toString() {
		return "Socio [nombre=" + nombre + ", apellido=" + apellido + ", nroSocio=" + nroSocio + ", documento="
				+ documento + ", edad=" + edad + ", sexo=" + sexo + ", altura=" + altura + "]";
	}

}
