package com.ossjk.asset.device.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ossjk.asset.base.util.CommonUtil;
import com.ossjk.asset.device.dao.Device;
import com.ossjk.asset.device.dao.DeviceDao;
import com.ossjk.asset.device.dao.Devicetype;
import com.ossjk.asset.device.dao.DevicetypeDao;
import com.ossjk.asset.device.vo.DeviceVo;

public class DeviceService {
	
	
	// 依赖关系
	private DeviceDao dao = new DeviceDao();
	

	public void list(HttpServletRequest req){
		// 列表的数据
		//List<DeviceVo> datas = dao.listVo();
		// 数据放到请求作用域
	    req.setAttribute("records",  dao.listVo());
	}
	
	  
	public int insert(Device nobj) {
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
	 
	
	
	

}
