import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决中文乱码问题
        //让请求和响应都为utf-8，此后此操作将会在过滤器中实现
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String[] hobbys = req.getParameterValues("hobbys");
        String[] sexes = req.getParameterValues("sex");

        System.out.println("============================");
        System.out.println(userName);
        System.out.println(password);
        System.out.println(Arrays.toString(hobbys));
        System.out.println(Arrays.toString(sexes));
        System.out.println("============================");

        //这是通过响应进行重定向
//        resp.sendRedirect("/");
        //这是通过请求，将这个请求转发
        //在jsp中通过动作元素实现<jsp:forward page="xxx.jsp"></jsp:forward>
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
}
