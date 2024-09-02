package service;

import dao.UserDAO;

public class UserService implements UserServicelmpl {
    private UserDAO userDAO;
    public UserService() {this.userDAO = new UserDAO();}

    @Override
    public boolean CheckLogin(String id, String password){ return userDAO.getUserData1(id,password); }
    @Override
    public boolean DeleteUser(String id){return userDAO.DelUserData(id);}

}
