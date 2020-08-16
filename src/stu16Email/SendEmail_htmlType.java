package stu16Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/SendEmail_htmlType")
public class SendEmail_htmlType extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收件人的电子邮件 ID
        String to = "15910976735@139.com";
        //发件人的电子邮箱 ID
        String from = "15910976735@139.com";
        //假定您是从本地主机发送电子邮件
        String host = "smtp.139.com";
        //获取系统的属性
        Properties properties = System.getProperties();
        //设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        //设置授权校验
        properties.setProperty("mail.smtp.auth", "true");
        //获取默认的 Session 对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("15910976735@139.com","Xuanjinnan01");
            }
        });
        //设置响应内容类型
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO,new InternetAddress[]{new InternetAddress(to),new InternetAddress("785337571@qq.com")});
            message.setSubject("This is the Subject Line!");
//            message.setText("This is actual message!");
            message.setContent("<h1> This is actual message! </h1>","text/html");
            Transport.send(message);
            String title = "发送电子邮件";
            String res = "成功发送消息。。。";
            String docType = "<!DOCTYPE html> \n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>" +
                    "<body bgcolor=\"f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<p align=\"center\">" + res + "</p>\n" +
                    "</body></html>");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
