package dataSets;

import java.util.ArrayList;
import models.Socio;

public class DataSets {

	private static DataSets dataSet;
	private static final ArrayList<Socio> usuarios = new ArrayList<>();

	public static DataSets getDataSet(){
		if (dataSet == null){
			dataSet = new DataSets();
		}
		return dataSet;
	}

	private DataSets() {
		// SOCIOS
		Socio socio1 = new Socio("Alejandro","Salgado","123456","40997301",24,"M",(float) 1.92);
		Socio socio2 = new Socio("Carla","Estevez","123455","17154721",55,"F",(float) 1.65);
		Socio socio3 = new Socio("Ramon","Espeche","123454","27523147",43,"M",(float) 1.72);

		usuarios.add(socio1);
		usuarios.add(socio2);
		usuarios.add(socio3);
	}

	public ArrayList<Socio> getUsuarios() {
		return usuarios;
	}

	public Socio getSocioByNroSocio(String nroSocio) {
		return usuarios.stream().filter(socio -> socio.getNroSocio().equals(nroSocio)).findFirst().orElse(null);
	}
	public void guardarSocio(Socio s) {
		usuarios.remove(s);
		usuarios.add(s);
	}
}
