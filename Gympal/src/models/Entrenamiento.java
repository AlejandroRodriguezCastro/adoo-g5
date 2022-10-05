package models;

import java.util.List;

public class Entrenamiento {
    private List<Ejercicio> Ejercicios;

    public Entrenamiento(List<Ejercicio> ejercicios) {
        Ejercicios = ejercicios;
    }

    public List<Ejercicio> getEjercicios() {
        return Ejercicios;
    }
}
