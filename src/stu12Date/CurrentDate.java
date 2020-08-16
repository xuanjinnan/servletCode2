package stu12Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CurrentDate")
public class CurrentDate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String title = "显示当前的日期和时间";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss E a");

        String docType = "<!DOCTYPE html>\n";
        PrintWriter out = resp.getWriter();
        out.println(docType +
                "</html>\n" +
                "<head><title>" +title + "</title></head>" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>" +
                "<h2 align=\"center\">" + sdf.format(date) + "</h2>\n" +
                "</body></html>");
    }
}
