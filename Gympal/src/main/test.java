package main;

import java.util.Scanner;

import dataSets.DataSets;
import menu.Menu;
import models.Socio;

public class test {

	public static void main(String[] args) {
		DataSets ds = new DataSets();
		DataSets.cargaInicial();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese su usuario:");
        String usuario = sc.nextLine();
        
        System.out.println("Ingrese su contrase�a:");
        String contrase�a = sc.nextLine();
		
		Socio s = new Socio();
		if(s.loguin(usuario,contrase�a) != "-1") {
			Menu.menuSocio(s.loguin(usuario,contrase�a));
		}else
			System.out.println("Ingreso Erroneo: ");
		
	}

}