package dao;

import dto.User;

import java.util.List;

public interface UserDAOlmpl {
    public void addUserData(List<User> userList);
    public boolean getUserData1(String id, String password);
    public User getUserData2(String ID);
    public boolean DelUserData(String ID);
}
