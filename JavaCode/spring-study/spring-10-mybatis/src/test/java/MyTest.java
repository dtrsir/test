import com.zhong.mapper.UserMapper;
import com.zhong.pojo.User;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class MyTest {
    @Test
    public void test() throws IOException {
/*        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectUser();
        for (User user : userList) {
            System.out.println(user);
        }*/

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        List<User> userList = userMapper.selectUser();
        for (User user : userList) {
            System.out.println(user);
        }


    }
}
