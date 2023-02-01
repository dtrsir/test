package com.zhong.service.user;

import com.zhong.dao.BaseDao;
import com.zhong.dao.user.UserDao;
import com.zhong.dao.user.UserDaoImpl;
import com.zhong.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //dao层对象
    private UserDao userDao;
    //实例初始化的时候引入dao层对象
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    //用户登陆业务
    public User login(String userCode, String userPassword) {
        Connection connection = null;
        User user = null;

        //获得数据库连接
        connection = BaseDao.getConnection();
        try {
            //调用dao层方法登陆用户
            user = userDao.getLoginUser(connection, userCode);
            //用户输入错误密码
            if ( user!=null && !user.getUserPassword().equals(userPassword)) {
                user = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {//关闭资源
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    //用户修改密码业务
    public boolean updatePwd(int id, String pwd) {
        Connection connection = null;
        boolean flag = false;


        //修改密码
        try {
            connection = BaseDao.getConnection();
            //将受影响的行数转变为修改成功与否
            if (userDao.UpdatePwd(connection,id,pwd)>0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {//释放资源
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    //查询用户数量
    public int getUserCount(String userName, int userRole) {
        Connection connection = null;
        int userCount = 0;

        try {
            connection = BaseDao.getConnection();
            userCount = userDao.getUserCount(connection, userName, userRole);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userCount;
    }

    //根据条件查询用户列表
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<User> userList = null;

        System.out.println("userName ---> " + userName);
        System.out.println("userRole ---> " + userRole);
        System.out.println("currentPageNo ---> " + currentPageNo);
        System.out.println("pageSize ---> " + pageSize);

        try {
            connection = BaseDao.getConnection();
            userList = userDao.getUserList(connection, userName, userRole, currentPageNo, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userList;
    }

    //添加用户
    public boolean addUser(User user) {
        Connection connection = null;
        boolean flag = false;


        try {
            connection = BaseDao.getConnection();
            int i = userDao.addUser(connection, user);
            if (i>0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
}
