package main;

import models.Socio;

public class test {

	public static void main(String[] args) {
		Socio s = new Socio();
		if(s.loguin("User1","Passwd1") != "-1") {
			System.out.println("Ingreso Correcto: usuario:" + s.loguin("User1","Passwd1") );
		}else
			System.out.println("Ingreso Erroneo");
		
	}

}