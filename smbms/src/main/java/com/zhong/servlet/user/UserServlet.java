package com.zhong.servlet.user;

import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;
import com.zhong.pojo.Role;
import com.zhong.pojo.User;
import com.zhong.service.role.RoleService;
import com.zhong.service.role.RoleServiceImpl;
import com.zhong.service.user.UserService;
import com.zhong.service.user.UserServiceImpl;
import com.zhong.util.Constants;
import com.zhong.util.PageSupport;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//实现servlet复用，通过前端传递的method参数来决定调用哪一个方法
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得参数method
        String method = req.getParameter("method");
        if (method.equals("savepwd")&&method!=null) {
            this.updatePwd(req,resp);
        }else if (method.equals("pwdmodify")&&method!=null) {
            this.pwdModify(req,resp);
        }else if (method.equals("query")&&method!=null) {
            this.query(req,resp);
        }else if (method.equals("add")) {
            this.add(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //修改密码
    public void updatePwd(HttpServletRequest req, HttpServletResponse resp) {
        //从请求中获得session来取出用户信息
        Object user = req.getSession().getAttribute(Constants.USER_SESSION);
        //获得新密码
        String newpassword = req.getParameter("newpassword");
        boolean flag = false;

        //引入业务层对象，并调用修改密码的方法，返回成功标志
        if (user!=null && !StringUtils.isNullOrEmpty(newpassword)) {
            UserService userService = new UserServiceImpl();
            flag = userService.updatePwd(((User) user).getId(), newpassword);
            if (flag) {
                req.setAttribute("message","密码修改成功，请退出，使用新密码登陆");
                req.getSession().removeAttribute(Constants.USER_SESSION);
            }else {
                req.setAttribute("message","密码修改失败");
            }
        }else {
            req.setAttribute("message","新密码有问题");
        }
        try {//相当于重新刷新一遍网页
            req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //验证旧密码
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp) {
        //获取session和旧密码
        Object user = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        //利用map的键值对来封装需要传递的不同的消息
        HashMap<String, String> map = new HashMap<String, String>();

        if (user==null) {
            map.put("result","sessionerror");
        }else if (StringUtils.isNullOrEmpty(oldpassword)) {
            map.put("result","error");
        }else {
            String userPassword = ((User) user).getUserPassword();
            if (oldpassword.equals(userPassword)) {
                map.put("result","true");
            }else {
                map.put("result","false");
            }
        }

        resp.setContentType("application/json");
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //查询用户列表
    public void query(HttpServletRequest req, HttpServletResponse resp){
        //用户列表

        //从前端获得参数
        String queryName = req.getParameter("queryname");
        String temp = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole = 0;

        //获取用户列表
        UserService userService = new UserServiceImpl();
        List<User> userList = null;

        //
        int pageSize = 5;//一般在实际应用中会写到配置文件中方便后期修改
        int currentPageNo = 1;

        if (queryName==null) {
            queryName = "";
        }
        if (temp!=null && !temp.equals("")) {
            queryUserRole = Integer.parseInt(temp);
        }

        if (pageIndex!=null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }

        //获取用户总数
        int totalCount = userService.getUserCount(queryName, queryUserRole);
        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();

        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        }else if (currentPageNo>totalPageCount) {
            currentPageNo= totalPageCount;
        }

        //获取用户列表展示
        userList = userService.getUserList(queryName,queryUserRole,currentPageNo,pageSize);
        req.setAttribute("userList",userList);

        //查询角色列表
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryName);
        req.setAttribute("queryUserRole",queryUserRole);

        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //增加用户
    public void add(HttpServletRequest req, HttpServletResponse resp){
        User user = null;
        boolean flag = false;

        //获取前端参数
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String userRole = req.getParameter("userRole");
        Object createByUser = req.getSession().getAttribute(Constants.USER_SESSION);




        if (address==null) {
            address = "";
        }


        Date date = new Date(birthday);

        user = new User();
        user.setUserCode(userCode);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setGender(Integer.parseInt(gender));
        user.setBirthday(date);
        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(Integer.parseInt(userRole));
        user.setCreatedBy(((User)createByUser).getUserRole());

        UserService userService = new UserServiceImpl();
        flag = userService.addUser(user);
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        if (flag) {
            req.setAttribute("message","密码修改成功，请退出，使用新密码登陆");
        }else {
            req.setAttribute("message","密码修改失败");
        }

        try {//相当于重新刷新一遍网页
            req.getRequestDispatcher("useradd.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
