package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//��������
		Class.forName("com.mysql.jdbc.Driver");
		
		//�û���Ϣ��url
		String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=false";
		String username = "root";
		String password = "123456";
		
		//�������ݿ����
		Connection connection = DriverManager.getConnection(url, username, password);
		
		//ִ��sql����
		Statement statement = connection.createStatement();
		
		//ִ��sql
		String sql = "DELETE FROM users WHERE id = 4";
		
		int hangShu = statement.executeUpdate(sql);
		
		if(hangShu>0) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}

		//�ͷ�����
		statement.close();
		connection.close();

	}

}
