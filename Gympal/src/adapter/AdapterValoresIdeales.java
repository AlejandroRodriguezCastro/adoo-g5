package adapter;

import models.Interfaces.adapters.IAdapterValoresIdeales;
import models.enums.Sexo;

public class AdapterValoresIdeales implements IAdapterValoresIdeales {

	@Override
	public float obtenerIMCIdealMin(int edad, Sexo sexo) {

		if (sexo == Sexo.FEMENINO) {
			if (edad >= 16 && edad <= 24)
				return 19;
			if (edad > 24 && edad <= 34)
				return 20;
			if (edad > 34 && edad <= 44)
				return 21;
			if (edad > 44 && edad <= 54)
				return 22;
			if (edad > 54 && edad <= 64)
				return 23;
			if (edad > 64 && edad <= 90)
				return 25;
		}

		if (sexo == Sexo.MASCULINO) {
			if (edad == 16)
				return 19;
			if (edad == 17)
				return 20;
			if (edad == 18)
				return 20;
			if (edad > 18 && edad <= 24)
				return 21;
			if (edad > 24 && edad <= 34)
				return 22;
			if (edad > 34 && edad <= 54)
				return 23;
			if (edad > 54 && edad <= 64)
				return 24;
			if (edad > 64 && edad <= 90)
				return 25;
		}
		
		return 0;
	}

	@Override
	public float obtenerIMCIdealMax(int edad, Sexo sexo) {
		
		if (sexo == Sexo.FEMENINO) {
			if (edad >= 16 && edad <= 24)
				return 24;
			if (edad > 24 && edad <= 34)
				return 25;
			if (edad > 34 && edad <= 44)
				return 26;
			if (edad > 44 && edad <= 54)
				return 27;
			if (edad > 54 && edad <= 64)
				return 28;
			if (edad > 64 && edad <= 90)
				return 30;
		}
		
		
		if (sexo == Sexo.MASCULINO) {
			if (edad == 16)
				return 24;
			if (edad == 17)
				return 25;
			if (edad == 18)
				return 25;
			if (edad > 18 && edad <= 24)
				return 26;
			if (edad > 24 && edad <= 34)
				return 27;
			if (edad > 34 && edad <= 54)
				return 38;
			if (edad > 54 && edad <= 64)
				return 29;
			if (edad > 64 && edad <= 90)
				return 30;
		}
		return 0;
	}

	@Override
	public float obtenerGrasaIdealMin(int edad, Sexo sexo) {
		if (sexo == Sexo.FEMENINO) {
			if (edad >= 15 && edad <= 20)
				return 18;
			if (edad > 20 && edad <= 25)
				return 21;
			if (edad > 25 && edad <= 30)
				return 22;
			if (edad > 30 && edad <= 35)
				return 24;
			if (edad > 35 && edad <= 45)
				return 25;
			if (edad > 45 && edad <= 50)
				return 28;
			if (edad > 50 && edad <= 60)
				return 29;
			if (edad > 60)
				return 29;
		}
		
		if (sexo == Sexo.MASCULINO) {
			if (edad >= 15 && edad <= 20)
				return 15;
			if (edad > 20 && edad <= 25)
				return 16;
			if (edad > 25 && edad <= 30)
				return 19;
			if (edad > 30 && edad <= 35)
				return 20;
			if (edad > 35 && edad <= 45)
				return 21;
			if (edad > 45 && edad <= 50)
				return 22;
			if (edad > 50 && edad <= 60)
				return 23;
			if (edad > 60)
				return 24;
		}
		return 0;
	}

	@Override
	public float obtenerGrasaIdealMax(int edad, Sexo sexo) {
		if (sexo == Sexo.FEMENINO) {
			if (edad >= 15 && edad <= 20)
				return 22;
			if (edad > 20 && edad <= 25)
				return 23;
			if (edad > 25 && edad <= 30)
				return 24;
			if (edad > 30 && edad <= 35)
				return 26;
			if (edad > 35 && edad <= 45)
				return 27;
			if (edad > 45 && edad <= 50)
				return 30;
			if (edad > 50 && edad <= 60)
				return 31;
			if (edad > 60)
				return 31;
		}
		
		if (sexo == Sexo.MASCULINO) {
			if (edad >= 15 && edad <= 20)
				return 18;
			if (edad > 20 && edad <= 25)
				return 20;
			if (edad > 25 && edad <= 30)
				return 21;
			if (edad > 30 && edad <= 35)
				return 21;
			if (edad > 35 && edad <= 45)
				return 23;
			if (edad > 45 && edad <= 50)
				return 23;
			if (edad > 50 && edad <= 60)
				return 24;
			if (edad > 60)
				return 25;
		}
		return 0;
	}

}
