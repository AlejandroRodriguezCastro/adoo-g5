package models.enums;

public enum GrupoMuscular {
    PECHO, ESPALDA, HOMBROS, PIERNAS, BRAZOS;
	
	public static GrupoMuscular fromInteger(int x) {
		switch(x) {
		case 0: return PECHO;
		case 1: return ESPALDA;
		case 2: return HOMBROS;
		case 3: return PIERNAS;
		case 4: return BRAZOS;
		}
		return null;
	}
}
