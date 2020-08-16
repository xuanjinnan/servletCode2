package stu11FileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("name");
        //防止读取name乱码
        fileName = new String(fileName.getBytes("iso-8859-1"), "UTF-8");
        System.out.println("文件名：" + fileName);

        //设置文件MIME类型
        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType(fileName);
        resp.setContentType(mimeType);
        //设置Content-Disposition
        resp.setHeader("Content-Dispostion","attachment;filename=" + fileName);

        //获取要下载的文件绝对路径，web/download目录下
        String fullFileName = servletContext.getRealPath("/download/" + fileName);

        //输入流为项目文件，输出流指向浏览器
        InputStream is = new FileInputStream(fullFileName);
        ServletOutputStream os = resp.getOutputStream();

        /**
         * 设置缓冲区
         * is.read(b)当文件读取完时返回-1
         */
        int len = -1;
        byte[] b = new byte[1024];
        while((len=is.read(b)) != -1){
            os.write(b,0,len);
        }
        //关闭流
        is.close();
        os.close();
    }
}
