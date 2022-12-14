package models.objetivos;

import valueObject.SocioDto;
import java.util.ArrayList;
import java.util.List;
import models.Rutina;

public abstract class Objetivo{

    private Float pesoInicial;
    protected Rutina rutina;
    private List<Rutina> rutinas = new ArrayList<Rutina>();

    public Float getPesoInicial() {
        return pesoInicial;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
    	if(rutina != null) {
            this.rutinas.add(rutina);
    	}
    	this.rutina = rutina;
    }

	public abstract Rutina CrearRutina(SocioDto socioDto);
	
	public abstract boolean objetivoAlcanzado(SocioDto socioDto);
	
	public abstract void indicarObjetivo();

	public void setPesoInicial(Float pesoInicial) {
		this.pesoInicial = pesoInicial;
	}

	@Override
	public abstract String toString();
	
	

}
