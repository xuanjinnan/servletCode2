package stu15RefreshWithDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet("/RefreshWithDate")
public class RefreshWithDate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置刷新自动加载的事件间隔为 5 秒
        resp.setIntHeader("Refresh",5);
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");

        //获取当前时间
        Calendar calendar = new  GregorianCalendar();
        String am_pm;
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        if(calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";

        String CT = hour + ":" + minute + ":" + second + " " + am_pm;
        PrintWriter out = resp.getWriter();
        String title = "使用 Servlet 自动刷新页面";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是: " + CT + "</p>\n" +
                "</body>\n" +
                "</html>\n" );

    }
}
