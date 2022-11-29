package models.Interfaces;

import models.Rutina;
import models.Socio;

public interface IObserverTrofeos {
	//TODO IObserverTrofeos
    void serNotificadoObjetivoAlcanzado(Socio socio);
    void serNotificadoRutinaTerminada(Rutina rutina);
    void serNotificadoPesajeConsecutivoMensual(Socio socio);
    
}
