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
    private final UserService userService;
    private final UserDAO userDAO;

    public SearchController(){
        userService = new UserService();
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search_text");
        String userId = (String) request.getSession().getAttribute("userId");  // 세션에서 userId 가져오기
        System.out.println("User ID: " + userId);
        System.out.println("Search Text: " + search);


        userService.addSearchHistory(userId, search); // 올바른 user_id와 search를 사용하여 검색 기록 추가
        response.sendRedirect("/main.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = (String) request.getSession().getAttribute("userId");

        if (id != null) {
            System.out.println("Session userId: " + id);
            User user = userDAO.getUserData3(id);
            if (user != null) {
                System.out.println("User found: " + user.getID());
                request.setAttribute("user", user);
                request.getRequestDispatcher("/main.jsp").forward(request, response);
            } else {
                System.out.println("User is null for id: " + id);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            System.out.println("Session userId is null");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
