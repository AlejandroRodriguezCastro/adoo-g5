package dataSets;

import java.util.ArrayList;

import models.Socio;

public class DataSets {

	private static DataSets dataSet;
	protected static ArrayList<Socio> usuarios;
	
	protected DataSets() {
		usuarios = new ArrayList<>();

		// SOCIOS
		Socio u1 = new Socio("Alejandro","Salgado","123456","40997301",24,"M",(float) 1.92);
		Socio u2 = new Socio("Carla","Estevez","123455","17154721",55,"F",(float) 1.65);
		Socio u3 = new Socio("Ramon","Espeche","123454","27523147",43,"M",(float) 1.72);

		usuarios.add(u1);
		usuarios.add(u2);
		usuarios.add(u3);
	}

	public static DataSets getDataset() {
		if(dataSet == null){
			dataSet = new DataSets();
		}
		return dataSet;
	}

	public static ArrayList<Socio> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Socio> usuarios) {
		DataSets.usuarios = usuarios;
	}
}
