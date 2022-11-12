package adapter;

import java.util.Random;

import models.Interfaces.adapters.IAdapterPeso;

public class AdapterBalanzaGimnasio implements IAdapterPeso {

	@Override
	public float obtenerPeso() {
		Random rand = new Random();
	    return rand.nextFloat() * (100 - 60) + 60;
	}

}
