package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Que {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//用户信息和url
		String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username = "root";
		String password = "123456";
		
		//连接数据库对象
		Connection connection = DriverManager.getConnection(url, username, password);
		
		//执行sql对象
		Statement statement = connection.createStatement();
		
		//执行sql
		String sql = "SELECT * FROM users";
		
		ResultSet resultset = statement.executeQuery(sql);
		
		while(resultset.next()) {
			System.out.println("id="+resultset.getObject("id"));
			System.out.println("name="+resultset.getObject("name"));
			System.out.println("pwd="+resultset.getObject("password"));
			System.out.println("email="+resultset.getObject("email"));
			System.out.println("birth="+resultset.getObject("birthday"));
			System.out.println("========================================");
		}
		//释放连接
		resultset.close();
		statement.close();
		connection.close();

	}

}
