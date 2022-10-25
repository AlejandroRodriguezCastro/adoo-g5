package adapter;

import java.util.HashMap;
import java.util.Map;

import models.Socio;
import models.Interfaces.adapters.IAdapterAutenticator;

public class LoguinAdapter implements IAdapterAutenticator {

	private final

	Map<String, String> usuarios = new HashMap<String, String>();
	Map<String, String> contraseņa = new HashMap<String, String>();

	public LoguinAdapter() {
		usuarios.put("User1", "123456");
		usuarios.put("User2", "123455");
		usuarios.put("User3", "123454");

		contraseņa.put("User1", "Passwd1");
		contraseņa.put("User2", "Passwd2");
		contraseņa.put("User3", "Passwd3");

	}

	@Override
	public String login(String user, String passwd) {
		for (Map.Entry<String, String> entry : contraseņa.entrySet()) {

			if (entry.getKey().equals(user)) {
					if (contraseņa.get(user).equals(passwd))
							return usuarios.get(user);
				}

			}

		return "-1";
	}

}
