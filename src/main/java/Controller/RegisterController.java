/*
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

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(); // 객체 초기화
    }

    @Override // 입력된 회원 데이터 DB 저장(회원가입)
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
}*/
