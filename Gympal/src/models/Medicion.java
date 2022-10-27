package models;

import models.Interfaces.IObservable;
import models.Interfaces.IObserver;

import java.util.Calendar;
import java.util.List;

import adapter.AdapterBalanzaGimnasio;

public class Medicion implements IObservable {

    private Float peso;
    private Float masaMuscular;
    private Float porcentajeGrasaCorporal;
    private Calendar fecha;
    private List<IObserver> observers;

    public Medicion() {
    }

	public float obtenerMedicion() {
		AdapterBalanzaGimnasio a = new AdapterBalanzaGimnasio();
		return a.obtenerPeso();
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

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public void setMasaMuscular(Float masaMuscular) {
		this.masaMuscular = masaMuscular;
	}

	public void setPorcentajeGrasaCorporal(Float porcentajeGrasaCorporal) {
		this.porcentajeGrasaCorporal = porcentajeGrasaCorporal;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}



}
