package com.zhong.controller;

import com.zhong.mapper.UserMapper;
import com.zhong.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public String queryUserList() {
        List<User> userList = userMapper.queryUserList();
        return userList.toString();

    }

}
