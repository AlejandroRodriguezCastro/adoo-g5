package models.Interfaces.adapters;

import models.Socio;

public interface IAdapterAutenticator {

    boolean login(Socio socio, String user, String passwd);

}
