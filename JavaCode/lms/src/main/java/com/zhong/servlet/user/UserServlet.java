package com.zhong.servlet.user;

import com.zhong.pojo.Role;
import com.zhong.pojo.User;
import com.zhong.service.role.RoleService;
import com.zhong.service.role.RoleServiceImpl;
import com.zhong.service.user.UserService;
import com.zhong.service.user.UserServiceImpl;
import com.zhong.utils.Constants;
import com.zhong.utils.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得参数method
        String method = req.getParameter("method");
        if (method.equals("query") && method != null) {
            this.query(req, resp);
        } else if (method.equals("pwdModify") && method != null) {
            this.pwdModify(req, resp);
        }else if (method.equals("add") && method != null) {
            this.add(req,resp);
        }else if (method.equals("viewUser") && method != null) {
            this.viewUser(req, resp);
        }else if (method.equals("userModify") && method != null) {
            this.userModify(req, resp);
        }else if (method.equals("viewUserByModify") && method != null) {
            this.viewUserByModify(req, resp);
        }else if (method.equals("delete") && method != null) {
            this.delete(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //=========================这里写servlet方法实现一个综合的servlet复用=============================
    //修改当前用户密码
    public void pwdModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);
        int id = user.getId();
        String pwd = req.getParameter("newPassword");

        boolean flag = userService.updatePwd(id, pwd);

        if (flag) {
            req.setAttribute("successMessage", "密码修改成功请退出重新登陆");
            req.setAttribute("successCode", 1);
            req.getSession().removeAttribute(Constants.USER_SESSION);
            req.getRequestDispatcher("pwdModify.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", "修改失败");
            req.getRequestDispatcher("pwdModify.jsp").forward(req, resp);
        }


    }

    //查询用户
    public void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        HashMap map = new HashMap();

        String userName = req.getParameter("queryUserName");
        String userRole = req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");

        if (userName != null && !userName.equals("")) {
            map.put("userName", userName);
        } else if (userRole != null && !userRole.equals("0")) {
            map.put("userRole", userRole);
        }


        //设置分页
        int pageSize = Constants.PAGE_SIZE;//一般在实际应用中会写到配置文件中方便后期修改
        int currentPageNo = 1;


        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户总数
        int totalCount = userService.getUserCount(map);//userName, userRole
        //总页数支持
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();

        //控制首页和尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        map.put("from",(currentPageNo - 1) * pageSize);
        map.put("pageSize",pageSize);

        List<User> userList = userService.queryUser(map);
        List<Role> roleList = roleService.queryRole();


        req.setAttribute("userList", userList);
        req.getSession().setAttribute("roleList", roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        /*搜索框数据保持*/
        req.setAttribute("queryUserName",userName);
        req.setAttribute("queryUserRole",userRole);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }

    //添加用户
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();

        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String userPassword = req.getParameter("userPassword");
        int gender = Integer.parseInt(req.getParameter("gender"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String phone = req.getParameter("phone");
        int userRole = Integer.parseInt(req.getParameter("userRole"));

        Role role = roleService.getRoleById(userRole);
        String roleName = role.getRoleName();

        int userCount = userService.getUserCount(new HashMap());

        Date date = new Date();
        int age = date.getYear() - birthday.getYear();

        User user = new User(userCount+1, userCode,userName,userPassword,gender,birthday,phone,userRole,1,date,null,null,roleName,age);

        boolean flag = userService.addUser(user);

        if (flag){
            resp.sendRedirect("user.do?method=query");
        }else {
            req.setAttribute("errorMessage", "添加用户失败");
            req.getRequestDispatcher("jsp/useradd.jsp").forward(req,resp);
        }

    }

    //查看用户
    public void viewUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        UserService userService = new UserServiceImpl();
        String uid = req.getParameter("userId");
        int userId = 0;
        User user = null;
        if (uid != null && uid != "") {
            userId = Integer.parseInt(uid);
            user = userService.getUserByID(userId);
        }
        Date birthday = user.getBirthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String format = simpleDateFormat.format(birthday);


        if (user != null) {
            req.setAttribute("user", user);
            req.setAttribute("birthday", format);
            req.getRequestDispatcher("userView.jsp").forward(req, resp);
        }

    }

    //修改用户前查询
    public void viewUserByModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        UserService userService = new UserServiceImpl();
        RoleService roleService = new RoleServiceImpl();
        List<Role> roleList = roleService.queryRole();
        String uid = req.getParameter("userId");
        int userId = 0;
        User user = null;
        if (uid != null && uid != "") {
            userId = Integer.parseInt(uid);
            user = userService.getUserByID(userId);
        }
        Date birthday = user.getBirthday();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(birthday);
        if (user != null) {
            req.setAttribute("user", user);
            req.setAttribute("birthday", format);
            req.setAttribute("roleList", roleList);
            req.getRequestDispatcher("userModify.jsp").forward(req, resp);
        }
    }


    //修改用户
    public void userModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String userCode = req.getParameter("userCode");
        String userName = req.getParameter("userName");
        String password = req.getParameter("userPassword");
        int gender = Integer.parseInt(req.getParameter("gender"));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(req.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String format = simpleDateFormat.format(birthday);

        String phone = req.getParameter("phone");
        int userRole = Integer.parseInt(req.getParameter("userRole"));

        int userCount = userService.getUserCount(new HashMap());

        User user = new User(userCount, userCode, userName, password ,gender, birthday, phone, userRole, null, null, 1, new Date(), null, null);
        boolean flag = userService.modify(user);

        if (flag) {
            req.setAttribute("successMessage","修改成功，请点击返回");
            req.setAttribute("successCode",1);
            req.setAttribute("user", user);
            req.setAttribute("birthday", format);
            req.getRequestDispatcher("userModify.jsp").forward(req, resp);
        }else {
            req.setAttribute("errorMessage","修改失败");
            req.getRequestDispatcher("userModify.jsp").forward(req, resp);
        }

    }

    //删除用户
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String userId = req.getParameter("userId");
        int id = Integer.parseInt(userId);
        Boolean flag = userService.deleteById(id);

        int currentPage = id / Constants.PAGE_SIZE;


        if (flag) {
            resp.sendRedirect("user.do?method=query&pageIndex="+currentPage);
        }else {
            req.setAttribute("errorDelete", "删除失败");
            resp.sendRedirect("user.do?method=query&pageIndex="+currentPage);
        }
    }
}
