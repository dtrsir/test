package com.ossjk.asset.device.controller;

import com.ossjk.asset.base.servlet.BaseServlet;
import com.ossjk.asset.base.util.AjaxReturn;
import com.ossjk.asset.base.util.Constant;
import com.ossjk.asset.device.dao.Device;
import com.ossjk.asset.device.dao.Devicetype;
import com.ossjk.asset.device.service.DeviceService;
import com.ossjk.asset.device.service.DevicetypeService;
import com.ossjk.asset.system.pojo.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeviceServlet
 */
@WebServlet("/device/device.do")
public class DeviceServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DeviceService service = new DeviceService();
	private DevicetypeService dpservice = new DevicetypeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 业务逻辑代码
		String method = request.getParameter("method");

		if ("list".equals(method)) {
            
			service.list(request);
			forward(request, response, "/WEB-INF/page/device/device/list.jsp");
		 
		} else if ("toInsert".equals(method)) { // 准备添加
			
			dpservice.list(request);
			
			try {
				forward(request, response, "/WEB-INF/page/device/device/edit.jsp");
			} catch (Exception e) {
				redirect(request, response, request.getContextPath() + "/system/index.do?method=toError");
			}
			

		} else if ("insert".equals(method)) { // 完成添加
			try {
				Device dv = getParamtoObject(Device.class, request);
				
				//购买人:当前用户
				User me = (User)request.getSession().getAttribute(Constant.SESSION_USER_KEY);
				dv.setCreator(me.getId());

				if (service.insert(dv) == 1) {
					renderAjaxReturn(response,
					new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS));
				} else {
					renderAjaxReturn(response, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
				}
			} catch (Exception e) {
				renderAjaxReturn(response, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
