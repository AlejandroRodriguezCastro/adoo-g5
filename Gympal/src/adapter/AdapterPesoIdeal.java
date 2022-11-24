package adapter;

import models.Interfaces.adapters.IAdapterPesoIdeal;

public class AdapterPesoIdeal implements IAdapterPesoIdeal {

	
	@Override
	public float obtenerPesoIdealMin(float altura) {
		float IMCmin = 18.5f;
		return (float) (IMCmin * (Math.pow(altura,2)));
	}
	
	@Override
	public float obtenerPesoIdealMax(float altura) {
		float IMCmin = 24.9f;
		return (float) (IMCmin * (Math.pow(altura,2)));
	}
	

}
