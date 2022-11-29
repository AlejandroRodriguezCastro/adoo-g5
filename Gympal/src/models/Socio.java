package models;

import adapter.LoginAdapter;
import controllers.EntrenamientoController;
import controllers.MedicionController;
import controllers.RutinaController;
import models.Interfaces.IObservable;
import models.Interfaces.IObserverTrofeos;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.enums.Sexo;
import models.objetivos.Objetivo;
import valueObject.EjercicioDto;
import valueObject.EntrenamientoDto;
import valueObject.MedicionDto;
import valueObject.SocioDto;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Socio implements IObservable{
	private static int Socios = 123456;
	private String nombre;
	private String apellido;
	private String nroSocio;
	private String documento;
	private Integer edad;
	private Sexo sexo;
	private Float altura;
	private List<Medicion> mediciones;
	private Objetivo objetivo;
	private List<Trofeo> trofeos;
	private IAdapterAutenticator autenticador;
	private Calendar fechaUltimaMedicion;
	private int medicionesMesActual;

	public Socio() {
		this.autenticador = new LoginAdapter();
	}

	public Socio(String nombre, String apellido, String nroSocio, String documento, Integer edad, Sexo sexo,
			Float altura) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroSocio = nroSocio;
		this.documento = documento;
		this.edad = edad;
		this.sexo = sexo;
		this.altura = altura;
		this.mediciones = new ArrayList<Medicion>();
		this.trofeos = new ArrayList<Trofeo>();
		this.medicionesMesActual = 0;
	}

	public Socio(String nombre, String apellido, String documento, Integer edad, Sexo sexo, Float altura) {
		Socios += 1;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroSocio = Integer.toString(Socios);
		this.documento = documento;
		this.edad = edad;
		this.sexo = sexo;
		this.altura = altura;
		this.mediciones = new ArrayList<Medicion>();
		this.trofeos = new ArrayList<Trofeo>();
		this.medicionesMesActual = 0;
	}

	public Socio(SocioDto socioDto) {
		Socios += 1;
		this.nombre = socioDto.getNombre();
		this.apellido = socioDto.getApellido();
		this.nroSocio = Integer.toString(Socios);
		this.documento = socioDto.getDocumento();
		this.edad = socioDto.getEdad();
		this.sexo = socioDto.getSexo();
		this.altura = socioDto.getAltura();
		this.mediciones = new ArrayList<>();
		this.trofeos = new ArrayList<Trofeo>();
	}

	public void setearObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public void setMediciones(List<Medicion> mediciones) {
		this.mediciones = mediciones;
		
	}

	public MedicionDto realizarMedicion() {

		SocioDto socioDto = new SocioDto();
		socioDto.setAltura(this.altura);
		socioDto.setEdad(this.edad);
		socioDto.setSexo(this.sexo);

		return MedicionController.realizarMedicion(socioDto);

		/*
		 * System.out.println( "Fecha: " + c1.get(Calendar.DATE) + "/" +
		 * c1.get(Calendar.MONTH) + "/" + c1.get(Calendar.YEAR));
		 * medicion.setFecha(Calendar.getInstance()); System.out.println("Tu peso es: "
		 * + medicion.getPeso()); mediciones.add(medicion);
		 * socio.setMediciones(mediciones); return null;
		 */
	}

	public void terminarEjercicio(int ejercicio) {

		for (Entrenamiento e : this.objetivo.getRutina().getEntrenamientos()) {

			if (e.getDia() == this.objetivo.getRutina().getDiasCompletados() + 1) {
				if (EntrenamientoController.terminarEjercicio(e, ejercicio) == 0) {
					this.objetivo.getRutina().diaCompletado();
					EntrenamientoController.terminarEntrenamiento(e);
					break;
				}

			}
		}

	}

	private float ultimoPeso() {
		if (this.mediciones.size() == 0) {
			return -1;
		} else
			return mediciones.get(mediciones.size() - 1).getPeso();
	}
	
	private float ultimoIMC() {
		if (this.mediciones.size() == 0) {
			return -1;
		} else
			return mediciones.get(mediciones.size() - 1).getMasaMuscular();
	}
	
	private float ultimoGrasa() {
		if (this.mediciones.size() == 0) {
			return -1;
		} else
			return mediciones.get(mediciones.size() - 1).getPorcentajeGrasaCorporal();
	}

	public EntrenamientoDto comenzarEntrenamiento() {
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		SocioDto socioDto = new SocioDto();
		socioDto.setAltura(this.altura);
		socioDto.setEdad(this.edad);
		socioDto.setSexo(this.sexo);
		socioDto.setGrasa(ultimoGrasa());
		socioDto.setIMC(ultimoIMC());
		if (this.objetivo.getRutina() == null) {

			if (ultimoPeso() != -1) {

				this.objetivo.setPesoInicial(ultimoPeso());

				if (RutinaController.crearRutina(this.objetivo, socioDto) != null) {

					this.objetivo.setRutina(RutinaController.crearRutina(this.objetivo, socioDto));
					//System.out.println(this.objetivo.getRutina().toString());
					this.objetivo.indicarObjetivo();

					for (Entrenamiento e : this.objetivo.getRutina().getEntrenamientos()) {

						if (e.getDia() == this.objetivo.getRutina().getDiasCompletados() + 1) {
							entrenamientoDto.setCantidadEjercicios(e.getCantidadEjercicios());
							entrenamientoDto.setEjerciciosCompletados(e.getEjerciciosCompletados());
							entrenamientoDto.setDia(e.getDia());
							entrenamientoDto.setEjercicios(e.getEjercicios());
							entrenamientoDto.setFechaAsignada(e.getFechaAsignada());
							entrenamientoDto.setFechaEjecucion(e.getFechaEjecucion());
							entrenamientoDto.setEjerciciosFinalizados(e.getEjerciciosFinalizados());
						}
						return entrenamientoDto;
					}
				} else
					return null;

			} else
				return null;
		} else {

			//System.out.println(this.objetivo.getRutina().toString());
			this.objetivo.indicarObjetivo();

			for (Entrenamiento e : this.objetivo.getRutina().getEntrenamientos()) {

				if (e.getDia() == this.objetivo.getRutina().getDiasCompletados() + 1) {
					entrenamientoDto.setCantidadEjercicios(e.getCantidadEjercicios());
					entrenamientoDto.setEjerciciosCompletados(e.getEjerciciosCompletados());
					entrenamientoDto.setDia(e.getDia());
					entrenamientoDto.setEjercicios(e.getEjercicios());
					entrenamientoDto.setFechaAsignada(e.getFechaAsignada());
					entrenamientoDto.setFechaEjecucion(e.getFechaEjecucion());
					entrenamientoDto.setEjerciciosFinalizados(e.getEjerciciosFinalizados());
				}

			}
			return entrenamientoDto;

		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNroSocio() {
		return nroSocio;
	}

	public String getDocumento() {
		return documento;
	}

	public Integer getEdad() {
		return edad;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Float getAltura() {
		return altura;
	}

	public List<Medicion> getMediciones() {
		return mediciones;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public List<Trofeo> getTrofeos() {
		return trofeos;
	}

	public IAdapterAutenticator getAutenticador() {
		return autenticador;
	}

	public void setNroSocio(String nroSocio) {
		this.nroSocio = nroSocio;
	}

	@Override
	public String toString() {
		return "\nSocio [nombre=" + nombre + ", apellido=" + apellido + ", nroSocio=" + nroSocio + ", documento="
				+ documento + ", edad=" + edad + ", sexo=" + sexo + ", altura=" + altura + ", \n mediciones="
				+ mediciones + "]";
	}

	public SocioDto getSocioDto() {
		SocioDto socio = new SocioDto(nombre, apellido, nroSocio, documento, edad, sexo, altura);
		return socio;
	}

	public void reforzarEjercicio(EjercicioDto ejercicioDto) {
		for (Entrenamiento e : this.objetivo.getRutina().getEntrenamientos()) {

			if (e.getDia() == this.objetivo.getRutina().getDiasCompletados() + 1) {
				EntrenamientoController.reforzarEjercicio(e.getEjercicios().get(ejercicioDto.getNroEjercicio()),
						ejercicioDto);
				break;
			}

		}
	}

	public void terminarEntrenamiento() {
		for (Entrenamiento e : this.objetivo.getRutina().getEntrenamientos()) {
			if (e.getDia() == this.objetivo.getRutina().getDiasCompletados() + 1) {
				this.objetivo.getRutina().diaCompletado();
				EntrenamientoController.terminarEntrenamiento(e);
				break;
			}

		}
		
		if(this.objetivo.getRutina().isCompletada()) { 
			//TODO notificar(rutina) verificar trofeo a la constancia.
			this.objetivo.setRutina(null); //rutina actual terminada, se generará una nueva cuando
											// desee comenzar su entrenamiento al día siguiente.
		}
		
	}

	@SuppressWarnings("static-access")
	public void addMedicion(Medicion nuevaMedicion) {
		//TODO hacer que esto ande para guardar medición.
		mediciones.add(nuevaMedicion);
		if(this.fechaUltimaMedicion != null) {
			if(nuevaMedicion.getFecha().MONTH == this.fechaUltimaMedicion.MONTH) {
				this.medicionesMesActual += 1;
				if(this.medicionesMesActual == 3) {
					notificar(); //TODO notificar 3 mediciones mensuales.
				}
			}else {
				this.medicionesMesActual = 0;
			}
		}
		this.fechaUltimaMedicion = nuevaMedicion.getFecha();
		
		if(objetivo.objetivoAlcanzado(getSocioDto())) {
			//TODO notificar trofeo a la dedicación.
		}
		
	}

	@Override
	public void agregar(IObserverTrofeos observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(IObserverTrofeos observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificar() {
		// TODO Auto-generated method stub
		
	}

}
