package adapter;

import models.Interfaces.adapters.IAdapterPorcentajeGrasa;
import models.enums.Sexo;

public class AdapterGrasaCorporal implements IAdapterPorcentajeGrasa{

	@Override
	public Float obtenerPorcentajeGrasaCorporal(float imc, int edad, Sexo sexo) {
		if(sexo == Sexo.MASCULINO) {
			return (float) ((1.20 * imc) + (0.23 * edad) + (10.8) - 5.4);
		}else {
			return (float) ((1.20 * imc) + (0.23 * edad) + (10.8 * 2) - 5.4);
		}
	}

}
