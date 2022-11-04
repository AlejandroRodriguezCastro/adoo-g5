package menu;

import java.util.Scanner;

import models.Medicion;
import valueObject.SocioDto;

public class Menu{

	private static Medicion medicion;

	
	public static void menuSocio(SocioDto socio) {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		medicion = new Medicion();

		do {
		System.out.println();
		System.out.println("********************* BIENVENIDO *********************");
		System.out.println("******************" + socio.getNombre() + " " + socio.getApellido() + "********************");
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
        
		switch(opcion){
			case 1:
				System.out.println(socio.toString());
				break;
			case 3:
				System.out.println("PESO:" + medicion.obtenerMedicion());
				break;
		}
		
		}while(opcion!=0);
		
	}

}
