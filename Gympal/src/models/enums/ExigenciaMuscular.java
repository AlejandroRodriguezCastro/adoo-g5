package models.enums;

public enum ExigenciaMuscular {
    BAJA,MEDIA,ALTA;
    
    public static ExigenciaMuscular fromInteger(int x) {
    	switch(x) {
    	case 0: return BAJA;
    	case 1: return MEDIA;
    	case 2: return ALTA;
    	}
    	return null;
    }
}
