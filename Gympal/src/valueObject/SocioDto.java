package valueObject;

import java.util.ArrayList;
import java.util.List;

import models.Medicion;
import models.Trofeo;
import models.enums.Sexo;
import models.objetivos.Objetivo;

public class SocioDto {

	private String nombre;
	private String apellido;
	private String nroSocio;
	private String documento;
	private Integer edad;
	private Sexo sexo;
	private Float altura;
	private Float peso;
	private Float IMC;
	private Float grasa;
	private String passwd;
	private Boolean tieneObjetivo;
	private Objetivo objetivo;
	private List<Trofeo> trofeos;

	public SocioDto(String nombre2, String apellido2, String nroSocio2, String documento2, Integer edad2, Sexo sexo2,
			Float altura2) {
		this.nombre = nombre2;
		this.apellido = apellido2;
		this.nroSocio = nroSocio2;
		this.documento = documento2;
		this.edad = edad2;
		this.sexo = sexo2;
		this.altura = altura2; 
	}

	public SocioDto() {
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(String nroSocio) {
		this.nroSocio = nroSocio;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Boolean getTieneObjetivo() {
		return tieneObjetivo;
	}

	public void setTieneObjetivo(Boolean tieneOBjetivo) {
		this.tieneObjetivo = tieneOBjetivo;
	}

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Float getIMC() {
		return IMC;
	}

	public void setIMC(Float iMC) {
		IMC = iMC;
	}

	public Float getGrasa() {
		return grasa;
	}

	public void setGrasa(Float grasa) {
		this.grasa = grasa;
	}

	public void setTrofeos(List<Trofeo> trofeos) {
		this.trofeos = trofeos;
		
	}
	
	public List<TrofeoDTO> getTrofeos() {
		List<TrofeoDTO> trofeosDto = new ArrayList<TrofeoDTO>();
		for (Trofeo trofeo: trofeos) {
			trofeosDto.add(new TrofeoDTO(trofeo));
		}
		return trofeosDto;
	}
}
