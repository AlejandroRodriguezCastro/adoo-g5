package models.Interfaces;

import models.Rutina;

public interface IObserverTrofeos {
	//TODO IObserverTrofeos
    void serNotificadoObjetivoAlcanzado();
    void serNotificadoRutinaTerminada(Rutina rutina);
    void serNotificadoPesajeConsecutivoMensual();
    
}
