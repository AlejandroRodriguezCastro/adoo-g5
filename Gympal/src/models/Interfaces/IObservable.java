package models.Interfaces;

public interface IObservable {

    void agregar(IObserverTrofeos observer);
    void eliminar(IObserverTrofeos observer);
    void notificar();

}
