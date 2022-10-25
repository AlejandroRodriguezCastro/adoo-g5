package models;

import java.util.Calendar;

import adapter.AdapterBalanzaGimnasio;
import adapter.LoguinAdapter;

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
    
    public Medicion() {
		// TODO Auto-generated constructor stub
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
