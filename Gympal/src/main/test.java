package main;

import java.util.Scanner;

import controllers.SocioController;
import menu.Menu;
import valueObject.SocioDto;


public class test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese su usuario:");
        String usuario = sc.nextLine();
        
        System.out.println("Ingrese su contrasenia:");
        String password = sc.nextLine();
		
		SocioDto socioDto = new SocioDto();
		socioDto.setNroSocio(usuario);
		socioDto.setPasswd(password);
		
		SocioController socioController = new SocioController();
		if (socioController.login(socioDto)){
			Menu.menuSocio(socioDto);
		}
		else{
			System.out.println("Logion incorrecto");
		}
	}

}