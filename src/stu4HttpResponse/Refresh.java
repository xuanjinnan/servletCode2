package stu4HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置刷新时间为 5 秒
//        resp.setIntHeader("refresh",5);
        resp.setContentType("text/html;charset=UTF-8");
        Calendar cale = Calendar.getInstance();
        Date taskTime = cale.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(taskTime);
        System.out.println("setBufferSize end");
        resp.setBufferSize(100);
        System.out.println("setBufferSize end");
        PrintWriter out = resp.getWriter();
        String title = "自动刷新 Header 设置 - 菜鸟教程实例";
        String docType="<!DOCTYPE html>\n";
        out.println(docType+
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是：" + nowTime + "</p>\n");
        //test HttpResponseServlet
        System.out.println("resp.encodeRedirectURL(\"啊啊啊\") start");
        System.out.println(resp.encodeRedirectURL("啊啊啊"));
        System.out.println("resp.encodeRedirectURL(\"啊啊啊\") end");
        System.out.println("resp.encodeURL(\"啊啊啊\") start");
        System.out.println(resp.encodeURL("啊啊啊"));
        System.out.println("resp.encodeURL(\"啊啊啊\") end");
        System.out.println("containsHeader start");
        System.out.println(resp.containsHeader("content-type"));
        System.out.println("containsHeader end");
        System.out.println("isCommitted start");
        System.out.println(resp.isCommitted());
        System.out.println("isCommitted end");
        System.out.println("addCookie start");
        resp.addCookie(new Cookie("myCookie","sweet"));
        System.out.println("addCookie end");
        System.out.println("addDateHeader start");
        resp.addDateHeader("nowTime",new Date().getTime());
        System.out.println("addDateHeader end");
        System.out.println("addHeader start");
        resp.addHeader("myHeader","no hair");
        resp.addHeader("myHeader","no hair");
        System.out.println("addHeader end");
//        System.out.println("reset flushBuffer resetBuffer start");
//        resp.reset();
//        resp.flushBuffer();
//        resp.resetBuffer();
//        System.out.println("reset flushBuffer resetBuffer end");
        /*System.out.println("sendError start");
        resp.sendError(500);
        System.out.println("sendError end");*/
        /*System.out.println("sendError(sc,msg) start");
        resp.sendError(500,"服务错误!");
        System.out.println("sendError(sc,msg) end");*/
        System.out.println("addIntHeader start");
        resp.addIntHeader("Status Code",200);
        System.out.println("addIntHeader end");
        /*System.out.println("sendRedirect start");
        resp.sendRedirect("DisplayHeader");
        System.out.println("sendRedirect end");*/
//        resp.setCharacterEncoding("ISO8859-1");
        System.out.println("setContentLength(121)");
        resp.setContentLength(244);
        System.out.println("setDateHeader(\"nowTime2\",new Date().getTime()");
        resp.setDateHeader("nowTime2",new Date().getTime());
        resp.addDateHeader("nowTime",new Date().getTime());
        resp.setDateHeader("nowTime",new Date().getTime());
        resp.setHeader("myHeader","no hair");
        System.out.println("addIntHeader setIntHeader(\"intHeader\",666)");
        resp.addIntHeader("intHeader",666);
        resp.setIntHeader("intHeader",666);
//        resp.setLocale(new Locale("zh-CN"));
//        resp.setStatus(304);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
