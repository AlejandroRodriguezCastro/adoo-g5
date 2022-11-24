package models.objetivos;

import models.Interfaces.IObserver;
import valueObject.SocioDto;
import models.Rutina;
import models.Socio;

public abstract class Objetivo implements IObserver {

    private Socio socio;
    private Float pesoInicial;
    private Rutina rutina;

    public Socio getSocio() {
        return socio;
    }

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
	
	public abstract boolean objetivoAlcanzado();
	
	public abstract void indicarObjetivo();

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public void setPesoInicial(Float pesoInicial) {
		this.pesoInicial = pesoInicial;
	}

	@Override
	public String toString() {
		return "Objetivo [rutina=" + rutina + "]";
	}
	
	

}
