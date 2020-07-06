package servlet;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.JdbcUpdateAffectedIncorrectNumberOfRowsException;
import util.VerifyCodeUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/showServlet")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        UserDao dao = new UserDao();
        String id = req.getParameter("id");
        int int_id = Integer.parseInt(id);

        User user = dao.find(int_id);
        HttpSession session = req.getSession();
        session.setAttribute("show",user);
        session.setAttribute("id",int_id);
        resp.sendRedirect(req.getContextPath()+"/update.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
