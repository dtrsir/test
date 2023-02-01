package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhongzheng.jdbcUtils.Utils;

public class Test��ֹSQLע�� {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet re = null;
		try {
			conn = Utils.getConnection();
			String sql = "select * from `users` where `name` = ? and `password` = ?";
			st = conn.prepareStatement(sql);
			//prepareStatement�ı��ʾ��ǽ��û����ݽ����Ĳ��������ַ�������������������ţ����ҽ���������Ƶ�����'֮����ַ�ת��
			st.setString(1, " ' or '1=1");
			st.setString(2, "123456");
			re = st.executeQuery();
			while(re.next()) {
				System.out.println(re.getString("name"));
				System.out.println(re.getString("password"));
				System.out.println("===================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ͷ�����
			Utils.release(conn, st, re);
		}
	

	}

}
