package com.ossjk.asset.device.dao;

import java.sql.SQLException;
import java.util.List;

import com.ossjk.asset.base.dao.BaseDao;

public class DevicetypeDao extends BaseDao<Devicetype> {
	
	/*public   DevicetypeDao() {
		
		try {
			//内建的简单代码生成
			this.autoGenEntityTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  DRY
		}
	}*/
	  
	
	public static void main(String[] args) {
		DevicetypeDao dao = new  DevicetypeDao();
		System.out.println(dao.getInsertSql());
		try {
			List<Devicetype>   list =    dao.selectAll();
			
			for(Devicetype d:list) {
				System.out.println( d.getName());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
