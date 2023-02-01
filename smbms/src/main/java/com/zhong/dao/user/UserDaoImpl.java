package com.zhong.dao.user;

import com.mysql.jdbc.StringUtils;
import com.zhong.dao.BaseDao;
import com.zhong.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {

    //得到登陆的用户
    public User getLoginUser(Connection connection, String userCode) throws SQLException {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from smbms_user where userCode=?";
            Object[] params = {userCode};

            resultSet = BaseDao.executeQuery(connection, resultSet, preparedStatement, sql, params);
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setCreationDate(resultSet.getDate("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getDate("modifyDate"));
            }
            //通过查询公共方法来实现
            BaseDao.closeResource(null, resultSet, preparedStatement);
        }
        return user;

    }

    //修改当前用户密码
    public int UpdatePwd(Connection connection, int id, String password) throws SQLException {
        PreparedStatement preparedStatement = null;
        int execute = 0;

        if (connection!=null) {
            String sql = "update smbms_user set userPassword = ? where id = ?";
            Object[] param = {password,id};
            //通过增删改公共方法
            execute = BaseDao.executeUpdate(connection, preparedStatement, sql, param);
            //关闭资源
            BaseDao.closeResource(null,null,preparedStatement);
        }
        return execute;
    }

    //根据用户名或者用户角色查询用户总数
    public int getUserCount(Connection connection, String userName, int userRole) throws SQLException{
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count = 0;

        if (connection!=null){
            //拼接sql语句
            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();

            //根据用户名模糊查询
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }

            //根据用户角色查询（需要前端显示角色名称）
            if (userRole>0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }

            //封装参数
            Object[] param = list.toArray();

            System.out.println("UserDaoImpl-->getUserCount:" + sql.toString());//后台日志

            resultSet = BaseDao.executeQuery(connection, resultSet, preparedStatement, sql.toString(), param);
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            BaseDao.closeResource(null, resultSet,preparedStatement);
        }
        return count;
    }

    //通过条件查询用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<User>();

        if (connection!=null) {
            StringBuffer sql = new StringBuffer();
            sql.append("select u.*, r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");
            //封装参数
            ArrayList<Object> list = new ArrayList<Object>();

            //根据用户名模糊查询
            if (!StringUtils.isNullOrEmpty(userName)) {
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }

            //根据用户角色查询（需要前端显示角色名称）
            if (userRole>0) {
                sql.append(" and u.userRole = ?");
                list.add(userRole);
            }

            //分页
            sql.append(" order by creationDate DESC limit ?,?");
            currentPageNo = (currentPageNo-1)*pageSize;
            list.add(currentPageNo);
            list.add(pageSize);

            //封装参数
            Object[] param = list.toArray();

            System.out.println("UserDaoImpl-->getUserList : " + sql.toString());//后台日志输出

            resultSet = BaseDao.executeQuery(connection, resultSet, preparedStatement, sql.toString(), param);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));

                user.setGender(resultSet.getInt("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setUserRole(resultSet.getInt("userRole"));
                user.setUserRoleName(resultSet.getString("userRoleName"));
                userList.add(user);
            }
            BaseDao.closeResource(null,resultSet,preparedStatement);
        }
        return userList;
    }

    //添加用户
    public int addUser(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = null;
        int updateRow = 0;



        if (connection!=null) {
            String sql = "insert into smbms_user(userCode,userName,userPassword,gender,birthday,phone,address,userRole,createdBy,creationDate)\n" +
                    "value ('zz','zz','000000',2,'1981-10-10','18127254565','111',2,?,?)";

            //封装参数
            Date date = new Date();
            LocalDateTime localDateTime = LocalDateTime.now();

            Object[] params = {user.getUserCode(),user.getUserName(),user.getUserPassword(),user.getGender(),user.getBirthday(),user.getPhone(),user.getAddress(),user.getUserRole(),user.getCreatedBy(),localDateTime};

            System.out.println("UserDaoImpl-->addUser : " + sql.toString());//后台日志输出

            updateRow = BaseDao.executeUpdate(connection, preparedStatement, sql, params);


            BaseDao.closeResource(null,null,preparedStatement);

        }
        return updateRow;
    }
}
