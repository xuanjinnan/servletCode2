package stu7ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloWorldError")
public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {

        message = "Hello World";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int a = 1/0;
        //设置响应内容类型
        resp.setContentType("text/html");
        //实际的逻辑是在这里
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "<h1>");
        resp.sendRedirect("/HelloWord");
    }

    @Override
    public void destroy() {
        //什么也不做
    }
}
