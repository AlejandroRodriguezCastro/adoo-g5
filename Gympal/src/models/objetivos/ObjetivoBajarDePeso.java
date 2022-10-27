package models.objetivos;

import models.Interfaces.IObservable;

public class ObjetivoBajarDePeso extends Objetivo{
    @Override
    public void serNotificadoPor(IObservable observable) {
        return;
    }
}
