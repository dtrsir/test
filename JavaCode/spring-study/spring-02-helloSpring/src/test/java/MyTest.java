import com.zhong.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    public static void main(String[] args) {
        //这里，如果使用xml来创建对象的话，必须使用new ClassPathXmlApplicationContext来加载xml文件
        //这个方法的参数是可变长参数，我们可以传入多个值
        //获取spring的上下文对象(拿到spring容器)
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        //对象都在spring中进行管理，如果要使用，要取出来
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
