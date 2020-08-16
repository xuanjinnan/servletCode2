package stu9ServletTracking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;

@WebServlet("/SessionTrack")
public class SessionTrack extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果不存在 session 会话，则创建一个 session 对象
        HttpSession session = req.getSession(true);
        //获取 session 创建时间
        long creationTime = session.getCreationTime();
        //获取该网页最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        //session存活时间
        int maxInactiveInterval = session.getMaxInactiveInterval();
        int maxInactive = maxInactiveInterval / 60;

        //设置日期输出的格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String title = "Servlet Session 实例 - 菜鸟教程";
        int visitCount = 0;
        String visitCountKey = "visitCount";
        String userIDKey = "userID";
        String userID = "Runoob";
        if (session.getAttribute(visitCountKey) == null) {
            session.setAttribute(visitCountKey, 0);
        }
        //检查网页上是否有新的访问者
        if (session.isNew()) {
            title = "Servlet Session 实例 - 菜鸟教程";
            session.setAttribute(userIDKey, userID);
        } else {
            visitCount = (Integer) session.getAttribute(visitCountKey);
            visitCount += 1;
            userID = ((String) session.getAttribute(userIDKey));
        }
        session.setAttribute(visitCountKey, visitCount);
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align =\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session信息</h2>" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "   <th>Session信息</th><th>值</th>\n" +
                "<tr>\n" +
                "   <td>id</td>\n" +
                "   <td>" + session.getId() + "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "   <td>创建时间</td>\n" +
                "   <td>" + df.format(creationTime) + "</td>\n" +
                "</tr>" +
                "<tr>\n" +
                "   <td>最后访问时间</td>\n" +
                "   <td>" + df.format(lastAccessTime) + "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "   <td>用户ID</td>\n" +
                "   <td>" + userID + "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "   <td>访问统计</td>\n" +
                "   <td>" + visitCount + "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "   <td>Session时间</td>\n" +
                "   <td>" + maxInactive + "分钟</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</body></html>");
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
