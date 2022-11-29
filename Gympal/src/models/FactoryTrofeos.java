package models;

import java.util.Calendar;

import controllers.SocioController;
import models.Interfaces.IObserverTrofeos;

public class FactoryTrofeos implements IObserverTrofeos{
	
	static FactoryTrofeos factoryTrofeos = null;
	
	private FactoryTrofeos() {
		
	}

	public static IObserverTrofeos getFactoryTrofeos() {
		if(factoryTrofeos == null) {
			factoryTrofeos = new FactoryTrofeos();
		}
		return factoryTrofeos;
	}

	@Override
	public void serNotificadoObjetivoAlcanzado(Socio socio) {
		if(socio.getObjetivo().objetivoAlcanzado(socio.getSocioDto())) {
			Trofeo trofeo = new Trofeo("Trofeo a la Dedicaci�n",
					"Se otorga este trofeo a aquellos socios que cumplen con su objetivo",
					Calendar.getInstance()
					);
			socio.agregarTrofeo(trofeo);
		}
	}

	@Override
	public void serNotificadoRutinaTerminada(Rutina rutina) {
		if(rutina.entrenamientosCompletos()) {
			Trofeo trofeo = new Trofeo("Trofeo a la Constancia",
					"Se otorga este trofeo a aquellos socios que cumplen a la perfecci�n con las rutinas.",
					Calendar.getInstance()
					);
			SocioController.getSocioController().otorgarTrofeo(trofeo);
		}
	}

	@Override
	public void serNotificadoPesajeConsecutivoMensual(Socio socio) {
		if(socio.getMedicionesMesActual() == 3) {
			Trofeo trofeo = new Trofeo("Trofeo al cre�do",
					"Se otorga este trofeo a quien se pese m�s de 3 veces al mes",
					Calendar.getInstance()
					);
			socio.agregarTrofeo(trofeo);
		}
		
	}
	
}
