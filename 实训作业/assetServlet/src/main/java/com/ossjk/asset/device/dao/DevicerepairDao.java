package com.ossjk.asset.device.dao;

import java.sql.SQLException;
import java.util.List;

import com.ossjk.asset.base.dao.BaseDao;

public class DevicerepairDao extends BaseDao<Devicerepair> {
	public   DevicerepairDao() {
	
		/*
		 * try { //内建的简单代码生成 this.autoGenEntityTitle(); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
}

	public static void main(String[] args) {
		DevicerepairDao dao = new DevicerepairDao();
		System.out.println(dao.getInsertSql());
		try {
			List<Devicerepair>   list =    dao.selectAll();
			
			for(Devicerepair d:list) {
				System.out.println( d.getId());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
