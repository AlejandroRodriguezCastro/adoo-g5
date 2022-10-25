package adapter;

import java.util.HashMap;
import java.util.Map;

import models.Socio;
import models.Interfaces.adapters.IAdapterAutenticator;

public class LoguinAdapter implements IAdapterAutenticator {

	private final

	Map<String, String> usuarios = new HashMap<String, String>();
	Map<String, String> contraseña = new HashMap<String, String>();

	public LoguinAdapter() {
		usuarios.put("User1", "123456");
		usuarios.put("User2", "123455");
		usuarios.put("User3", "123454");

		contraseña.put("User1", "Passwd1");
		contraseña.put("User2", "Passwd2");
		contraseña.put("User3", "Passwd3");

	}

	@Override
	public String login(String user, String passwd) {
		for (Map.Entry<String, String> entry : contraseña.entrySet()) {

			if (entry.getKey().equals(user)) {
					if (contraseña.get(user).equals(passwd))
							return usuarios.get(user);
				}

			}

		return "-1";
	}

}
