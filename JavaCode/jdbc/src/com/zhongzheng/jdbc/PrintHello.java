package com.zhongzheng.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhongzheng.jdbcUtils.Utils;

public class PrintHello {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet re = null;

        try {
            conn = Utils.getConnection();
            // 在数据库中关闭自动提交之后需要手动开启事务，但是在Java程序中关闭自动提交之后，事务自动开启，不需要手动去开启
            conn.setAutoCommit(false);
            String sql1 = "update `account` set `money` = `money` - 100 where `name` = 'A'";
            pst = conn.prepareStatement(sql1);
            pst.executeUpdate();
            
            int x = 1/0;//让事务失败测试回滚
            
            String sql2 = "update `account` set `money` = `money` + 100 where `name` = 'B'";
            pst = conn.prepareStatement(sql2);
            pst.executeUpdate();
            conn.commit();//提交事务
            System.out.println("事务成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
                System.out.println("事务失败，回滚成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }finally {
            Utils.release(conn, pst, re);
        }
    }
}