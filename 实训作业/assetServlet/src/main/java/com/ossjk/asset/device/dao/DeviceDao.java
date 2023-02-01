package com.ossjk.asset.device.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ossjk.asset.base.dao.BaseDao;
import com.ossjk.asset.device.vo.DeviceVo;

public class DeviceDao extends BaseDao<Device> {
	
	public   DeviceDao() {
		
	/*	try {
			super.autoGenEntityTitle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public java.util.List<DeviceVo> listVo(){
		
		try {
			
			java.util.List<DeviceVo> datas = new ArrayList();
			
			Connection conn = super.getConnection();
			
			Statement smt = conn.createStatement();
			
			java.sql.ResultSet rs = smt.executeQuery("select d.id,d.code,u.name as creatorName,dp.name as dtname from device d left join user u on d.creator = u.id left join devicetype dp on d.dtid = dp.id");
		 
			 while( rs.next()  ) {
				 //封装对象
				 DeviceVo dv =  super.autoSetter(rs, DeviceVo.class);
				 datas.add(dv);
			}
			 smt.close();
			 conn.close();
			 
			 return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		new DeviceDao();
	}

}
