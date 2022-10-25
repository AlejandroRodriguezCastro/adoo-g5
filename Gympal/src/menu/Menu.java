package menu;

import java.util.Scanner;

import dataSets.DataSets;
import models.Medicion;
import models.Socio;

public class Menu extends DataSets{
	
	private static Socio socio;
	private static Medicion medicion;
	private static String nombre;
	private static String apellido;
	
	public static void menuSocio(String nroSocio) {
		
		Scanner sc = new Scanner(System.in);
		socio = new Socio();
		medicion = new Medicion();
		
		for(Socio s: usuarios) {
			if(s.getNroSocio().equals(nroSocio)) {
				nombre = s.getNombre();
				apellido = s.getApellido();
				socio = s;
			}
		}
		
		int opcion = 1;
		
		while(opcion!=0) {
		
		System.out.println();
		System.out.println("********************* BIENVENIDO *********************");
		System.out.println("******************" + nombre + " " + apellido + "********************");
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
		
		}
		
	}

}
