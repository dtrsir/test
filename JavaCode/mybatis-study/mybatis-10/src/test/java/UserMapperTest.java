import com.zhong.dao.user.UserMapper;
import com.zhong.pojo.User;
import com.zhong.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserMapperTest {

    //通过userCode获取User
    @Test
    public  void getLoginUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getLoginUser("admin");
        System.out.println("当前登陆的用户是" + user);
        sqlSession.close();
    }

    //增加用户信息
    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Calendar instance = Calendar.getInstance();
        instance.set(2001,10,10);
        Date time = instance.getTime();
        Date currentDate = new Date();
        int age = currentDate.getYear() - time.getYear();

        User user = new User(19, "test", "test", "123456", 1, time, "13387676765", "广东省广州市增城区朱村大道XXX", 1, 1, currentDate, null, null, age,"系统管理员");
        int row = mapper.add(user);

        if (row > 0) {
            System.out.println("=========================");
            System.out.println("insert success!!");
            System.out.println("=========================");
        }else {
            System.out.println("=========================");
            System.out.println("fail success!!");
            System.out.println("=========================");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    //通过条件查询userList
    @Test
    public void getUserListTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> test = mapper.getUserList("test", null, null, null);
        for (User user : test) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    //通过条件查询-用户记录数
    @Test
    public void getUserCountTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.getUserCount("test", null);

        System.out.println("根据条件查询到的用户数为:" + row);

        sqlSession.close();
    }

    //通过userId删除user
    @Test
    public void deleteUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int row = mapper.deleteUserById(19);

        if (row > 0) {
            System.out.println("=========================");
            System.out.println("delete success!!");
            System.out.println("=========================");
        }else {
            System.out.println("=========================");
            System.out.println("delete fail!!");
            System.out.println("=========================");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //通过useId获取user
    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(18);
        System.out.println(user);
        sqlSession.close();
    }

    //修改用户信息
    @Test
    public void modifyTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Date date = new Date();

        mapper.modify(new User(19, null, null, null, null, null, null, null, null, null, null, 1, date, null, null));


        sqlSession.commit();
        sqlSession.close();

    }

    //修改当前用户密码
    @Test
    public void updatePwdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updatePwd(19, "111111");

        sqlSession.commit();
        sqlSession.close();
    }

}
