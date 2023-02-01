package com.ossjk.asset.device.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ossjk.asset.base.util.CommonUtil;
import com.ossjk.asset.device.dao.Devicerepair;
import com.ossjk.asset.device.dao.DevicerepairDao;
import com.ossjk.asset.device.dao.Devicetype;




//初始数据展示
public class DevicerepairService {
	
	// 依赖关系
	//业务层和dao层打交道，提前做好一个dao层对象
	private DevicerepairDao dao = new DevicerepairDao();
	
	
	//将初始数据传递给控制层
	public void list(HttpServletRequest req){
		// 列表的数据
		try {
			List<Devicerepair> datas = dao.selectAll();
		    // 数据放到请求作用域
	        req.setAttribute("records", datas);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//将用户选中的数据项id传给dao层处理
	public void toUpdate(HttpServletRequest req){
		// 列表的数据
		try {
			//从请求中提取用户选中的数据项
			String id = req.getParameter("id");
			 // 数据放到请求作用域
            req.setAttribute("record", dao.selectById(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int update(Devicerepair org){
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
	
	public int insert(Devicerepair nobj) {
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
