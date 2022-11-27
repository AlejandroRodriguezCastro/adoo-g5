package controllers;

import java.util.List;

import adapter.LoginAdapter;
import dataSets.DataSets;
import models.Interfaces.adapters.IAdapterAutenticator;
import models.Medicion;
import models.Socio;
import models.objetivos.Objetivo;
import valueObject.EjercicioDto;
import valueObject.EntrenamientoDto;
import valueObject.MedicionDto;
import valueObject.SocioDto;

public class SocioController {

    private static final DataSets dataSets = DataSets.getDataSet();
    private static Socio socio = new Socio();
    private static final IAdapterAutenticator autenticador = new LoginAdapter();

    public static boolean login(SocioDto socioDto) {
        if (autenticador.login(socioDto.getNroSocio(), socioDto.getPasswd())) {
            socio = dataSets.getSocioByNroSocio(socioDto.getNroSocio());
            socioDto.setNombre(socio.getNombre());
            socioDto.setApellido(socio.getApellido());
            socioDto.setTieneObjetivo(socio.getObjetivo() != null);
            socioDto.setObjetivo(socio.getObjetivo());
            return true;
        }
        return false;
    }

    public static boolean exists(SocioDto socioDto) {
        return dataSets.getSocioByDocumento(socioDto.getDocumento()) != null;
    }

    public static void listar() {
        System.out.println(socio);
    }

    public static void pesarSocio() {
        List<Medicion> mediciones = socio.getMediciones();
        mediciones.add(MedicionController.nuevaMedicion(socio.realizarMedicion()));
        socio.setMediciones(mediciones);
        dataSets.guardarSocio(socio);
    }

    public static void registrarPesaje(MedicionDto medicionDto) {
        List<Medicion> mediciones = socio.getMediciones();
        mediciones.add(MedicionController.nuevaMedicion(medicionDto));
        socio.setMediciones(mediciones);
        dataSets.guardarSocio(socio);
    }

    public static void setearObjetivo(Objetivo objetivo) {
        socio.setearObjetvo(objetivo);
    }

    public static EntrenamientoDto comenzarEntrenamiento() {
        EntrenamientoDto entrenamientoDto = socio.comenzarEntrenamiento();
        if (entrenamientoDto != null) {
            dataSets.guardarSocio(socio);
            return entrenamientoDto;
        } else
            return null;
    }

    public static String nuevoSocio(SocioDto socioDto) {
        socio = new Socio(socioDto);
        dataSets.guardarSocio(socio);
        autenticador.register(socio.getNroSocio(), socioDto.getPasswd());
        return socio.getNroSocio();
    }

    public static void terminarEjercicio(int ejercicio) {
        socio.terminarEjercicio(ejercicio);
        dataSets.guardarSocio(socio);
    }

    public static void reforzarEjercicio(EjercicioDto ejercicioDto) {
        socio.reforzarEjercicio(ejercicioDto);
        dataSets.guardarSocio(socio);

    }

    public static void terminarEntrenamiento() {
        socio.terminarEntrenamiento();
        dataSets.guardarSocio(socio);
    }

    public static List<EntrenamientoDto> registroEntrenamiento() {
       return socio.getObjetivo().getRutina() != null ? EntrenamientoController.registroEntrenamiento(socio.getObjetivo().getRutina()) : null;
    }

}
