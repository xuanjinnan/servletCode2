package stu16Email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/SendEmail_attachment")
public class SendEmail_attachment extends HttpServlet {
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
            //1.设置文本部分
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            //填写消息
            messageBodyPart.setContent("This is message body","text/plain");
            //创建一个多部分消息
            Multipart multipart = new MimeMultipart();
            //设置主体部分
            multipart.addBodyPart(messageBodyPart);


            //2.设置附件部分
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            String filename = "F:\\ServletStudy\\servletCode2\\src\\stu16Email\\file.txt";
            File file = new File(filename);
            System.out.println(file.exists());
            DataSource source = new FileDataSource(file);
            messageBodyPart2.setDataHandler(new DataHandler(source));
            messageBodyPart2.setFileName(filename);
            messageBodyPart2.setContent("file.txt","text/plain");
            multipart.addBodyPart(messageBodyPart2);
            //发送完整的消息部分
            message.setContent(multipart);

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
