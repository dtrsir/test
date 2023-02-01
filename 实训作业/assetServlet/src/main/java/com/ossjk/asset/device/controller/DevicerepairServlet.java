package com.ossjk.asset.device.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ossjk.asset.base.servlet.BaseServlet;
import com.ossjk.asset.base.util.AjaxReturn;
import com.ossjk.asset.base.util.Constant;
import com.ossjk.asset.device.dao.Devicerepair;
import com.ossjk.asset.device.dao.Devicetype;
import com.ossjk.asset.device.service.DeviceService;
import com.ossjk.asset.device.service.DevicerepairService;



//控制层，接收用户请求，将请求转给业务层区做，如何接收业务层返回的请求，做视图层的视图跳转

//配置求请求路径
@WebServlet("/device/deviceRepair.do")
//继承连接数据库的类
public class DevicerepairServlet extends BaseServlet {
	//需要和业务层打交道，这里做一个业务层对象
	private DevicerepairService service = new DevicerepairService();
	
	//接收视图层过来的请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 业务逻辑代码,判读用户请求过来的操作
		//这里将用户的操作做成变量，方便后续使用
		String method = req.getParameter("method");
		
		//list请求代表用户刚刚进入这个页面，需要我们展示初始数据和这个页面的桌面标签
		if ("list".equals(method)) {
			//这里将请求交给业务层，让业务层把初始数据传回来
			//这时候传递回来的数据将会放到这个req中，名叫records
			service.list(req);
			// 导航到list.jsp
			forward(req, resp, "/WEB-INF/page/device/deviceRepair/list.jsp");
			
			//toUpdata请求就代表用户准备修改它选定的数据，这时用户修改的数据在请求中传递过来
		} else if ("toUpdate".equals(method)) {
			//我们将请求转给业务层去处理
			service.toUpdate(req);
			//导航到edit.jsp
			forward(req, resp, "/WEB-INF/page/device/deviceRepair/edit.jsp");
		}else if("repair".equals(method)){
			//我们将请求转给业务层去处理
			service.toUpdate(req);
			//导航到repairEdit.jsp
			forward(req, resp, "/WEB-INF/page/device/deviceRepair/repairEdit.jsp");
		} else if ("update".equals(method)) {

			// 封装数据 1.取得表单数据
			/*
			 * String id = req.getParameter("id"); String name = req.getParameter("name");
			 * String brand = req.getParameter("brand"); String intlcode =
			 * req.getParameter("intlcode"); String model = req.getParameter("model");
			 * String remarks = req.getParameter("remarks"); String asl =
			 * req.getParameter("asl"); String anrv = req.getParameter("anrv");
			 * 
			 * Devicetype org = dao.selectById(id); org.setAnrv(Double.parseDouble(anrv));
			 * org.setAsl(Double.parseDouble(asl)); org.setBrand(brand);
			 * org.setIntlcode(intlcode); org.setModel(model); org.setName(name);
			 * org.setRemarks(remarks);
			 */
			//阿贾克斯异步请求，不需要修改
			try {
				// 执行更新
				if (service.update(getParamtoObject(Devicerepair.class, req)) == 1) {
					renderAjaxReturn(resp,
							new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS));
				} else {
					renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
				}
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));

		} else if ("delete".equals(method)) {

			if (service.delete(req) == 1) {
				renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS));
			} else {
				renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
			}
		} else if ("toInsert".equals(method)) { // 准备添加
			try {
				forward(req, resp, "/WEB-INF/page/device/deviceRepair/edit.jsp");
			} catch (Exception e) {
				redirect(req, resp, req.getContextPath() + "/system/index.do?method=toError");
			}
		} else if ("insert".equals(method)) { // 完成添加

			try {
				Devicerepair dt = getParamtoObject(Devicerepair.class, req);
				
				String damagedate  = req.getParameter("damagedate");
				dt.setDamagedate( new SimpleDateFormat("yyyy-MM-dd").parse(damagedate)   );
				
				String repairdate  = req.getParameter("repairdate");
				dt.setRepairdate( new SimpleDateFormat("yyyy-MM-dd").parse(repairdate)   );

				if (service.insert(dt) == 1) {
					renderAjaxReturn(resp,
							new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS));
				} else {
					renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
				}
			} catch (Exception e) {
				renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
			}
		} else if ("batchDelete".equals(method)) { // 批量删除

			if (service.batchDelete(req)) {
				renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_SUCCESS, Constant.RETURN_MESSAGE_SUCCESS));
			} else {
				renderAjaxReturn(resp, new AjaxReturn(Constant.RETURN_CODE_ERROR, Constant.RETURN_MESSAGE_ERROR));
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
