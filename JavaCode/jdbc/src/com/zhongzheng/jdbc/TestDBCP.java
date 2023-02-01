package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhongzheng.jdbcUtils.JdbcUtils_DBCP;
import com.zhongzheng.jdbcUtils.Utils;

public class TestDBCP {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet re = null;
		//�������ݿ����
		try {
			conn = JdbcUtils_DBCP.getConnection();
			//ִ��sql����
			st = conn.createStatement();
			//ִ��sql
			String sql = "INSERT INTO `users`(`id`,`name`,`password`,`email`,`birthday`)"
					+ "VALUES(4,'wuming','123456','wuming@qq.com','2021-01-01');";
			int hangShu = st.executeUpdate(sql);
			if(hangShu>0) {
				System.out.println("����ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ͷ�����
			JdbcUtils_DBCP.release(conn, st, re);
		}
	}

}
