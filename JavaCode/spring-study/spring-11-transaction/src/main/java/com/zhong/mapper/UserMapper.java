package com.zhong.mapper;

import com.zhong.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> selectUser();

    //增加一个用户
    int addUser(User user);

    //删除一个用户
    int deleteUser(@Param("id") int id);
}
