package models.Interfaces;

public interface IObservable {

    void agregar(IObserver observer);
    void eliminar(IObserver observer);
    void notificar();

}
