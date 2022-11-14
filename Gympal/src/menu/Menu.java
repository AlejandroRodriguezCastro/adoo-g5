package menu;

import java.util.Scanner;
import controllers.SocioController;
import models.enums.Sexo;
import models.objetivos.Objetivo;
import models.objetivos.ObjetivoBajarDePeso;
import models.objetivos.ObjetivoMantenerFigura;
import models.objetivos.ObjetivoTonificarCuerpo;
import valueObject.SocioDto;

public class Menu {
	static Scanner sc;
    public static void mainMenu() {
        sc = new Scanner(System.in);
        int opcion = 0;
        do {
        System.out.println("******************************************************");
        System.out.println("******************** GymPal APP **********************");
        System.out.println("******************************************************");
        
        opcion = menuOpciones(new String[]{"Ingresar","Nuevo Usuario","Salir"});
        switch (opcion){
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
        }while(opcion != 3);
        
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

        if(!exit){
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
	        socioDto.setSexo(Sexo.fromInteger(menuOpciones(new String[] {"Másculino","Femenino"})-1));
	        
	        System.out.println("Altura (metros):");
	        socioDto.setAltura(sc.nextFloat());
	        sc.nextLine();
	        System.out.println("Contraseña:");
	        socioDto.setPasswd(sc.nextLine());
	        
	        System.out.println("ConfirmarDatos: ");
            menuVerDatos(socioDto);
            System.out.println("Contraseña: "+socioDto.getPasswd());
            System.out.println("presione 0 para confirmar o cualquier otra tecla para reintentar:");
            exit = sc.nextLine().equals("0");
	        
    	}while(!exit);
    	
    	if(!SocioController.exists(socioDto)) {
    		socioDto.setNroSocio(SocioController.nuevoSocio(socioDto));
    		System.out.println("Usuario registrado con éxito."
    				+ "\nUsuario: "+socioDto.getNroSocio());
    	}else {
    		System.out.println("Ya existe un usuario asociado a este documento. "
    				+ "\nConsulte en recepción si ha olvidado su usuario/contraseña");
    	}
        
    }
    
    public static void menuVerDatos(SocioDto socioDto) {
    	System.out.println("\nNombre: "+ socioDto.getNombre() + " " + socioDto.getApellido()
    						+ "\nNroDocumento: "+socioDto.getDocumento()
    						+ "\nEdad: "+socioDto.getEdad()
    						+ "\nAltura "+socioDto.getAltura());
    }

    public static void menuSocio(SocioDto socioDto) {

        if (!socioDto.getTieneObjetivo()){
            menuSetearObjetivo(socioDto);
        }

        int opcion = 0;
        sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("********************* BIENVENIDO *********************");
            System.out.println("****************** " + socioDto.getNombre() + " " + socioDto.getApellido() + " ********************");
            System.out.println("******************************************************");
            opcion = menuOpciones(new String[] {"Datos Personales",
            									"Cambiar Objetivo",
            									"Pesarme",
            									"Comenzar Entrenamiento",
            									"Registrar Pesaje",
            									"Mis Trofeos",
            									"Salir"});
            switch (opcion) {
                case 1:
                    SocioController.listar();
                    break;
                case 3:
                    SocioController.pesarSocio();
                    SocioController.listar();
                    break;
            }

        } while (opcion != 7);

    }

    public static void menuSetearObjetivo(SocioDto socioDto) {
        int opcion = 0;
        sc = new Scanner(System.in);

        System.out.println("******************************************************");
        System.out.println("************** SELECCION DE OBJETIVOS ****************");
        System.out.println("******************************************************");
        opcion = menuOpciones(new String[] {"Bajar de Peso","Mantener Figura","Tonificar Cuerpo"});

        Objetivo objetivo = null;
        switch (opcion) {
            case 1:
                objetivo = new ObjetivoBajarDePeso();
                break;
            case 2:
                objetivo = new ObjetivoMantenerFigura();
                break;
            case 3:
                objetivo = new ObjetivoTonificarCuerpo();
                break;
        }
        SocioController.setearObjetivo(objetivo);
    }
    
    public static int menuOpciones(String[] opciones) {
    	/*Imprime las opciones pasadas por parametro
    	 *Retorna el número de opción elegida
    	 * */
    	sc = new Scanner(System.in);
    	int opcion = -1;
    	do {
    		System.out.println("Ingrese una de las siguientes opciones:");
	    	for(int i = 0; i < opciones.length; i++) {
	    		System.out.println((i+1)+". "+opciones[i]);
	    	}
	    	System.out.print("Opción: ");
	    	opcion = sc.nextInt();
	    	if(opcion <= 0 || opcion > opciones.length) {
	    		System.out.println("Opción inválida");
	    	}
    	}while(opcion <= 0 || opcion > opciones.length);
    	return opcion;
    	
    }

}
