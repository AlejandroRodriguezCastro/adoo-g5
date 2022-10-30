package dataSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import models.Ejercicio;
import models.Socio;
import models.enums.ExigenciaMuscular;
import models.enums.GrupoMuscular;

public class DataSets {

	private static DataSets dataSet;
	private List<Socio> usuarios;
	private List<Ejercicio> ejercicios;
	
	private DataSets() {
		usuarios = new ArrayList<>(Arrays.asList(
				new Socio("Alejandro","Salgado","123456","40997301",24,"M",(float) 1.92),
				new Socio("Carla","Estevez","123455","17154721",55,"F",(float) 1.65),
				new Socio("Ramon","Espeche","123454","27523147",43,"M",(float) 1.72)
				));

		ejercicios = new ArrayList<>(Arrays.asList(
				new Ejercicio(3,15,5.0f,5, ExigenciaMuscular.ALTA, GrupoMuscular.ESPALDA,null),
				new Ejercicio(2,10,5.0f,3, ExigenciaMuscular.MEDIA, GrupoMuscular.HOMBROS,null),
				new Ejercicio(3,18,12.0f,2, ExigenciaMuscular.ALTA, GrupoMuscular.PIERNAS,null),
				new Ejercicio(3,15,5.0f,6, ExigenciaMuscular.MEDIA, GrupoMuscular.BRAZOS,null),
				new Ejercicio(5,10,3.0f,4, ExigenciaMuscular.BAJA, GrupoMuscular.PECHO,null),
				new Ejercicio(4,20,2.0f,1, ExigenciaMuscular.BAJA, GrupoMuscular.HOMBROS,null),
				new Ejercicio(3,15,5.0f,2, ExigenciaMuscular.MEDIA, GrupoMuscular.PECHO,null),
				new Ejercicio(6,5,6.0f,5, ExigenciaMuscular.MEDIA, GrupoMuscular.PECHO,null),
				new Ejercicio(3,10,7.0f,6, ExigenciaMuscular.ALTA, GrupoMuscular.ESPALDA,null)
		));

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

	public Socio getUsuario(String usuario) {
		return this.usuarios.stream().filter(socio -> socio.getNroSocio().equals(usuario)).findFirst().orElse(null);
	}

	public List<Ejercicio> getEjercicios() {
		return this.ejercicios;
	}

	public  List<Ejercicio> getEjerciciosByExigenciaMuscular(ExigenciaMuscular exigenciaMuscular) {
		return this.ejercicios.stream().filter(ejericico -> ejericico.getExigenciaMuscular().toString().equals(exigenciaMuscular.toString())).collect(Collectors.toList());
	}
}
