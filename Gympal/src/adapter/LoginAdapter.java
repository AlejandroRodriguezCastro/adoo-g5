package adapter;

import java.util.HashMap;
import java.util.Map;
import models.Interfaces.adapters.IAdapterAutenticator;

public class LoginAdapter implements IAdapterAutenticator {

	private final Map<String, String> usuarios = new HashMap<String, String>();

	public LoginAdapter() {
		usuarios.put("123456", "123");
		usuarios.put("123455", "123");
		usuarios.put("123454", "123");
	}
	@Override
	public boolean login(String user, String password) {
		return usuarios.containsKey(user) && usuarios.get(user).equals(password);
	}
	public void register(String user, String password) {
		usuarios.put(user, password);
	}
}