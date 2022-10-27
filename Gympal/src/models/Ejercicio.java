package models;

import models.enums.ExigenciaMuscular;
import models.enums.GrupoMuscular;

public class Ejercicio {

    private Integer series;
    private Integer repeticiones;
    private Float pesoAsignado;
    private Integer nivelAerobico;
    private ExigenciaMuscular exigenciaMuscular;
    private GrupoMuscular grupoMuscular;
    private String videoUrl;

    public Ejercicio(Integer series, Integer repeticiones, Float pesoAsignado, Integer nivelAerobico, ExigenciaMuscular exigenciaMuscular, GrupoMuscular grupoMuscular, String videoUrl) {
        this.series = series;
        this.repeticiones = repeticiones;
        this.pesoAsignado = pesoAsignado;
        this.nivelAerobico = nivelAerobico;
        this.exigenciaMuscular = exigenciaMuscular;
        this.grupoMuscular = grupoMuscular;
        this.videoUrl = videoUrl;
    }

    public Integer getSeries() {
        return series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public Float getPesoAsignado() {
        return pesoAsignado;
    }

    public Integer getNivelAerobico() {
        return nivelAerobico;
    }

    public ExigenciaMuscular getExigenciaMuscular() {
        return exigenciaMuscular;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
}
