package service;

import dao.SearchhistoryDAO;
import dao.UserDAO;

public class UserService implements UserServicelmpl {
    private UserDAO userDAO;
    private SearchhistoryDAO searchhistoryDAO;
    public UserService() {
        this.userDAO = new UserDAO();
        this.searchhistoryDAO = new SearchhistoryDAO();
    }

    @Override
    public boolean CheckLogin(String id, String password){ return userDAO.getUserData1(id,password); }
    @Override
    public boolean DeleteUser(String id){return userDAO.DelUserData(id);}
    @Override
    public void addSearchHistory(String userId, String search) {
        searchhistoryDAO.addSearchHistory(userId, search);  // user_id와 search를 사용하여 검색 기록 추가
    }
}
