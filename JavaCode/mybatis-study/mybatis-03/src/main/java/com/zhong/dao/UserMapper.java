package com.zhong.dao;

import com.zhong.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserByLimit(Map<String,Object> map);

    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);


    int updateUser(User user);

    int deleteUser(int id);

}
