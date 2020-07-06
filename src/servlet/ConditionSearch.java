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

@WebServlet("/conditionSearch")
public class ConditionSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        session.removeAttribute("list");
        PageBean pb = (PageBean) session.getAttribute("pb");
        UserDao dao = new UserDao();

        String name = req.getParameter("name");
        String address = req.getParameter("address");
        int row = pb.getRow();
        String current = req.getParameter("current");
        int int_current ;
        if (current == null || current == ""){
            int_current = 0;
        }else{
            int_current = Integer.parseInt(current);
        }
        List<User> list = dao.conditionsearch(name, address,int_current,row);

        int size = dao.conditionsearch(name, address);
        pb.setSize(size);
        pb.setCurrent(int_current);

        pb.setPageSize((int)Math.ceil(size/row));

        session.removeAttribute("list");
        session.setAttribute("list",list);
        session.setAttribute("pb",pb);
        resp.sendRedirect(req.getContextPath()+"/list.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
