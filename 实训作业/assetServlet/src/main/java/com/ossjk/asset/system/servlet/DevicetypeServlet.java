package com.ossjk.asset.system.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ossjk.asset.base.servlet.BaseServlet;
import com.ossjk.asset.base.util.AjaxReturn;
import com.ossjk.asset.base.util.CommonUtil;
import com.ossjk.asset.base.util.Constant;
import com.ossjk.asset.system.dao.DevicetypeDao;
import com.ossjk.asset.system.pojo.Devicetype;
import com.ossjk.asset.system.pojo.User;

public class DevicetypeServlet extends BaseServlet {

	// 依赖关系
	private DevicetypeDao dao = new DevicetypeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 业务逻辑代码
		String method = req.getParameter("method");
		try {
			if ("list".equals(method)) {

				// 列表的数据
                List<Devicetype> datas =  dao.selectAll();
                // 数据放到请求作用域
                req.setAttribute("records", datas);
                //导航list.jsp
                forward(req, resp, "/WEB-INF/page/device/deviceType/list.jsp");
			}else if ("toUpdate".equals(method)) {
				String id = req.getParameter("id");
				
				 // 数据放到请求作用域
                req.setAttribute("record", dao.selectById(id));
                forward(req, resp, "/WEB-INF/page/device/deviceType/edit.jsp");
			}else if ("update".equals(method)) {
	 
			     //封装数据  1.取得表单数据
				/*
				String id = req.getParameter("id");
				String name = req.getParameter("name");
				String brand = req.getParameter("brand");
				String intlcode = req.getParameter("intlcode");
				String model = req.getParameter("model");
				String remarks = req.getParameter("remarks");
				String asl = req.getParameter("asl");
				String anrv = req.getParameter("anrv");
				
				Devicetype org =  dao.selectById(id);
				org.setAnrv(Double.parseDouble(anrv));
				org.setAsl(Double.parseDouble(asl));
				org.setBrand(brand);
				org.setIntlcode(intlcode);
				org.setModel(model);
				org.setName(name);
				org.setRemarks(remarks);
				*/
				
			
				try {
					Devicetype org = getParamtoObject(Devicetype.class, req);
					org.setMdtm(CommonUtil.getDate());
					//执行更新
					if (dao.updateBySelected(org) > 0) {
						renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS));
					} else {
						renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
					}
					return;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
