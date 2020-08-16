package stu1Instance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/NotRecircleServletImmediately")
public class NotRecircleServletImmediately extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        System.out.println("servlet初始化……");
        message = "Hello World , Nice To Meet You: " + System.currentTimeMillis();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.write("<h1>" + message + "</h1>");
        destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁！");
        super.destroy();
    }
}
