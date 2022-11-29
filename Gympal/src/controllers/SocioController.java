package controllers;

import java.util.ArrayList;
import java.util.List;
import adapter.LoginAdapter;
import dataSets.DataSets;
import models.Interfaces.IObservable;
import models.Interfaces.IObserverTrofeos;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.FactoryTrofeos;
import models.Medicion;
import models.Rutina;
import models.Socio;
import models.Trofeo;
import models.objetivos.Objetivo;
import models.objetivos.ObjetivoBajarDePeso;
import models.objetivos.ObjetivoMantenerFigura;
import models.objetivos.ObjetivoTonificarCuerpo;
import valueObject.EjercicioDto;
import valueObject.EntrenamientoDto;
import valueObject.MedicionDto;
import valueObject.SocioDto;
import valueObject.TrofeoDTO;

public class SocioController implements IObservable{

	private static final DataSets dataSets = DataSets.getDataSet();
	private Socio socio;
	private static final IAdapterAutenticator autenticador = new LoginAdapter();
	private List<IObserverTrofeos> observadores = new ArrayList<IObserverTrofeos>();
	private static SocioController controlador = null;
	
	private SocioController() {
		observadores.add(FactoryTrofeos.getFactoryTrofeos());
	}
	
	public static SocioController getSocioController() {
		if(controlador == null) {
			controlador = new SocioController();
		}
		return controlador;
	}
	
	public boolean login(SocioDto socioDto) {
		if (autenticador.login(socioDto.getNroSocio(), socioDto.getPasswd())) {
			socio = dataSets.getSocioByNroSocio(socioDto.getNroSocio());
			socioDto.setNombre(socio.getNombre());
			socioDto.setApellido(socio.getApellido());
			socioDto.setTieneObjetivo(socio.getObjetivo() != null);
			socioDto.setObjetivo(socio.getObjetivo());
			return true;
		}
		return false;
	}

	public boolean exists(SocioDto socioDto) {
		if (dataSets.getSocioByDocumento(socioDto.getDocumento()) != null) {
			return true;
		}
		return false;
	}

	public String listar() {
		return socio.toString();
	}

	public void pesarSocio() {
		//medicion sistema
		List<Medicion> mediciones = new ArrayList<>();
		mediciones = socio.getMediciones();
		Medicion medicion = MedicionController.nuevaMedicion(socio.realizarMedicion());
		mediciones.add(medicion);
		socio.setMediciones(mediciones);
		socio.contarMedicion(medicion);
		if(socio.getMedicionesMesActual() == 3) {
			notificarPesajeConsecutivoMensual();
		}
		if(socio.getObjetivo().objetivoAlcanzado(socio.getSocioDto())) {
			notificarObjetivoAlcanzado();
		}
		
		dataSets.guardarSocio(socio);
	}

	public void registrarPesaje(MedicionDto medicionDto) {
		//medición manual
		List<Medicion> mediciones = new ArrayList<>();
		mediciones = socio.getMediciones();
		Medicion medicion = MedicionController.nuevaMedicion(medicionDto);
		mediciones.add(medicion);
		socio.setMediciones(mediciones);
		socio.contarMedicion(medicion);
		if(socio.getMedicionesMesActual() == 3) {
			notificarPesajeConsecutivoMensual();
		}
		if(socio.getObjetivo().objetivoAlcanzado(socio.getSocioDto())) {
			notificarObjetivoAlcanzado();
		}
		dataSets.guardarSocio(socio);
	}

	public void setearObjetivo(int objetivo) {
		switch (objetivo) {
		case 1:
			socio.setearObjetivo(new ObjetivoBajarDePeso());
			break;
		case 2:
			socio.setearObjetivo(new ObjetivoMantenerFigura());
			break;
		case 3:
			socio.setearObjetivo(new ObjetivoTonificarCuerpo());
			break;
		}
	}

	public EntrenamientoDto comenzarEntrenamiento() {
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		entrenamientoDto = socio.comenzarEntrenamiento();
		if (entrenamientoDto != null) {
			dataSets.guardarSocio(socio);
			return entrenamientoDto;
		} else
			return null;
	}

	public String nuevoSocio(SocioDto socioDto) {
		socio = new Socio(socioDto);
		dataSets.guardarSocio(socio);
		autenticador.register(socio.getNroSocio(), socioDto.getPasswd());
		return socio.getNroSocio();
	}

	public void terminarEjercicio(int ejercicio) {
		socio.terminarEjercicio(ejercicio);
		dataSets.guardarSocio(socio);
	}

	public void reforzarEjercicio(EjercicioDto ejercicioDto) {
		socio.reforzarEjercicio(ejercicioDto);
		dataSets.guardarSocio(socio);

	}
	
	public void terminarEntrenamiento() {
		socio.terminarEntrenamiento();
		Objetivo objetivo = socio.getObjetivo();
		if(objetivo.getRutina().isCompletada()) { 
			notificarRutinaTerminada(objetivo.getRutina());
			socio.getObjetivo().setRutina(null); 
		}
		dataSets.guardarSocio(socio);
	}

	public List<EntrenamientoDto> registroEntrenamiento() {
		SocioDto socioDto = new SocioDto();
		socioDto.setObjetivo(socio.getObjetivo());

		if (socioDto.getObjetivo().getRutina() != null)
			return EntrenamientoController.registroEntrenamiento(socioDto);
		else
			return null;
	}

	public List<TrofeoDTO> registroTrofeos() {
		SocioDto socioDto = new SocioDto();
		socioDto.setTrofeos(socio.getTrofeos());
		return socioDto.getTrofeos();
	}

	@Override
	public void agregar(IObserverTrofeos observer) {
		observadores.add(observer);
	}

	@Override
	public void eliminar(IObserverTrofeos observer) {
		observadores.remove(observer);		
	}

	@Override
	public void notificarObjetivoAlcanzado() {
		for (IObserverTrofeos observador : observadores) {
			observador.serNotificadoObjetivoAlcanzado();;
		}
	}

	@Override
	public void notificarRutinaTerminada(Rutina rutina) {
		for (IObserverTrofeos observador : observadores) {
			observador.serNotificadoRutinaTerminada(rutina);
		}
	}

	@Override
	public void notificarPesajeConsecutivoMensual() {
		System.out.println("observadores: " + observadores.size());
		for (IObserverTrofeos observador : observadores) {
			observador.serNotificadoPesajeConsecutivoMensual();
		}
		
	}

	public void otorgarTrofeo(Trofeo trofeo) {
		socio.agregarTrofeo(trofeo);		
	}



}
