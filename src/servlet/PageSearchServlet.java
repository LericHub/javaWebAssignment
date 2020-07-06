package servlet;

import dao.UserDao;
import domain.PageBean;
import domain.User;
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
import java.util.List;

@WebServlet("/pageSearchServlet")
public class PageSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        PageBean pb = (PageBean) session.getAttribute("pb");
        String page = req.getParameter("current");

        int int_page = Integer.parseInt(page);
        int row = pb.getRow();
        pb.setCurrent(int_page);

        UserDao dao = new UserDao();
        List<User> list = dao.fidByPage(int_page, row);

        session.setAttribute("list",list);
        session.setAttribute("pb",pb);
        resp.sendRedirect(req.getContextPath()+"/list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
