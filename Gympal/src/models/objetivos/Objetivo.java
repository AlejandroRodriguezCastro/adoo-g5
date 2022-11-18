package models.objetivos;

import models.Interfaces.IObserver;
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

	public abstract Rutina CrearRutina();

	@Override
	public String toString() {
		return "Objetivo [rutina=" + rutina + "]";
	}
	
	

}
