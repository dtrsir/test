import com.zhong.dao.user.UserMapper;
import com.zhong.pojo.User;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserMapperTest {

    //通过账户名(唯一)查询用户
    @Test
    public void getUserByUserCodeTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User admin = mapper.getUserByUserCode("admin");
        System.out.println("==============================");
        System.out.println(admin);
        System.out.println("==============================");

        sqlSession.close();
    }

    //通过id(唯一)获取用户
    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println("===================================");
        System.out.println(user);
        System.out.println("===================================");


        sqlSession.close();
    }

    //条件查询用户。用户名称，性别，年龄，电话号码，用户角色（分页from和pageSize）
    @Test
    public void getUserListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("from", 0);
        map.put("pageSize", 5);
        map.put("gender", 1);
//        map.put("gender", "admin");

        List<User> userList = mapper.getUserList(map);

        System.out.println("============================");
        for (User user : userList) {
            System.out.println(user);
        }
        System.out.println("============================");

        sqlSession.close();
    }

    //增加用户
    @Test
    public void addUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Calendar instance = Calendar.getInstance();
        instance.set(2001, 3,1);
        Date time = instance.getTime();
        int age = time.getYear() - new Date().getYear();
        User user = new User(4, "test", "test", "123456", 1, time, "1812725XXXX", 1, 1, new Date(), null, null, null, age);
        int i = mapper.addUser(user);

        sqlSession.commit();
        sqlSession.close();
    }

    //通过条件统计用户数，性别，用户名称，年龄，用户角色
    @Test
    public void getUserCountTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap map = new HashMap();
        map.put("gender", 1);
        int userCount = mapper.getUserCount(map);
        System.out.println(userCount);

        sqlSession.close();
    }

    //通过id删除用户
    @Test
    public void deleteByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteById(4);

        sqlSession.commit();
        sqlSession.close();
    }

    //修改某一个用户
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(4, null, null, null, null, null, null, null, null, null, 1, new Date(), null, null);
        int modify = mapper.modify(user);

        sqlSession.commit();
        sqlSession.close();
    }

    //修改当前用户的密码
    @Test
    public void updatePwdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updatePwd(4, "111111");

        sqlSession.commit();
        sqlSession.close();
    }

}
