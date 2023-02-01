package com.ossjk.asset.device.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ossjk.asset.base.util.CommonUtil;
import com.ossjk.asset.device.dao.Devicetype;
import com.ossjk.asset.device.dao.DevicetypeDao;

public class DevicetypeService {
	
	
	// 依赖关系
	private DevicetypeDao dao = new DevicetypeDao();
	

	public void list(HttpServletRequest req){
		// 列表的数据
		try {
			List<Devicetype> datas = dao.selectAll();
		    // 数据放到请求作用域
	        req.setAttribute("records", datas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void toUpdate(HttpServletRequest req){
		// 列表的数据
		try {
			String id = req.getParameter("id");
			
			 // 数据放到请求作用域
            req.setAttribute("record", dao.selectById(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int update(Devicetype org){
		// 列表的数据
		try {
			org.setMdtm(CommonUtil.getDate());
			//执行更新
			return dao.updateBySelected(org) ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0 ;
	}
	
	public int delete(HttpServletRequest req){
		// 列表的数据
		try {
			String id = req.getParameter("id");
			//执行更新
			return dao.delete(id) ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0 ;
	}
	
	public int insert(Devicetype nobj) {
		try {
			nobj.setCrtm(CommonUtil.getDate());
			nobj.setMdtm(CommonUtil.getDate());
			//执行更新
			return dao.insert(nobj) ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0 ;
		
	}
	
	public boolean batchDelete(HttpServletRequest req) {
		try {
			String[] ids = req.getParameterValues("ids");
			  
			return dao.batchDelete(ids) == ids.length;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
	

}
