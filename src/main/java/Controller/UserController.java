package Controller;

import dao.UserDAO;
import dto.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/login")

public class UserController extends HttpServlet {
    private final UserService userService;
    private final UserDAO userDAO;

    public UserController() {
        this.userService = new UserService();
        this.userDAO = new UserDAO();
    }

    @Override // 입력된 데이터 DB와 일치하는지 확인(로그인)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        String password = req.getParameter("password");

        boolean isValidUser = userService.CheckLogin(id, password);

        if (isValidUser) {
            // 로그인 성공 시 리디렉션 또는 페이지 포워딩
            req.getSession().setAttribute("userId", id); // 사용자 ID를 세션에 저장
            resp.sendRedirect("/main.jsp"); // 로그인 후 환영 페이지로 리디렉션
        } else {
            // 로그인 실패 시 원래 로그인 페이지로 리디렉션
            req.setAttribute("errorMessage", "로그인 실패"); // 실패 메시지를 요청 속성으로 설정
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // 로그인 페이지로 포워딩
        }
    }
}