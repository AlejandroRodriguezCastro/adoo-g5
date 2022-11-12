package controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import dataSets.DataSets;
import models.Medicion;
import models.Socio;
import valueObject.SocioDto;

public class SocioController extends DataSets {

	private static Socio socio;
	private static Medicion medicion;
	private static SocioDto socioDto;
	private static List<Medicion> mediciones;

	public SocioController() {
		super();
		this.socio = new Socio();
		mediciones = new ArrayList<>();
	}

	public SocioDto loguin(SocioDto s) {
		return this.socio.login(s.getNroSocio(), s.getPasswd());
	}

	public static void menuSocio(SocioDto s) {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		socioDto = new SocioDto();
		socioDto = s;
		for (Socio ss : usuarios) {
			if (ss.getNroSocio().equals(socioDto.getNroSocio()))
				socio = ss;
		}

		if(socio.getMediciones()!=null)
		mediciones = socio.getMediciones();

		do {
			System.out.println();
			System.out.println("********************* BIENVENIDO *********************");
			System.out.println("******************" + s.getNombre() + " " + s.getApellido() + "********************");
			System.out.println("******************************************************");
			System.out.println("1- DATOS PERSONALES");
			System.out.println("2- ELEGIR OBJETIVO");
			System.out.println("3- PESARME");
			System.out.println("4- COMENZAR ENTRENAMIENTO");
			System.out.println("5- REGISTRAR PESAJE");
			System.out.println("6- MIS TROFEOS");
			System.out.println("0- SALIR");

			System.out.println("******************************************************");
			System.out.println("******************************************************");
			System.out.println("******************************************************");

			System.out.println();
			System.out.println("ELIJA UNA OPCION:");

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println(s.toString());
				break;
			case 3:
				pesarSocio();
				//listar();
				break;
			}

		} while (opcion != 0);

	}

	private static void listar() {
		for (Socio s : usuarios) {
			System.out.println(s.toString());
		}

	}

	private static void pesarSocio() {
		medicion = new Medicion();
		medicion.setPeso(medicion.obtenerMedicion());
		Calendar c1 = Calendar.getInstance();
		System.out.println("Fecha: " + Calendar.DATE);
		medicion.setFecha(c1.getInstance());
		System.out.println("Tu peso es: " + medicion.getPeso());
		mediciones.add(medicion);
		socio.setMediciones(mediciones);
		guardarSocio(socio);
	}

	private static void guardarSocio(Socio s) {
		usuarios.remove(s);
		usuarios.add(s);
	}

}
