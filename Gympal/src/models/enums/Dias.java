package models.enums;

public enum Dias {
   LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
	
	public static Dias fromInteger(int x) {
		switch(x) {
		case 0: return LUNES;
		case 1: return MARTES;
		case 2: return MIERCOLES;
		case 3: return JUEVES;
		case 4: return VIERNES;
		case 5: return SABADO;
		case 6: return DOMINGO;
		}
		return null;
	}
}
