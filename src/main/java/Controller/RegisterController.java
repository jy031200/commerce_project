package Controller;

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
@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private UserDAO userDAO;
    private UserService userService = new UserService();

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(); // 객체 초기화
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String number = req.getParameter("number");

        User newUser = new User(name, id, password, number);

        userDAO.addUserData(List.of(newUser));
        resp.sendRedirect("login.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        boolean isValidUser = userService.CheckLogin(id, password);

        if (isValidUser) {
            // 로그인 성공 시 리디렉션 또는 페이지 포워딩
            req.getSession().setAttribute("userId", id); // 사용자 ID를 세션에 저장
            resp.sendRedirect("/index.jsp"); // 로그인 후 환영 페이지로 리디렉션
        } else {
            // 로그인 실패 시 원래 로그인 페이지로 리디렉션
            req.setAttribute("errorMessage", "로그인 실패"); // 실패 메시지를 요청 속성으로 설정
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // 로그인 페이지로 포워딩
        }
    }
}