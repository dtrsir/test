package com.zhong.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from mybatis.user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into mybatis.user(id, name, pwd) values(5, 'xxx', '123456')";
        int update = jdbcTemplate.update(sql);
        return "addUserok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable int id) {
        String sql = "update mybatis.user set name = ?,pwd = ? where id = ?;";
        Object[] objects = new Object[3];
        objects[0] = "aaa";
        objects[1] = "123";
        objects[2] = "5";
        int update = jdbcTemplate.update(sql, objects);
        return "updateUserok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        String sql = "delete from mybatis.user where id = ?";
        int update = jdbcTemplate.update(sql, id);
        return "deleteUserok";
    }


}
