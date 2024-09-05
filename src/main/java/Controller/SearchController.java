package Controller;

import dao.SearchhistoryDAO;
import dto.Searchhistory;
import dto.User;
import dao.UserDAO;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/search_history")
public class SearchController extends HttpServlet {
    private final SearchhistoryDAO searchhistoryDAO;
    private final UserService userService;

    public SearchController(){
        searchhistoryDAO = new SearchhistoryDAO();
        userService = new UserService();
    }

    @Override // 검색 기록 저장
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("user_id");

        userService.addSearchhistory(id);

        resp.sendRedirect( "/main.jsp");
    }
}
