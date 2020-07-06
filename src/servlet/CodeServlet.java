package servlet;

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

@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gen_code = VerifyCodeUtils.generateVerifyCode(4);
        BufferedImage img = VerifyCodeUtils.createCode(150, 40, gen_code);
        ImageIO.write(img,"jpg",resp.getOutputStream());

        HttpSession session = req.getSession();
        session.setAttribute("vcode",gen_code);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
