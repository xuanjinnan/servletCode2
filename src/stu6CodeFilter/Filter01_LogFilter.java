package stu6CodeFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(servletNames = "stu3HttpRequest.DisplayHeader")
public class Filter01_LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String site = filterConfig.getInitParameter("Site");
        System.out.println("网站名称:" + site);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("网点名称：http://www.runoob.com");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
