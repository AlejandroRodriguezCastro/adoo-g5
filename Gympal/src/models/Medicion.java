package models;

import models.Interfaces.IObservable;
import models.Interfaces.IObserver;
import models.Interfaces.adapters.IAdapterPeso;

import java.util.Calendar;
import java.util.List;

import adapter.AdapterBalanzaGimnasio;
import adapter.LoginAdapter;

public class Medicion implements IObservable {



	@Override
	public String toString() {
		return "\n Medicion [peso=" + peso + ", masaMuscular=" + masaMuscular + ", porcentajeGrasaCorporal="
				+ porcentajeGrasaCorporal + ", fecha=" + fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR) + "]";
	}

	private IAdapterPeso adapterPeso;
    private Float peso;
    private Float masaMuscular;
    private Float porcentajeGrasaCorporal;
    private Calendar fecha;
    private List<IObserver> observers;

    public Medicion() {
    	this.adapterPeso = new AdapterBalanzaGimnasio();
    }

	public float obtenerMedicion() {
		return this.adapterPeso.obtenerPeso();
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
