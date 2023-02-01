package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delet {

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
		String sql = "DELETE FROM users WHERE id = 4";
		
		int hangShu = statement.executeUpdate(sql);
		
		if(hangShu>0) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}

		//释放连接
		statement.close();
		connection.close();

	}

}
