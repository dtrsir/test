package com.zhong.controller;

import com.zhong.pojo.User;
import com.zhong.service.role.RoleService;
import com.zhong.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class AjaxController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    //校验新用户账号唯一性
    @RequestMapping("ajaxUserCode")
    public String ajaxUserCode(String userCode) {
        List<User> userList = userService.queryUser(new HashMap());
        for (User user : userList) {
            if (user.getUserCode().equals(userCode)) {
                return "fail";
            }else if (userCode.equals("")) {
                return "fail";
            }else {
                return "ok";
            }
        }
        return "ok";
    }

    @RequestMapping("countAge")
    public String countAge(String birthday) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(birthday);
        Calendar instance = Calendar.getInstance();
        Date time = instance.getTime();
        int year = time.getYear();
        int age = year - parse.getYear();
        return age+"";
    }
}
