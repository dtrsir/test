package com.ossjk.asset.device.controller;

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
import com.ossjk.asset.device.dao.Devicetype;
import com.ossjk.asset.device.dao.DevicetypeDao;
import com.ossjk.asset.device.service.DevicetypeService;
import com.ossjk.asset.system.pojo.User;

public class DevicetypeServlet extends BaseServlet {

	private DevicetypeService service = new DevicetypeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 业务逻辑代码
		String method = req.getParameter("method");

		if ("list".equals(method)) {

			service.list(req);
			// 导航list.jsp
			forward(req, resp, "/WEB-INF/page/device/deviceType/list.jsp");
		} else if ("toUpdate".equals(method)) {
			service.toUpdate(req);
			forward(req, resp, "/WEB-INF/page/device/deviceType/edit.jsp");
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

			try {
				// 执行更新
				if (service.update(getParamtoObject(Devicetype.class, req)) == 1) {
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
				forward(req, resp, "/WEB-INF/page/device/deviceType/edit.jsp");
			} catch (Exception e) {
				redirect(req, resp, req.getContextPath() + "/system/index.do?method=toError");
			}
		} else if ("insert".equals(method)) { // 完成添加

			try {
				Devicetype dt = getParamtoObject(Devicetype.class, req);

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
		doGet(req, resp);
	}

}
