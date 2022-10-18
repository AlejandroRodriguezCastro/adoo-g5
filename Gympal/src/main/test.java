package main;

import models.Socio;

public class test {

	public static void main(String[] args) {
		Socio s = new Socio();
		s.setNroSocio("Socio1");
		if(s.loguin("User1","Passwd1")) {
			System.out.println("Ingreso Correcto");
		}else
			System.out.println("Ingreso Erroneo");
		
	}

}