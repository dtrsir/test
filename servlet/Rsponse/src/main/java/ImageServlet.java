import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //让浏览器每隔多少秒就刷新一次
        resp.setHeader("refresh","5");


        //首先，在内存中创建一张空白的图，并指定图片颜色显示RGB三原色
        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //拿到这张图的画笔，设置画笔的颜色为白色，用画笔填充整张图片为白色
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);
        //再次设置画笔的颜色，写字需要给画笔设置字体
        graphics.setColor(Color.blue);
        graphics.setFont(new Font(null,Font.BOLD,20));
        graphics.drawString(makeNumber(),0,20);//设置好画笔之后，将要写的数据传入画笔的drawxxxxx方法中
        //设置响应的头，告诉浏览器这个请求用图片方式打开
        resp.setContentType("image/jpeg");
        //让浏览器不缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-Cache");
        resp.setHeader("Pragma","no-Cache");

        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());


    }

    private String makeNumber() {
        Random random = new Random();//创建一个随机数生成器
        String num = random.nextInt(9999999) + "";//通过nextint方法指定随机数生成的范围，但是有可能达不到我们要求的7位数
        StringBuffer stringBuffer = new StringBuffer();//接下来处理缺少的位，创建一个StringBuffer方便我们对缺少的位追加0
        for (int i = 0; i < 7 - num.length(); i++) {
            //检测缺少几位，就追加几个0
            stringBuffer.append("0");
        }
        num = stringBuffer.toString() + num;//通过拼接字符串来对前面缺少的位补0
        return num;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
