package models.Interfaces.adapters;

public interface IAdapterAutenticator {

    boolean login(String email, String password);
    public void register(String user, String password);
}
