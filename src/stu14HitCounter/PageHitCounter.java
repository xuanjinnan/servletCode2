package stu14HitCounter;

import sun.security.jgss.HttpCaller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PageHitCounter")
public class PageHitCounter extends HttpServlet {
    private int hitCount;
    private static final String SESSION_HIT_COUNTER = "sessionHitCounter";
    @Override
    public void init() throws ServletException {
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        hitCount++;

        HttpSession session = req.getSession();
        int sessionHitCounter;
        if(session.isNew()){
            sessionHitCounter = 1;
            session.setAttribute(SESSION_HIT_COUNTER,sessionHitCounter);
        }else {
            sessionHitCounter= (Integer) session.getAttribute(SESSION_HIT_COUNTER) + 1;
            session.setAttribute(SESSION_HIT_COUNTER, sessionHitCounter);
        }
        PrintWriter out = resp.getWriter();
        String title = "点击总量、会话内的量";
        String title1 = "点击总量";
        String title2 = "会话内的量";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><tilte>" + title + "</title></head>\n" +
                "<body bgcolor=\"f0f0f0\">\n" +
                "<h1 align=\"center\">" + title1 + "</h1>" +
                "<h2 align=\"center\">" + hitCount + "</h2>\n" +
                "<h1 align=\"center\">" + title2 + "</h1>\n" +
                "<h2 align=\"center\">" + sessionHitCounter + "</h2>\n" +
                "</body></html>");

    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
