package stu11FileUpload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    //上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    //上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;    //  3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;      //  40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;   //  50MB

    /**
     * 上传数据及保存文件
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(req)) {
            //如果不是则停止
            PrintWriter out = resp.getWriter();
            out.println("Error: 表单必须包含 enctype=multipart/form-data");
            out.flush();
            return;
        }

        //配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        String temdir = System.getProperty("java.io.tmpdir");
        System.out.println(temdir);
        //设置临时存储目录
        factory.setRepository(new File(temdir));

        //根据工厂创建上传处理对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        //设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        //设置最大请求值（包含文件和表单数据）
        upload.setSizeMax(MAX_REQUEST_SIZE);
        //中文处理
        upload.setHeaderEncoding("UTF-8");

        String dotPath = req.getServletContext().getRealPath("./");
        System.out.println(dotPath);
        String uploadPath = dotPath  + UPLOAD_DIRECTORY;
        System.out.println("本地文件保存路径：" + uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(req);
            if (fileItems != null && fileItems.size() > 0) {
                for (FileItem item : fileItems) {
                    if(!item.isFormField()){
                        String itemName = item.getName();
                        String fileName = new File(itemName).getName();
                        System.out.println("itemName:" + itemName + "\t" + "fileName:" + fileName);
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        System.out.println("filePath" + filePath);
                        item.write(storeFile);
                        req.setAttribute("message","文件上传成功！");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message","错误信息：" + e.getMessage());
        }
        req.getServletContext().getRequestDispatcher("/message.jsp").forward(req,resp);
    }
}
