package models.enums;

public enum Genero {
    MASCULINO, FEMENINO, OTRO;

    public static Genero fromInteger(int x) {
    	switch(x) {
    	case 0: return MASCULINO;
    	case 1: return FEMENINO;
    	case 2: return OTRO;
    	}
    	
    	return null;
    }
}
