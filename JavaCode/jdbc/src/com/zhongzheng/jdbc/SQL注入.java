package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhongzheng.jdbcUtils.Utils;

public class SQLע�� {

	public static void main(String[] args) {
		try {
//			login(" ' or '1=1", "123456"); //SQLע�룬�ɲ�ѯ�����û���Ϣ
			login(" ' or '1=1' #", ""); //SQLע�룬�ɲ�ѯ�����û���Ϣ
//			login("zhangshan", "123456");// ������½
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	public static void login(String username, String password) throws SQLException {
		Connection conn = null;
		Statement st = null;
		ResultSet re = null;
		conn = Utils.getConnection();
		st = conn.createStatement();
		String sql = "select * from `users` where `name` = '" + username + "' and `password` = '" + password + "'";
		re = st.executeQuery(sql);
		while(re.next()) {
			System.out.println(re.getString("name"));
			System.out.println(re.getString("password"));
		}
		Utils.release(conn, st, re);
	}

}
