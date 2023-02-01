package com.zhong.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//操作数据库的公共类
public class BaseDao {

    private static String driver;
    private static String url;
    private static String userName;
    private static String password;

    //静态代码块，类加载的时候会初始化
    static {
        //类加载器读取资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        //使用类装载器读取properties中的配置
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        userName = properties.getProperty("userName");
        password = properties.getProperty("password");
    }

    //获取数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, userName, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    //查询公共方法会返回一个结果集，传递参数方便在外部关闭资源
    public static ResultSet executeQuery(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement, String sql, Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        //传参
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1, params[i]);
        }
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //增删改公共方法，返回受影响的行数
    public static int executeUpdate(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) throws SQLException {
        preparedStatement = connection.prepareStatement(sql);
        //传参
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i+1,params[i]);
        }
        int updateRow = preparedStatement.executeUpdate();
        return updateRow;
    }

    //释放资源
    public static boolean closeResource(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) {
        //标志位，判断是否关闭成功
        boolean flag = true;

        //当传进来的的资源存在才进行关闭
        if(resultSet!=null) {
            try {
                resultSet.close();
                //GC回收
                resultSet = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        if(preparedStatement!=null) {
            try {
                preparedStatement.close();
                //GC回收
                preparedStatement = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }

        if(connection!=null) {
            try {
                connection.close();
                //GC回收
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }

}
