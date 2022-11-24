package models.Interfaces.adapters;

import models.enums.Sexo;

public interface IAdapterPesoIdeal {
	
	float obtenerPesoIdealMin(float altura);
	
	float obtenerPesoIdealMax(float altura);
}
