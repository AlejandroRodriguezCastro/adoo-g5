package models.objetivos;

import models.Rutina;
import models.Interfaces.IObservable;

public class ObjetivoTonificarCuerpo extends Objetivo{
    @Override
    public void serNotificadoPor(IObservable observable) {
        return;
    }

	@Override
	public Rutina CrearRutina() {
		return null;
				
	}
}
