package service;

import dao.UserDAO;
import dto.User;

import java.util.List;

public class UserService implements UserServicelmpl {
    private UserDAO userDAO;
    public UserService() {this.userDAO = new UserDAO();}

    @Override
    public boolean CheckLogin(String id, String password){ return userDAO.getUserData(id,password); }
}
