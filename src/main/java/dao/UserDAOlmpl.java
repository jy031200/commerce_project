package dao;

import dto.User;

import java.util.List;

public interface UserDAOlmpl {
    public void addUserData(List<User> userList);
    public boolean getUserData(String id, String password);

}
