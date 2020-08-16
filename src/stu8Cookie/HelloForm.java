package stu8Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/HelloFormCookie")
public class HelloForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //创建Cookie
        Cookie nameCookie = new Cookie("name", URLEncoder.encode("big food kfc", "UTF-8"));
        //设置过期时间
        nameCookie.setMaxAge(60*60*24);
        //设置path和domain,domain是域名比如 www.baidu.com 的域名可以是 baidu.com
        nameCookie.setDomain("nan.com");
        nameCookie.setPath("/");
        //在响应中添加两个 Cookie
        resp.addCookie(nameCookie);
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
