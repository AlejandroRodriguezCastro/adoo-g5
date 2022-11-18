package valueObject;

import java.util.List;

import models.Entrenamiento;

public class RutinaDto {
	
	private int duracion;
	private int diasCompletados;
	private List<Entrenamiento> entrenamientos;
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getDiasCompletados() {
		return diasCompletados;
	}
	public void setDiasCompletados(int diasCompletados) {
		this.diasCompletados = diasCompletados;
	}
	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientos;
	}
	public void setEntrenamientos(List<Entrenamiento> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}
	
	

}
