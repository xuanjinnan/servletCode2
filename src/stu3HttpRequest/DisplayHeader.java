package stu3HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/DisplayHeader")
public class DisplayHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = 1/0 ;
       /* Enumeration<String> attributeNames = req.getAttributeNames();
        System.out.println("attribute start");
        while (attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            Object attributeValue = req.getAttribute(attributeName);
            System.out.println(attributeName + "\t" + attributeValue);
        }
        System.out.println("attribute end");
        System.out.println("getSession(boolean) start");
        System.out.println(req.getSession(false));
        System.out.println("getSession(boolean) end");*/
        System.out.println("getLocal() start");
        printlnEnumerationLocales(req.getLocales());
        System.out.println(req.getLocale());
        System.out.println("getLocal() end");
        System.out.println("getAuthType() start");
        System.out.println(req.getAuthType());
        System.out.println("getAuthType() end");
        /*System.out.println("getInputStream start");
        ServletInputStream inputStream = req.getInputStream();
        BufferedReader bis = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while((line = bis.readLine()) != null)
            System.out.println(line);
        System.out.println("getInputStream end");*/
        /*System.out.println("getCharacterEncoding start");
        System.out.println(req.getCharacterEncoding());
        System.out.println("getCharacterEncoding end");
        System.out.println("getContentType start");
        System.out.println(req.getContentType());
        System.out.println("getContentType end");*/
        System.out.println("getContextPath start");
        System.out.println(req.getContextPath());
        System.out.println("getContextPath end");
        System.out.println("getMethod start");
        System.out.println(req.getMethod());
        System.out.println("getMethod end");
        System.out.println("getPathInfo start");
        System.out.println(req.getPathInfo());
        System.out.println("getPathInfo end");
        System.out.println("getProtocol start");
        System.out.println(req.getProtocol());
        System.out.println("getProtocol end");
        System.out.println("返回包含在路径后的请求 URL 中的查询字符串,就是 Get 请求地址栏问号后面的数据");
        System.out.println("getQueryString start");
        System.out.println(req.getQueryString());
        System.out.println("getQueryString end");
        System.out.println("getRemote start");
        System.out.println("getRemoteUser:  " + req.getRemoteUser());
        System.out.println("getRemoteAddr:  " + req.getRemoteAddr());
        System.out.println("getRemoteHost:  " + req.getRemoteHost());
        System.out.println("getRemotePort:  " + req.getRemotePort());
        System.out.println("getRemote end");
        System.out.println("getRequestURI start");
        System.out.println("getRequestURI:  " + req.getRequestURI());
        System.out.println("getRequestURI end");
        /*System.out.println("getRequestedSessionId start");
        System.out.println("getRequestedSessionId:  " + req.getRequestedSessionId());
        System.out.println("getRequestedSessionId end");*/
        System.out.println("getServletPath start");
        System.out.println("getServletPath:  " + req.getServletPath());
        System.out.println("getServletPath end");
        /*System.out.println("isSecure start");
        System.out.println("isSecure:  " + req.isSecure());
        System.out.println("isSecure end");*/
        /*System.out.println("getIntHeader(\"Upgrade-Insecure-Requests\") start");
        System.out.println("Upgrade-Insecure-Requests:  " + req.getIntHeader("Upgrade-Insecure-Requests"));
        System.out.println("getIntHeader(\"Upgrade-Insecure-Requests\") end");*/
        System.out.println("getServerPort start");
        System.out.println("getServerPort:  " + req.getServerPort());
        System.out.println("getServerPort end");
        System.out.println("getRequestURL start");
        System.out.println("getRequestURL:  " + req.getRequestURL());
        System.out.println("getRequestURL end");

        //
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String title = "HTTP Header 请求实例 - 菜鸟教程实例";
        String docType = "<!DOCTYPE html> \n";
        out.println(docType +
                "<html>\n" +
                "<head><meta charst=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>Header 名称</th><th>Header 值</th>\n" +
                "</tr>\n");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String paramName = headerNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n");
            String paramValue = req.getHeader(paramName);
            out.println("<td>" + paramValue + "<td></tr>\n");
        }
        out.println("</table>\n</body></html>");
        req.setAttribute("姓名","玄今男");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
    private void printlnEnumerationLocales(Enumeration<?> enumeration){
        System.out.println("attribute start");
        while (enumeration.hasMoreElements()){
            Object attributeName =  enumeration.nextElement();
            System.out.print(attributeName + "\t");
            System.out.println();
        }
    }
}
