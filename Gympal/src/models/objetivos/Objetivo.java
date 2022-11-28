package models.objetivos;

import valueObject.SocioDto;
import models.Rutina;
import models.Interfaces.IObjetivo;

public abstract class Objetivo implements IObjetivo{

    private Float pesoInicial;
    private Rutina rutina;

    public Float getPesoInicial() {
        return pesoInicial;
    }

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

	public abstract Rutina CrearRutina(SocioDto socioDto);
	
	public abstract boolean objetivoAlcanzado(SocioDto socioDto);
	
	public abstract void indicarObjetivo();

	public void setPesoInicial(Float pesoInicial) {
		this.pesoInicial = pesoInicial;
	}

	@Override
	public String toString() {
		return "Objetivo [rutina=" + rutina + "]";
	}
	
	

}
