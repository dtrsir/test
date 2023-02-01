import com.zhong.config.MyConfig;
import com.zhong.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        //在配置文件中，方法名就是bean的名字
        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser.getName());
    }
}
