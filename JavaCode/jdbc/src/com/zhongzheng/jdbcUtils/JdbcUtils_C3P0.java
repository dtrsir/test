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
			//C3P0ʹ��xml�����ļ������Բ���Ҫ�����ֶ���ȡ�ļ�
			//��������Դ ������ģʽ��
			dataSource = new ComboPooledDataSource("MySQL");
			//Ҳ���Բ�ʹ��xml�ļ�������ã��ڴ�����ֱ�����ã�һ�㲻��ôʹ�ã�
//			dataSource = new ComboPooledDataSource();
//			//�������ݿ�����
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
