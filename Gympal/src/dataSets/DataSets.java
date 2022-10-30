package dataSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Socio;

public class DataSets {

	private static DataSets dataSet;
	private List<Socio> usuarios;
	
	private DataSets() {
		usuarios = new ArrayList<>(
				Arrays.asList(
						new Socio("Alejandro","Salgado","123456","40997301",24,"M",(float) 1.92),
						new Socio("Carla","Estevez","123455","17154721",55,"F",(float) 1.65),
						new Socio("Ramon","Espeche","123454","27523147",43,"M",(float) 1.72)
				)
		);

	}

	public static DataSets getDataset() {
		if(dataSet == null){
			dataSet = new DataSets();
		}
		return dataSet;
	}

	public List<Socio> getUsuarios() {
		return this.usuarios;
	}
}
