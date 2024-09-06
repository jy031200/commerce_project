package service;

public interface UserServicelmpl {
    public boolean CheckLogin(String id, String password);

    public boolean DeleteUser(String id);

    public void addSearchHistory(String userId, String search);
}
