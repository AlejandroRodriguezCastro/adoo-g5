package menu;

import java.util.Scanner;

import controllers.SocioController;
import models.objetivos.Objetivo;
import models.objetivos.ObjetivoBajarDePeso;
import models.objetivos.ObjetivoMantenerFigura;
import models.objetivos.ObjetivoTonificarCuerpo;
import valueObject.SocioDto;

public class Menu {

    public static void mainMenu() {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        SocioDto socioDto = new SocioDto();

        System.out.println("******************************************************");
        System.out.println("******************** GymPal APP **********************");
        System.out.println("******************************************************");
        do {

            System.out.println("\nIngrese su usuario:");
            socioDto.setNroSocio(sc.nextLine());

            System.out.println("Ingrese su contrasenia:");
            socioDto.setPasswd(sc.nextLine());

            if (!SocioController.login(socioDto)) {
                System.out.println("Nro de socio o contraseña incorrecta");
                System.out.println("presione 0 para salir o cualquier otra tecla para reintentar:");
                exit = sc.nextLine().equals("0");
            }
        } while (!SocioController.login(socioDto) && !exit);

        if(!exit){
            menuSocio(socioDto);
        }
    }

    public static void menuSocio(SocioDto socioDto) {

        if (!socioDto.getTieneObjetivo()){
            menuSetearObjetivo(socioDto);
        }

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("********************* BIENVENIDO *********************");
            System.out.println("****************** " + socioDto.getNombre() + " " + socioDto.getApellido() + " ********************");
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
                    SocioController.listar();
                    break;
                case 3:
                    SocioController.pesarSocio();
                    SocioController.listar();
                    break;
            }

        } while (opcion != 0);

    }

    public static void menuSetearObjetivo(SocioDto socioDto) {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("******************************************************");
        System.out.println("************** SELECCION DE OBJETIVOS ****************");
        System.out.println("******************************************************");
        System.out.println("1- BAJAR DE PESO");
        System.out.println("2- MANTENER FIGURA");
        System.out.println("3- TONIFICAR CUERPO");

        System.out.println();
        System.out.println("ELIJA UNA OPCION:");
        opcion = sc.nextInt();

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


}
