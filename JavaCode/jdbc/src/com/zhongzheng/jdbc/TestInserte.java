package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhongzheng.jdbcUtils.Utils;

public class TestInserte {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = Utils.getConnection();
			//Ԥ�����Statemen�������ʹ��?ռλ�������������
			String sql = "INSERT INTO `users`(`id`,`name`,`password`,`email`,`birthday`) VALUES(?,?,?,?,?);";
			st = conn.prepareStatement(sql);//��Ҫ��дsql�����ܱ�ִ��
			st.setInt(1, 4);
			st.setString(2, "zhong");
			st.setString(3, "123456");
			st.setString(4, "992683167@qq.com");
			// new java.util.Date().getTime() ���ʱ���
			//new Date(XXX) ��Javaʱ���װ��һ��sql��ʹ�õ�ʱ��
			st.setDate(5, new Date(new java.util.Date().getTime()));
			//��statement�����������ǵ�statement����ִ�е�ʱ����Ҫ����sql�����Ϊ����
			//Ԥ�����statement�������ֱ�ӵ���ִ�У�����Ҫ�����������Ϊ֮ǰ����Ԥ�����statement�����ʱ���Ѿ����ݹ�sql������
			int hangShu = st.executeUpdate();
			if(hangShu>0) {
				System.out.println("����ɹ�");
			}else {
				System.out.println("����ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ͷ�����
			Utils.release(conn, st, null);
		}
	

	}

}
