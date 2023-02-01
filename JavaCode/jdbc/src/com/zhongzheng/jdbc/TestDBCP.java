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
		//连接数据库对象
		try {
			conn = JdbcUtils_DBCP.getConnection();
			//执行sql对象
			st = conn.createStatement();
			//执行sql
			String sql = "INSERT INTO `users`(`id`,`name`,`password`,`email`,`birthday`)"
					+ "VALUES(4,'wuming','123456','wuming@qq.com','2021-01-01');";
			int hangShu = st.executeUpdate(sql);
			if(hangShu>0) {
				System.out.println("插入成功");
			}else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放连接
			JdbcUtils_DBCP.release(conn, st, re);
		}
	}

}
