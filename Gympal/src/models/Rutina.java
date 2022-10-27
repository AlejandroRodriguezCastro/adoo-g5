package models;

import models.enums.Dias;

import java.util.List;

import models.enums.Dias;

public class Rutina {
    private Entrenamiento entrenamiento;
    private List<Dias> diasDeEntrenamiento;
    private Integer duracion;

    public Rutina(List<Dias> diasDeEntrenamiento, Integer duracion) {
        this.diasDeEntrenamiento = diasDeEntrenamiento;
        this.duracion = duracion;
    }

    public List<Dias> getDiasDeEntrenamiento() {
        return diasDeEntrenamiento;
    }

    public Integer getDuracion() {
        return duracion;
    }
}
