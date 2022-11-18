package models.objetivos;

import models.Rutina;
import models.Interfaces.IObservable;

public class ObjetivoMantenerFigura extends Objetivo{
    @Override
    public void serNotificadoPor(IObservable observable) {
        return;
    }

	@Override
	public Rutina CrearRutina() {
		return null;
		// TODO Auto-generated method stub
		
	}
}
