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
			//预编译的Statemen对象就是使用?占位符来代替变量的
			String sql = "INSERT INTO `users`(`id`,`name`,`password`,`email`,`birthday`) VALUES(?,?,?,?,?);";
			st = conn.prepareStatement(sql);//需要先写sql，才能被执行
			st.setInt(1, 4);
			st.setString(2, "zhong");
			st.setString(3, "123456");
			st.setString(4, "992683167@qq.com");
			// new java.util.Date().getTime() 获得时间戳
			//new Date(XXX) 把Java时间包装成一个sql能使用的时间
			st.setDate(5, new Date(new java.util.Date().getTime()));
			//和statement对象的区别就是当statement对象执行的时候需要传入sql语句作为参数
			//预编译的statement对象可以直接调用执行，不需要传入参数，因为之前生成预编译的statement对象的时候已经传递过sql参数了
			int hangShu = st.executeUpdate();
			if(hangShu>0) {
				System.out.println("插入成功");
			}else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放连接
			Utils.release(conn, st, null);
		}
	

	}

}
