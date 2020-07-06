package servlet;

import dao.UserDao;
import domain.User;
import util.VerifyCodeUtils;

import javax.imageio.ImageIO;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.UnknownServiceException;

@WebServlet("/updateSrevlet")
public class UpdateSrevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");

        String age = req.getParameter("age");
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String gender = req.getParameter("gender");
        String mail = req.getParameter("mail");

        User user = new User();
        user.setMail(mail);
        user.setQq(qq);
        user.setBirthplace(address);
        user.setAge(Integer.parseInt(age));
        user.setGender(gender);
        user.setId(id);

        UserDao dao = new UserDao();
        dao.update(user);

        resp.sendRedirect(req.getContextPath()+"/searchServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
