package models.Interfaces.adapters;

import models.enums.Sexo;

public interface IAdapterPorcentajeGrasa {
    Float obtenerPorcentajeGrasaCorporal(float imc, int edad, Sexo sexo);
}
