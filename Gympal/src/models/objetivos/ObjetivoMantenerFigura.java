package models.objetivos;

import models.Interfaces.IObservable;

public class ObjetivoMantenerFigura extends Objetivo{
    @Override
    public void serNotificadoPor(IObservable observable) {
        return;
    }
}
