package valueObject;

public class SocioDto {
	
	 private String nombre;
	    private String apellido;
	    private String nroSocio;
	    private String documento;
	    private Integer edad;
	    private String sexo;
	    private String passwd;
	    
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
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
	    
	    

}
