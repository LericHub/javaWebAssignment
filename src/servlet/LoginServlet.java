package servlet;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

    @WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        System.out.println("=================Login=================");
        String name = req.getParameter("user");
        String password = req.getParameter("password");
        String verifycode = req.getParameter("verifycode");
        HttpSession session = req.getSession();
        String vcode = (String) session.getAttribute("vcode");
        session.removeAttribute("vcode");

        System.out.println("name: " + name);
        System.out.println("password: " + password);
        System.out.println("in_code: " + verifycode);
        System.out.println("vcode: " + vcode);

        User user_login = new User(name, password);
        UserDao dao = new UserDao();
        User login = dao.login(user_login);

        if (verifycode.equalsIgnoreCase(vcode)) {
            if (login != null) {
                System.out.println("Login success");
                // 重定向
                session.setAttribute("user",name);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
            } else {
                System.out.println("login error");
                req.setAttribute("error", "账号密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);

            }
        } else {
            System.out.println("code error");
            req.setAttribute("error", "验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
