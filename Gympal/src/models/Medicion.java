package models;

import models.Interfaces.IObservable;
import models.Interfaces.IObserver;
import models.Interfaces.adapters.IAdapterMasaMuscular;
import models.Interfaces.adapters.IAdapterPeso;
import models.Interfaces.adapters.IAdapterPorcentajeGrasa;
import models.enums.Sexo;

import java.util.Calendar;
import java.util.List;

import adapter.AdapterBalanzaGimnasio;
import adapter.AdapterGrasaCorporal;
import adapter.AdapterMasaMuscular;

public class Medicion implements IObservable {

	@Override
	public String toString() {
		return "\n Medicion [peso=" + peso + ", masaMuscular=" + masaMuscular + ", porcentajeGrasaCorporal="
				+ porcentajeGrasaCorporal + ", fecha=" + fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH)
				+ "/" + fecha.get(Calendar.YEAR) + "]";
	}

	private IAdapterPeso adapterPeso;
	private IAdapterPorcentajeGrasa adapterGrasa;
	private IAdapterMasaMuscular adapterMasaMuscular;
	private Float peso;
	private Float masaMuscular;
	private Float porcentajeGrasaCorporal;
	private Calendar fecha;
	private List<IObserver> observers;

	public Medicion() {
		this.adapterPeso = new AdapterBalanzaGimnasio();
		this.adapterGrasa = new AdapterGrasaCorporal();
		this.adapterMasaMuscular = new AdapterMasaMuscular();
	}

	public float obtenerMedicion() {
		return this.adapterPeso.obtenerPeso();
	}

	public float obtenerGrasaCorporal(float imc, int edad, Sexo sexo ) {
		return this.adapterGrasa.obtenerPorcentajeGrasaCorporal(imc, edad, sexo);
	}

	public float obtenerMasaMuscular(float peso, float estatura) {
		return this.adapterMasaMuscular.obtenerMasaMuscular(peso, estatura);
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
