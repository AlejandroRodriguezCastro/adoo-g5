package models.Interfaces;

import models.Rutina;
import models.Socio;

public interface IObservable {

    void agregar(IObserverTrofeos observer);
    void eliminar(IObserverTrofeos observer);
    void notificarObjetivoAlcanzado(Socio socio);
    void notificarRutinaTerminada(Rutina rutina);
    void notificarPesajeConsecutivoMensual(Socio socio);

}
