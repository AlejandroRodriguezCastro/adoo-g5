package models;

import java.util.Calendar;

public class Medicion {
    private Float peso;
    private Float masaMuscular;
    private Float porcentajeGrasaCorporal;
    private Calendar fecha;

    public Medicion(Float peso, Float masaMuscular, Float porcentajeGrasaCorporal, Calendar fecha) {
        this.peso = peso;
        this.masaMuscular = masaMuscular;
        this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
        this.fecha = fecha;
    }

    public Float getPeso() {
        return peso;
    }

    public Float getMasaMuscular() {
        return masaMuscular;
    }

    public Float getPorcentajeGrasaCorporal() {
        return porcentajeGrasaCorporal;
    }

    public Calendar getFecha() {
        return fecha;
    }
}
