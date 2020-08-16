import javax.servlet.*;
import java.io.IOException;

public class ServletBasicDemo implements Servlet {
    /**
     * 第一次创建Servlet是被调用，在后续每次用户请求时不在调用
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 执行任务的主要方法。Web服务器调用service()方法来处理客户端的请求，并把格式响应写回给客户端
     * 检查请求类型，
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 至被调用一次，在Servlet生命周期结束时调用。
     * 可以关闭数据库连接、停止后台线程、吧cookie列表或点击计数器写入磁盘，并执行其他类似的清理活动
     */
    @Override
    public void destroy() {

    }
}
