package adapter;

import models.Interfaces.adapters.IAdapterMasaMuscular;

public class AdapterMasaMuscular implements IAdapterMasaMuscular{

	@Override
	public Float obtenerMasaMuscular(float peso, float estatura) {
		return (float) (peso/(Math.pow(estatura,2)));
	}

}
