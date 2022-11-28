package menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import controllers.SocioController;
import models.Ejercicio;
import models.Entrenamiento;
import models.enums.Sexo;
import models.objetivos.Objetivo;
import models.objetivos.ObjetivoBajarDePeso;
import models.objetivos.ObjetivoMantenerFigura;
import models.objetivos.ObjetivoTonificarCuerpo;
import valueObject.EjercicioDto;
import valueObject.EntrenamientoDto;
import valueObject.MedicionDto;
import valueObject.SocioDto;
import valueObject.TrofeoDTO;

public class Menu {
	static Scanner sc;

	public static void mainMenu() {
		sc = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("******************************************************");
			System.out.println("******************** GymPal APP **********************");
			System.out.println("******************************************************");

			opcion = menuOpciones(new String[] { "Ingresar", "Nuevo Usuario", "Salir" });
			switch (opcion) {
			case 1:
				menuLogin();
				break;
			case 2:
				menuNuevoSocio();
				break;
			default:
				System.out.println("Que tenga un buen día");
				break;
			}
		} while (opcion != 3);

	}

	public static void menuLogin() {
		boolean exit = false;
		SocioDto socioDto = new SocioDto();
		sc = new Scanner(System.in);
		do {

			System.out.println("\nIngrese su usuario:");
			socioDto.setNroSocio(sc.nextLine());

			System.out.println("Ingrese su contrasenia:");
			socioDto.setPasswd(sc.nextLine());

			if (!SocioController.login(socioDto)) {
				System.out.println("Nro de socio o contraseÃ±a incorrecta");
				System.out.println("presione 0 para salir o cualquier otra tecla para reintentar:");
				exit = sc.nextLine().equals("0");
			}
		} while (!SocioController.login(socioDto) && !exit);

		if (!exit) {
			menuSocio(socioDto);
		}
	}

	public static void menuNuevoSocio() {
		boolean exit = false;
		SocioDto socioDto = new SocioDto();
		sc = new Scanner(System.in);
		do {
			System.out.println("Nombre:");
			socioDto.setNombre(sc.nextLine());

			System.out.println("Apellido:");
			socioDto.setApellido(sc.nextLine());

			System.out.println("Nro Documento:");
			socioDto.setDocumento(sc.nextLine());

			System.out.println("Edad:");
			socioDto.setEdad(sc.nextInt());

			System.out.println("Seleccione Sexo:");
			socioDto.setSexo(Sexo.fromInteger(menuOpciones(new String[] { "Másculino", "Femenino" }) - 1));

			System.out.println("Altura (metros):");
			socioDto.setAltura(sc.nextFloat());
			sc.nextLine();
			System.out.println("Contraseña:");
			socioDto.setPasswd(sc.nextLine());

			System.out.println("ConfirmarDatos: ");
			menuVerDatos(socioDto);
			System.out.println("Contraseña: " + socioDto.getPasswd());
			System.out.println("presione 0 para confirmar o cualquier otra tecla para reintentar:");
			exit = sc.nextLine().equals("0");

		} while (!exit);

		if (!SocioController.exists(socioDto)) {
			socioDto.setNroSocio(SocioController.nuevoSocio(socioDto));
			System.out.println("Usuario registrado con éxito." + "\nUsuario: " + socioDto.getNroSocio());
		} else {
			System.out.println("Ya existe un usuario asociado a este documento. "
					+ "\nConsulte en recepción si ha olvidado su usuario/contraseña");
		}

	}

	public static void menuVerDatos(SocioDto socioDto) {
		System.out.println("\nNombre: " + socioDto.getNombre() + " " + socioDto.getApellido() + "\nNroDocumento: "
				+ socioDto.getDocumento() + "\nEdad: " + socioDto.getEdad() + "\nAltura " + socioDto.getAltura());
	}

	public static void menuSocio(SocioDto socioDto) {

		if (!socioDto.getTieneObjetivo()) {
			menuSetearObjetivo(socioDto);
		}

		int opcion = 0;
		sc = new Scanner(System.in);
		do {
			System.out.println();
			System.out.println("********************* BIENVENIDO *********************");
			System.out.println("****************** " + socioDto.getNombre() + " " + socioDto.getApellido()
					+ " ********************");
			System.out.println("******************************************************");
			opcion = menuOpciones(new String[] { "Datos Personales", "Cambiar Objetivo", "Pesarme",
					"Comenzar Entrenamiento", "Registro de entrenamientos", "Mis Trofeos", "Salir" });
			switch (opcion) {
			case 1: //Datos personales
				SocioController.listar();
				break;
			case 2: //Cambiar Objetivo
				menuSetearObjetivo(socioDto);
				break;
			case 3: //Pesarme
				subMenuPesarme();
				// SocioController.listar();
				break;
			case 4: //Comenzar Entrenamiento
				subMenuEjercicios(socioDto);
				break;
			case 5: //Registro de entrenamientos
				subMenuHistorialEntrenamientos();
				break;
				
			case 6: //Trofeos
				subMenuTrofeos();
				break;

			}

		} while (opcion != 7);

	}
	
	private static void subMenuTrofeos() {
		List<TrofeoDTO> trofeos = new ArrayList<>();
		trofeos = SocioController.registroTrofeos();
		if (trofeos != null) {
			for (TrofeoDTO trofeo : trofeos) {
				System.out.println("***************************************************************");
				System.out.println("Trofeo: " + trofeo.getNombre());
				System.out.println("Descripción: " + trofeo.getDescripcion());
				System.out.println("Fecha otorgado: " + trofeo.getFecha());
				System.out.println("***************************************************************");
				}
		}else {
			System.out.println("\n**A ponerle ganas para ganar trofeos!**");
		}
		
	}

	private static void subMenuHistorialEntrenamientos() {
		List<EntrenamientoDto> entrenamientos = new ArrayList<>();
		entrenamientos = SocioController.registroEntrenamiento();

		if (entrenamientos != null) {

			for (EntrenamientoDto entrenamientoDto : entrenamientos) {

				System.out.println("***************************************************************");
				System.out.println("Dia de entrenamiento:" + entrenamientoDto.getDia());
				System.out.println("Cantidad de ejercicios:" + entrenamientoDto.getCantidadEjercicios());
				System.out.println("Completados:" + entrenamientoDto.getEjerciciosCompletados());
				System.out.println(
						"Fecha de entrenamiento:" + entrenamientoDto.getFechaAsignada().get(Calendar.DATE) + "/"
								+ entrenamientoDto.getFechaAsignada().get(Calendar.MONTH) + "/"
								+ entrenamientoDto.getFechaAsignada().get(Calendar.YEAR));
				System.out
						.println("Fecha de ejecucion:" + entrenamientoDto.getFechaEjecucion().get(Calendar.DATE)
								+ "/" + entrenamientoDto.getFechaEjecucion().get(Calendar.MONTH) + "/"
								+ entrenamientoDto.getFechaEjecucion().get(Calendar.YEAR));
				System.out.println("***************************************************************");
				System.out.println("\n*************************EJERCICIOS:***************************");
				for (Entry<Integer, Ejercicio> entry : entrenamientoDto.getEjercicios().entrySet()) {

					System.out.println("\nEjercicio: " + entry.getKey());
					System.out.println(entry.getValue().toString());

				}
				System.out.println("\n***************************************************************");
			}
		} else 
			
			System.out.println("\n**No tienes entrenamientos comenzados**");

	}
	public static void subMenuEjercicios(SocioDto socioDto) {
		EntrenamientoDto entrenamientoDto = new EntrenamientoDto();
		entrenamientoDto = SocioController.comenzarEntrenamiento();

		if (entrenamientoDto != null) {

			System.out.println("***************************************************************");
			System.out.println("Dia de entrenamiento:" + entrenamientoDto.getDia());
			System.out.println("Cantidad de ejercicios:" + entrenamientoDto.getCantidadEjercicios());
			System.out.println("Completados:" + entrenamientoDto.getEjerciciosCompletados());
			System.out.println("Fecha de entrenamiento:" + entrenamientoDto.getFechaAsignada().get(Calendar.DATE) + "/"
					+ entrenamientoDto.getFechaAsignada().get(Calendar.MONTH) + "/"
					+ entrenamientoDto.getFechaAsignada().get(Calendar.YEAR));
			System.out.println("Fecha de ejecucion:" + entrenamientoDto.getFechaEjecucion().get(Calendar.DATE) + "/"
					+ entrenamientoDto.getFechaEjecucion().get(Calendar.MONTH) + "/"
					+ entrenamientoDto.getFechaEjecucion().get(Calendar.YEAR));
			System.out.println("***************************************************************");
			System.out.println("\n*************************EJERCICIOS:***************************");
			for (Entry<Integer, Ejercicio> entry : entrenamientoDto.getEjercicios().entrySet()) {

				boolean mostrar = true;

				for (Integer i : entrenamientoDto.getEjerciciosFinalizados()) {
					if (i == entry.getKey())
						mostrar = false;
				}

				if (mostrar) {
					System.out.println("\nEjercicio: " + entry.getKey());
					System.out.println(entry.getValue().toString());
				}

			}
			System.out.println("\n***************************************************************");
			// SocioController.listar();

			subMenuEjercicio(socioDto);

		} else
			System.out.println(
					"\n**No tienes pesajes registrados, o tus valores biometricos no aplican para este objetivo**");

	}

	public static void subMenuPesarme() {
		int opcion = 0;
		sc = new Scanner(System.in);
		MedicionDto medicionDto = new MedicionDto();
		Calendar c1 = Calendar.getInstance();

		System.out.println();
		System.out.println("******************************************************");
		System.out.println("************** PESARME ****************");
		System.out.println("******************************************************");
		opcion = menuOpciones(new String[] { "Balanza", "Ingreso manual" });

		switch (opcion) {
		case 1:
			SocioController.pesarSocio();
			SocioController.listar();
			break;
		case 2:
			System.out.println("Peso:");
			medicionDto.setPeso(sc.nextFloat());

			System.out.println("IMC:");
			medicionDto.setMasaMuscular(sc.nextFloat());

			System.out.println("Grasa corporal:");
			medicionDto.setPorcentajeGrasaCorporal(sc.nextFloat());

			medicionDto.setFecha(c1);

			SocioController.registrarPesaje(medicionDto);

			System.out.println("Pesaje Registrado");

			SocioController.listar();

			break;
		}
	}

	public static void subMenuEjercicio(SocioDto socioDto) {
		int opcion = 0;
		sc = new Scanner(System.in);

		System.out.println();
		System.out.println("******************************************************");
		System.out.println("************** ELIGE LA OPCION ****************");
		System.out.println("******************************************************");
		opcion = menuOpciones(new String[] { "Reforzar ejercicio", "Terminar ejercicio", "Terminar entrenamiento","Salir" });
		int ejercicio, series, repeticiones;
		float pesoAsignado;

		switch (opcion) {
		case 1:
			EjercicioDto ejercicioDto = new EjercicioDto();
			System.out.print("Elige el ejercicio a modificar: ");
			ejercicio = sc.nextInt();
			System.out.print("Indique series: ");
			series = sc.nextInt();
			System.out.print("Indique repeticiones: ");
			repeticiones = sc.nextInt();
			System.out.print("Indique peso: ");
			pesoAsignado = sc.nextFloat();
			ejercicioDto.setNroEjercicio(ejercicio);
			ejercicioDto.setSeries(series);
			ejercicioDto.setRepeticiones(repeticiones);
			ejercicioDto.setPesoAsignado(pesoAsignado);
			SocioController.reforzarEjercicio(ejercicioDto);
			System.out.println("Ejercicio modificado");
			subMenuEjercicios(socioDto);
			break;
		case 2:
			System.out.print("Elige el ejercicio a terminar: ");

			ejercicio = sc.nextInt();
			SocioController.terminarEjercicio(ejercicio);
			subMenuEjercicios(socioDto);
			break;
		case 3:
			SocioController.terminarEntrenamiento();
			subMenuEjercicios(socioDto);
			break;
		case 4:
			menuSocio(socioDto);
			break;
		}
	}

	public static void menuSetearObjetivo(SocioDto socioDto) {
		int opcion = 0;
		sc = new Scanner(System.in);

		System.out.println("******************************************************");
		System.out.println("************** SELECCION DE OBJETIVOS ****************");
		System.out.println("******************************************************");
		opcion = menuOpciones(new String[] { "Bajar de Peso", "Mantener Figura", "Tonificar Cuerpo" });

		Objetivo objetivo = null;
		switch (opcion) {
		case 1:
			objetivo = new ObjetivoBajarDePeso();
			socioDto.setTieneObjetivo(true);
			break;
		case 2:
			objetivo = new ObjetivoMantenerFigura();
			socioDto.setTieneObjetivo(true);
			break;
		case 3:
			objetivo = new ObjetivoTonificarCuerpo();
			socioDto.setTieneObjetivo(true);
			break;
		}
		SocioController.setearObjetivo(objetivo);
	}

	public static int menuOpciones(String[] opciones) {
		/*
		 * Imprime las opciones pasadas por parametro Retorna el número de opción
		 * elegida
		 */
		sc = new Scanner(System.in);
		int opcion = -1;
		do {
			System.out.println("Ingrese una de las siguientes opciones:");
			for (int i = 0; i < opciones.length; i++) {
				System.out.println((i + 1) + ". " + opciones[i]);
			}
			System.out.print("Opción: ");
			opcion = sc.nextInt();
			if (opcion <= 0 || opcion > opciones.length) {
				System.out.println("Opción inválida");
			}
		} while (opcion <= 0 || opcion > opciones.length);
		return opcion;

	}

}
