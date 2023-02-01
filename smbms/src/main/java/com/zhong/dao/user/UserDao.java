package com.zhong.dao.user;

import com.zhong.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//用户dao层约束
public interface UserDao {

    //获得登陆的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException;

    //修改当前用户的密码
    public int UpdatePwd(Connection connection, int id, String password) throws SQLException;

    //根据用户名或者用户角色查询用户总数
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException;

    //通过条件查询用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException;

    //添加用户
    public int addUser(Connection connection, User user) throws SQLException;

}
