package adapter;

import java.util.HashMap;
import java.util.Map;
import valueObject.SocioDto;

import models.Interfaces.adapters.IAdapterAutenticator;

public class LoginAdapter implements IAdapterAutenticator {

	private final Map<String, String> usuarios = new HashMap<String, String>();

	public LoginAdapter() {
		usuarios.put("123456", "Passwd1");
		usuarios.put("123455", "Passwd2");
		usuarios.put("123454", "Passwd3");
	}


	@Override
	public boolean loguin(String user, String password) {
		return usuarios.containsKey(user) && usuarios.get(user).equals(password);
		
	}
}