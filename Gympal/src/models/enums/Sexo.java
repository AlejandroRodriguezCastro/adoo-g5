package models.enums;

public enum Sexo {
    MASCULINO, FEMENINO;

    public static Sexo fromInteger(int x) {
    	switch(x) {
    	case 0: return MASCULINO;
    	case 1: return FEMENINO;
    	}
    	return null;
    }
}
