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

@WebServlet("/searchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        UserDao dao = new UserDao();
        List<User> users = dao.findAll();
        int size = users.size();
        int row = 5;
        int pageSize = (int) Math.ceil(size/row);

        PageBean pb = new PageBean();
        pb.setRow(row);
        pb.setPageSize(pageSize);
        pb.setSize(size);


        HttpSession session = req.getSession();
        session.setAttribute("list",users);
        session.setAttribute("pb",pb);
        resp.sendRedirect(req.getContextPath()+"/list.jsp");
//        req.getRequestDispatcher(req.getContextPath()+"/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
