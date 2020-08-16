package stu6CodeFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
@WebFilter(servletNames = "stu3HttpRequest.DisplayHeader",filterName = "AFilter")
public class Filter02_AuthenFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("name");
        System.out.println("过滤器获取请求参数：" + name);
        System.out.println("第二个过滤器执行 -- 网站名称：www.runoob.com");
        if("123".equals(name)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletResponse.setContentType("text/html;charset=UTF-8");
            PrintWriter out = servletResponse.getWriter();
            out.print("<b>name 不正确，请求被拦截，不能访问 web 资源</b>");
            System.out.println("name 不正确，请求被拦截，不能访问 web 资源");
        }

    }

    @Override
    public void destroy() {

    }
}
