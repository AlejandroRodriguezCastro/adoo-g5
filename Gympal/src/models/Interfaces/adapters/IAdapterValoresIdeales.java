package models.Interfaces.adapters;

import models.enums.Sexo;

public interface IAdapterValoresIdeales {

	float obtenerIMCIdealMin(int edad, Sexo sexo);
	
	float obtenerIMCIdealMax(int edad, Sexo sexo);
	
	float obtenerGrasaIdealMin(int edad, Sexo sexo);
	
	float obtenerGrasaIdealMax(int edad, Sexo sexo);
	
}
