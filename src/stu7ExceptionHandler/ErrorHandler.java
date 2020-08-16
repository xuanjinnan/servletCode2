package stu7ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ErrorHandler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String requestUri = ((String) req.getAttribute("javax.servlet.error.request_uri"));
        if (requestUri == null) {
            requestUri = "Unkown";
        }
        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        System.out.println(throwable);
        String servletNmae = ((String) req.getAttribute("javax.servlet.error.servlet_name"));
        Object exception_type = req.getAttribute("javax.servlet.error.exception_type");
        String message = ((String) req.getAttribute("javax.servlet.error.message"));
        System.out.println("exception_type:" + exception_type);
        System.out.println("message:" + message);
        if (servletNmae == null) {
            servletNmae = "Unkown";
        }
        resp.setContentType("text/html;charset = UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "菜鸟教程 Error/Exception 信息";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1>菜鸟教程异常信息实例演示</h1>");
        if (throwable == null && statusCode == null) {
            out.println("<h2>错误信息丢失</h2>");
            out.println("请返回<a href=\"" + resp.encodeURL("http://localhost:80") + "\">主页</a>");
        } else if (statusCode != null) {
            out.println("错误代码 ：" + statusCode);
        } else {
            out.println("<h2>错误信息</h2>");
            out.println("Servlet Name : " + servletNmae + "</br></br>");
            out.println("异常类型 ： " + throwable.getClass().getName() + "</br></br>");
            out.println("请求 URI : " + requestUri + "</br></br>");
            out.println("异常信息 ：" + throwable.getMessage());

//        }
            out.println("</body></html>");
        }
    }
}
