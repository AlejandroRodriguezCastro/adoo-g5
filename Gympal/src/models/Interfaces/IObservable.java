package models.Interfaces;

import models.Rutina;

public interface IObservable {

    void agregar(IObserverTrofeos observer);
    void eliminar(IObserverTrofeos observer);
    void notificarObjetivoAlcanzado();
    void notificarRutinaTerminada(Rutina rutina);
    void notificarPesajeConsecutivoMensual();

}
