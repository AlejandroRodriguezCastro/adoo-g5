package models.Interfaces.adapters;

import models.enums.Genero;

public interface IAdapterPorcentajeGrasa {
    Float obtenerPorcentajeGrasaCorporal(float imc, int edad, Genero genero);
}
