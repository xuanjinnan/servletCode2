package stu13Redirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PageRedirect")
public class PageRedirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        //要重定向的新位置
        String site = "http://www.runoob.com";

        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location",site);
    }
}
