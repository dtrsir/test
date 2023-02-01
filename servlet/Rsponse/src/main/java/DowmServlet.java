import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class DowmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取文件的下载路径
        String path = "D:\\sourceCode\\servlet\\response-download\\src\\main\\resources\\喵.jpg";
        //2、获取文件名
        String fileName = path.substring((path.lastIndexOf('\\')) + 1);//将路径中最后一个/的下标返回然后从这个下标的后一位开始截取子串
        //3、让浏览器支持我们下载的东西
        resp.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));// 固定写法  使用URLEncoder解决中文乱码问题
        //4、获取文件的输入流，将文件拿到Java代码中
        FileInputStream in = new FileInputStream(path);
        //5、创建缓冲区
        int len;
        byte[] buffer = new byte[1024];
        //6、获取resp的输出流
        ServletOutputStream out = resp.getOutputStream();
        //7、将Java中的文件输出到响应
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        //8、关闭流
        out.close();
        in.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
