package main;

import java.util.Scanner;

import dataSets.DataSets;
import menu.Menu;
import models.Socio;

public class test {

	public static void main(String[] args) {

		DataSets dataSets = DataSets.getDataset();
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese su usuario:");
        String usuario = sc.nextLine();
        
        System.out.println("Ingrese su contrasenia:");
        String password = sc.nextLine();
		
		Socio socio = new Socio();
		if(socio.login(usuario,password)) {
			socio = dataSets.getUsuarios().stream().filter(socio1 -> socio1.getNroSocio().equals(usuario)).findFirst().orElse(null);
			assert socio != null;
			Menu.menuSocio(socio);
		}else
			System.out.println("Ingreso Erroneo: ");
		
	}

}