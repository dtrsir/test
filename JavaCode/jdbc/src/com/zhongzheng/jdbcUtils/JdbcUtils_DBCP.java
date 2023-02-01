package com.zhongzheng.jdbcUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils_DBCP {
	private static DataSource dataSource = null;
	
	
	
	static {
		try {
			InputStream in = Utils.class.getClassLoader().getSystemResourceAsStream("dbcpconfig.properties");
			Properties properties = new Properties();
			properties.load(in);
			//��������Դ ������ģʽ��
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��ȡ����
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	
	//�ͷ�����
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
