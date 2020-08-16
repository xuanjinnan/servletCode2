package stu8Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/ReadCookies")
public class ReadCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = req.getCookies();

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String title = "Delete Cookie Example";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType + "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n");
        if (cookies != null) {
            out.println("<h2>Cookie 名称和值</h2>");
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
               /* if (cookie.getName().compareTo("name") == 0) {//相等
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                    out.print("已删除 cookie:" + cookie.getName() + "</br>");
                }*/
                out.print("名称：" + cookie.getName() + ",");
                out.print("值：" + URLDecoder.decode(cookie.getValue(), "UTF-8") + "</br>");
                System.out.println(cookie.getDomain());
            }
        } else {
            out.println("<h2 class=\"tutheader\">No Cookie found</h2>");
        }
        out.println("</body></html>");
    }
    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println("lmd表达式!");
        };
        new Thread(runnable).start();
    }
}
