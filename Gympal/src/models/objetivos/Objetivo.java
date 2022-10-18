package models.objetivos;

import models.Rutina;
import models.Socio;

public abstract class Objetivo {

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
}
