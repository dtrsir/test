package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhongzheng.jdbcUtils.Utils;

public class Test防止SQL注入 {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet re = null;
		try {
			conn = Utils.getConnection();
			String sql = "select * from `users` where `name` = ? and `password` = ?";
			st = conn.prepareStatement(sql);
			//prepareStatement的本质就是将用户传递进来的参数当作字符处理。整体外面包裹引号，并且将里面的类似单引号'之类的字符转义
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
			//释放连接
			Utils.release(conn, st, re);
		}
	

	}

}
