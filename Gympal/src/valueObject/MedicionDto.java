package valueObject;

import java.util.Calendar;

public class MedicionDto {
	
    private Float peso;
    private Float masaMuscular;
    private Float porcentajeGrasaCorporal;
    private Calendar fecha;
    
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public Float getMasaMuscular() {
		return masaMuscular;
	}
	public void setMasaMuscular(Float masaMuscular) {
		this.masaMuscular = masaMuscular;
	}
	public Float getPorcentajeGrasaCorporal() {
		return porcentajeGrasaCorporal;
	}
	public void setPorcentajeGrasaCorporal(Float porcentajeGrasaCorporal) {
		this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
    
    

}
