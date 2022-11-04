package controllers;

import models.Socio;
import valueObject.SocioDto;

public class SocioController {
	
	private Socio socio;
	
	public SocioController() {
		this.socio = new Socio();
	}
	
	public SocioDto loguin(SocioDto s) {
		return this.socio.login(s.getNroSocio(),s.getPasswd());
	}

}
