import com.zhong.pojo.Student;
import com.zhong.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml","userBeans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);

        User user = context.getBean("user2", User.class);
        System.out.println(user);

    }
}
