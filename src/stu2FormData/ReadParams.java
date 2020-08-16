package stu2FormData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("physics"));
        PrintWriter out = resp.getWriter();
        String title = "读取所有的表单数据";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0" +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>参数名称</th><th>参数值</th>\n" +
                "</tr>\n");
        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            out.println("<tr><td>" + paramName + "</td>\n");
            String[] paramValues = req.getParameterValues(paramName);
            System.out.println(paramName);
            System.out.println(Arrays.toString(paramValues));
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() == 0) {
                    out.println("<td><i>没有值</i></td>");
                } else {
                    out.println("<td>" + paramValue + "</td>");
                }
            }else {
                //读取多个值的数据
                out.println("<td><ul>");
                for (int i = 0; i < paramValues.length; i++) {
                    out.println("<li>" + paramValues[i]);
                }
                out.println("</ul></td>");
            }
            out.println("</tr>");
        }
        out.println("\n</table>\n</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
