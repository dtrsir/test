package com.zhongzheng.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils_C3P0 {
	private static ComboPooledDataSource dataSource = null;
	
	
	
	static {
		try {
			//C3P0使用xml配置文件，所以不需要我们手动读取文件
			//创建数据源 （工厂模式）
			dataSource = new ComboPooledDataSource("MySQL");
			//也可以不使用xml文件里的配置，在代码中直接配置（一般不这么使用）
//			dataSource = new ComboPooledDataSource();
//			//配置数据库连接
//			dataSource.setDriverClass(null);
//			dataSource.setUser(null);
//			dataSource.setPassword(null);
//			dataSource.setJdbcUrl(null);
//			
//			dataSource.setMaxPoolSize(0);
//			dataSource.setMinPoolSize(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//释放连接
	public static void release(Connection connection, Statement statement, ResultSet resultSet){
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
