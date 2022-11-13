package valueObject;

import models.enums.Genero;

public class SocioDto {

	private String nombre;
	private String apellido;
	private String nroSocio;
	private String documento;
	private Integer edad;
	private Genero sexo;
	private Float altura;
	private String passwd;
	private Boolean tieneObjetivo;

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

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
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
}
