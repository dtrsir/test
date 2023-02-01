package com.zhong.controller;

import com.zhong.Utils.Constants;
import com.zhong.Utils.PageSupport;
import com.zhong.pojo.Role;
import com.zhong.pojo.User;
import com.zhong.service.role.RoleService;
import com.zhong.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;


    //跳转到添加用户的界面
    @RequestMapping("/toAddUser")
    public String toAdd(Model model) {
        List<Role> roleList = roleService.roleList();
        model.addAttribute("roleList", roleList);
        return "addUser";
    }

    //添加一个用户
    @RequestMapping("/addUser")
    public String addUser(User user, Model model, String birthday2) throws ParseException {
        user.setCreationDate(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = simpleDateFormat.parse(birthday2);
        user.setBirthday(birthday);
        boolean flag = userService.addUser(user);
        if (flag) {
            model.addAttribute("addMsg", "success");
            return "redirect:/user/userList";
        }else {
            model.addAttribute("addMsg", "fail");
            model.addAttribute("user", user);
            return "addUser";
        }

    }

    /*条件查询用户（查询所有用户）展示所有用户。
    展示条件查询用户:角色，姓名，年龄:starDate， endDate，性别。
    分页：from，pageSize*/
    //用户管理请求
    @RequestMapping("/userList")
    public String queryUser(HttpServletRequest request, Model model) throws ParseException {
        String flag = (String) request.getAttribute("flag");
        if (request.getAttribute("userList") != null && !("query".equals(flag))) {
            return "userList";
        }
        HashMap map = new HashMap();

        String queryUserName =  request.getParameter("queryUserName");
        String queryGender = request.getParameter("queryGender");
        String queryUserRole = request.getParameter("queryUserRole");
        String starAge = request.getParameter("starAge");
        String endAge = request.getParameter("endAge");
        String pageIndex = request.getParameter("pageIndex");


        //处理年龄转变出生日期问题
        Calendar nowTime = Calendar.getInstance();
        int nowYear = nowTime.get(Calendar.YEAR);

        if (queryUserName != null && !"".equals(queryUserName)) {
            map.put("userName", queryUserName);
        }
        if (queryGender != null && !"".equals(queryGender)) {
            map.put("gender", Integer.parseInt(queryGender));
        }
        if (queryUserRole != null && !"".equals(queryUserRole)) {
            map.put("userRole", Integer.parseInt(queryUserRole));
        }
        if (starAge != null && endAge != null && !"".equals(starAge) && !"".equals(endAge)) {
            //获取出生年份 = 当前年份 - 当前年龄
            int endYear = nowYear - Integer.parseInt(starAge);
            int starYear = nowYear - Integer.parseInt(endAge);
            map.put("starDate", starYear+"-01-01");
            map.put("endDate", endYear+"-12-31");
        }


        //设置分页
        int pageSize = Constants.PAGE_SIZE;//一般在实际应用中会写到配置文件中方便后期修改
        int currentPageNo = 1;

        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户总数
        int totalCount = userService.userCount(map);//userName, userRole
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


        List<Role> roleList = roleService.roleList();
        List<User> userList = userService.queryUser(map);//没有使用pojo分类

        //出生日期转变年龄
        for (User user : userList) {
            nowTime.setTime(user.getBirthday());
            int year = nowTime.get(Calendar.YEAR);
            user.setAge(nowYear - year);
            //设置角色名
            for (Role role : roleList) {
                if (role.getId() == user.getUserRole()) {
                    user.setRoleName(role.getRoleName());
                }
            }
        }
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);
        /*搜索框数据保持*/
        model.addAttribute("queryUserName",queryUserName);
        model.addAttribute("queryGender",queryGender);
        model.addAttribute("queryUserRole",queryUserRole);
        model.addAttribute("starAge",starAge);
        model.addAttribute("endAge",endAge);
        /**/
        model.addAttribute("userList", userList);
        model.addAttribute("roleList", roleList);
        return "userList";
    }

    //用户登陆请求
    @RequestMapping("/login")
    public String userLogin(String userCode, String password, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User userlogined = (User) request.getSession().getAttribute("user");

        if (userlogined == null) {
            //后台校验
            if (userCode != null && password != null) {
                //校验成功，获取登陆用户
                User user = userService.getLoginUser(userCode);

                //账号，密码验证
                if (user != null && user.getPassword().equals(password)) {
                    Calendar instance = Calendar.getInstance();
                    user.setAge(instance.get(Calendar.YEAR) - user.getBirthday().getYear());
                    Role role = roleService.queryRole(user.getUserRole());
                    user.setRoleName(role.getRoleName());
                    session.setAttribute("user", user);
                    //转发至首页
                    return "frame";
                }
                model.addAttribute("loginFailMsg", "账号或密码错误");
                return "login";
            }
            //校验失败，回到登陆页
            model.addAttribute("loginFailMsg", "账号或密码为空，登陆失败");
            return "login";
        }
        //重新加载页面
        return "frame";
    }

    //用户注销
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "login";
    }

    //跳转到修改用户的页面
    @RequestMapping("/toModifyUser/{userId}")
    public String toModify(@PathVariable("userId") String id, Model model) {
        User user = userService.getUserById(Integer.parseInt(id));
        Role role = roleService.queryRole(user.getUserRole());
        List<Role> roleList = roleService.roleList();
        user.setRoleName(role.getRoleName());
        Date date = new Date();
        int age = date.getYear() - user.getBirthday().getYear();
        user.setAge(age);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(user.getBirthday());
        model.addAttribute("birthday2", format);
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "modifyUser";
    }

    //修改用户
    @RequestMapping("/modifyUser")
    public String modifyUser(User user, String birthday2) throws ParseException {
        user.setModifyDate(new Date());
        System.out.println(user.getUserRole());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(birthday2);
        user.setBirthday(parse);
        boolean b = userService.modifyUser(user);
        System.out.println(b+"==================================================");
        return "redirect:/user/userList";
    }

    //删除用户
    @RequestMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") String  userId, Model model) {
        boolean deleteFlag = userService.deleteUser(Integer.parseInt(userId));
        model.addAttribute("deleteFlag", deleteFlag);
        return "redirect:/user/userList";
    }

    //跳转到修改用户密码页面
    @RequestMapping("/toModifyPassword")
    public String toModifyPassword() {
        return "modifyPassword";
    }

    //修改当前用户密码
    @RequestMapping("modifyPassword")
    public String modifyPassword(int id, String password, HttpServletRequest request) {
        boolean modifyPasswordFlag = userService.modifyPassword(id, password);
        if (modifyPasswordFlag) {
            request.getSession().removeAttribute("user");
            return "login";
        }else {
            return "modifyPassword";
        }
    }


}
