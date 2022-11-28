package models.Interfaces;

import models.Rutina;
import valueObject.SocioDto;

public interface IObjetivo {
	public Float getPesoInicial();
	public Rutina getRutina();
	public void setRutina(Rutina rutina);
	public Rutina CrearRutina(SocioDto socioDto);
	public boolean objetivoAlcanzado(SocioDto socioDto);
	public void indicarObjetivo();
	public void setPesoInicial(Float pesoInicial);
	public String toString();
	
}
