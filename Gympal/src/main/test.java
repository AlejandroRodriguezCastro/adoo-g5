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
        
        System.out.println("Ingrese su contraseña:");
        String contraseña = sc.nextLine();
		
		Socio s = new Socio();
		if(s.loguin(usuario,contraseña) != "-1") {
			Menu.menuSocio(s.loguin(usuario,contraseña));
		}else
			System.out.println("Ingreso Erroneo: ");
		
	}

}