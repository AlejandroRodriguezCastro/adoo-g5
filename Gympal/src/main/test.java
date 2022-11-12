package main;

import java.util.Calendar;
import java.util.Scanner;

import controllers.SocioController;
import dataSets.DataSets;
import menu.Menu;
import models.Socio;
import valueObject.SocioDto;

public class test {

	public static void main(String[] args) {

		DataSets dataSets = DataSets.getDataset();
		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese su usuario:");
        String usuario = sc.nextLine();
        
        System.out.println("Ingrese su contrasenia:");
        String password = sc.nextLine();
		
		SocioDto socio = new SocioDto();
		socio.setNroSocio(usuario);
		socio.setPasswd(password);
		
		SocioController s = new SocioController();
		
		if(s.loguin(socio)!=null) {
			SocioController.menuSocio(s.loguin(socio));
		}else
			System.out.println("Ingreso Erroneo: ");
		
	}

}