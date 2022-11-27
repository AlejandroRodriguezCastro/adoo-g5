package models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import valueObject.EntrenamientoDto;

public class Entrenamiento {

    private Map<Integer, Ejercicio> ejercicios = new HashMap<>();
    private int dia;
    private List<Integer> ejerciciosFinalizados = new ArrayList<>();
    private Calendar fechaAsignada;
    private Calendar fechaEjecucion;

    public Entrenamiento(Map<Integer, Ejercicio> ejercicios) {
        super();
        this.ejercicios = ejercicios;
    }

    public Entrenamiento() {
        // TODO Auto-generated constructor stub
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Calendar getFechaAsignada() {
        return fechaAsignada;
    }

    public void setFechaAsignada(Calendar fechaAsignada) {
        this.fechaAsignada = fechaAsignada;
    }

    public Calendar getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Calendar fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    @Override
    public String toString() {
        return "\nEntrenamiento [dia=" + dia + ", cantidadEjercicios=" + ejercicios.size() + ", ejerciciosCompletados="
                + ejerciciosFinalizados.size() + " fechaAsignada=" + fechaAsignada.get(Calendar.DATE) + "/"
                + fechaAsignada.get(Calendar.MONTH) + "/" + fechaAsignada.get(Calendar.YEAR) + ", fechaEjecucion="
                + fechaEjecucion.get(Calendar.DATE) + "/" + fechaEjecucion.get(Calendar.MONTH) + "/"
                + fechaEjecucion.get(Calendar.YEAR) + "\nEjercicios=" + ejercicios + "]";
    }

    public int getEjerciciosCompletados() {
        return ejerciciosFinalizados.size();
    }

    public int getCantidadEjercicios() {
        return ejercicios.size();
    }

    public Map<Integer, Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(Map<Integer, Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public List<Integer> getEjerciciosFinalizados() {
        return ejerciciosFinalizados;
    }

    public int terminarEjercicio(int ejercicio) {
        this.ejerciciosFinalizados.add(ejercicio);
        return ejercicios.size() - ejerciciosFinalizados.size();
    }

    public void terminarEntrenamiento() {
        this.fechaEjecucion = Calendar.getInstance();
    }

    public List<EntrenamientoDto> registroEntrenamiento(Rutina rutina) {

        List<EntrenamientoDto> ListEntrenamientos = new ArrayList<>();
        boolean tieneEjerciciosFinalizados = false;

        System.out.println(rutina.toString());

        for (Entrenamiento entrenamientos : rutina.getEntrenamientos()) {

            boolean guardar = false;

            Map<Integer, Ejercicio> ejercicios = new HashMap<>();

            for (Integer ejercicioFinalizado : entrenamientos.getEjerciciosFinalizados()) {

                if (entrenamientos.getEjercicios().containsKey(ejercicioFinalizado)) {
                    ejercicios.put(ejercicioFinalizado, entrenamientos.getEjercicios().get(ejercicioFinalizado));
                    tieneEjerciciosFinalizados = true;
                    guardar = true;
                }
            }

            EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
            entrenamientoDto.setDia(entrenamientos.getDia());
            entrenamientoDto.setCantidadEjercicios(entrenamientos.getCantidadEjercicios());
            entrenamientoDto.setEjerciciosCompletados(entrenamientos.getEjerciciosCompletados());
            entrenamientoDto.setFechaAsignada(entrenamientos.getFechaAsignada());
            entrenamientoDto.setFechaEjecucion(entrenamientos.getFechaEjecucion());
            entrenamientoDto.setEjercicios(ejercicios);
            if (guardar)
                ListEntrenamientos.add(entrenamientoDto);

        }
        if (tieneEjerciciosFinalizados)
            return ListEntrenamientos;
        else
            return null;
    }

}
