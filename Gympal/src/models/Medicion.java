package models;

import models.Interfaces.IObservable;
import models.Interfaces.IObserver;

import java.util.Calendar;
import java.util.List;

public class Medicion implements IObservable {

    private Float peso;
    private Float masaMuscular;
    private Float porcentajeGrasaCorporal;
    private Calendar fecha;
    private List<IObserver> observers;

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

    @Override
    public void agregar(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void eliminar(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificar() {
        observers.forEach(observer -> observer.serNotificadoPor(this));
    }
}
